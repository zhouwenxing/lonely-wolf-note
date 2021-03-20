package com.lonely.wolf.note.mini.spring.v2.webmvc;

import com.lonely.wolf.note.mini.spring.annotation.WolfController;
import com.lonely.wolf.note.mini.spring.annotation.WolfGetMapping;
import com.lonely.wolf.note.mini.spring.v1.HandlerMapping;
import com.lonely.wolf.note.mini.spring.v2.context.WolfApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/13
 * @since jdk1.8
 */
public class WolfDispatcherServlet extends HttpServlet {
    private final String CONTEXT_CONFIG_LOCATION = "defaultConfig";
    private WolfApplicationContext context;

    private List<WolfHandlerMapping> handlerMappings = new ArrayList<>();//路径映射
    private Map<WolfHandlerMapping,WolfHandlerAdapter> handlerAdapters = new HashMap<>();//参数处理
    private WolfViewResolver viewResolver;//模板处理

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            this.doDispatcher(req,resp);
        }catch (Exception e){
            resp.getWriter().write("500 Exception,Details:\r\n" + Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]", "").replaceAll(",\\s", "\r\n"));
            e.printStackTrace();
        }

    }


    private void doDispatcher(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //获取请求路径，匹配HandlerMapping
        String requestUrl = this.formatUrl(request.getRequestURI());
        WolfHandlerMapping handlerMapping = this.getHandler(requestUrl);
        if (null == handlerMapping){
            processDispatchResult(response,new WolfModelAndView("404"));
            return;
        }

        //获取参数处理器adapter
        WolfHandlerAdapter handlerAdapter = getHandlerAdapter(handlerMapping);

        //实际调用方法，并将结果组装成WolfModelAndView对象
        WolfModelAndView mv = handlerAdapter.handle(request,response,handlerMapping);

        //输出
        processDispatchResult(response,mv);

    }

    private WolfHandlerAdapter getHandlerAdapter(WolfHandlerMapping handlerMapping) {
        if(this.handlerAdapters.isEmpty()){
            return null;
        }
        WolfHandlerAdapter handlerAdapter = this.handlerAdapters.get(handlerMapping);
        if (handlerAdapter.supports(handlerMapping)){
            return handlerAdapter;
        }
        return null;


    }

    //将模板解析为输出流
    private void processDispatchResult(HttpServletResponse response,
                                       WolfModelAndView wolfModelAndView) throws Exception {
        if (null == wolfModelAndView || null == viewResolver){
            return;
        }
        WolfView wolfView = viewResolver.resolveViewName(wolfModelAndView.getViewName());
        wolfView.render(wolfModelAndView.getModel(),response);
        return;
    }

    private WolfHandlerMapping getHandler(String requestUrl) {
        for (WolfHandlerMapping handler : this.handlerMappings) {
            try{
                Matcher matcher = handler.getPattern().matcher(requestUrl);

                if(!matcher.matches()){
                    continue;
                }
                return handler;
            }catch(Exception e){
                throw e;
            }
        }
        return null;
    }


    private String formatUrl(String requestUrl) {
        requestUrl = requestUrl.replaceAll("/+","/");
        if (requestUrl.lastIndexOf("/") == requestUrl.length() -1){
            requestUrl = requestUrl.substring(0,requestUrl.length() -1);
        }
        return requestUrl;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        context = new WolfApplicationContext(config.getInitParameter(CONTEXT_CONFIG_LOCATION));

        //初始化Spring MVC 九大功能组件
        initStrategies(context);
    }

    private void initStrategies(WolfApplicationContext context) {
        //多文件上传的组件
//        initMultipartResolver(context);
        //初始化本地语言环境
//        initLocaleResolver(context);
        //初始化模板处理器
//        initThemeResolver(context);


        //handlerMapping
        initHandlerMappings(context);
        //初始化参数适配器
        initHandlerAdapters(context);
        //初始化异常拦截器
//        initHandlerExceptionResolvers(context);
        //初始化视图预处理器
//        initRequestToViewNameTranslator(context);


        //初始化视图转换器
        initViewResolvers(context);
        //参数缓存器
//        initFlashMapManager(context);
    }

    private void initViewResolvers(WolfApplicationContext context) {
        String templateRoot = context.getConfig().getProperty("templateRoot");
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();

//        String[] templates = new File(templateRootPath).list();
        //保存模板
        viewResolver = new WolfViewResolver(templateRoot);
    }

    private void initHandlerAdapters(WolfApplicationContext context) {
        //HandlerMapping和HandlerAdapter一一对应
        for (WolfHandlerMapping handlerMapping : this.handlerMappings) {
            this.handlerAdapters.put(handlerMapping,new WolfHandlerAdapter());
        }
    }

    private void initHandlerMappings(WolfApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames){
            Object controller = context.getBean(beanName);
            if (null == controller){
                continue;
            }
            Class<?> clazz = controller.getClass();
            if (!clazz.isAnnotationPresent(WolfController.class)){
                continue;
            }

            String requestUrl = "";//请求路径

            //controller类上的请求路径
//            if (clazz.isAnnotationPresent(WolfController.class)){
//                WolfGetMapping
//                requestUrl =
//            }

            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (!method.isAnnotationPresent(WolfGetMapping.class)){
                    continue;
                }

                WolfGetMapping wolfGetMapping = method.getAnnotation(WolfGetMapping.class);
                String regex = ("/" + requestUrl + "/" + wolfGetMapping.value()).replaceAll("/+", "/");
                Pattern pattern = Pattern.compile(regex);
                this.handlerMappings.add(new WolfHandlerMapping(pattern,controller,method));
            }


        }
    }
}
