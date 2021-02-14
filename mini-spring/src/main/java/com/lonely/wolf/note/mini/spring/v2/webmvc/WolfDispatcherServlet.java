package com.lonely.wolf.note.mini.spring.v2.webmvc;

import com.lonely.wolf.note.mini.spring.annotation.WolfController;
import com.lonely.wolf.note.mini.spring.v2.context.WolfApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/13
 * @since jdk1.8
 */
public class WolfDispatcherServlet extends HttpServlet {
    private final String CONTEXT_CONFIG_LOCATION = "defaultConfig";
    private WolfApplicationContext context;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doDispatcher(req,resp);
    }


    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) {

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
    }

    private void initHandlerAdapters(WolfApplicationContext context) {
    }

    private void initHandlerMappings(WolfApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames){
            Object controller = context.getBean(beanName);
            Class<?> clazz = controller.getClass();
            if (!clazz.isAnnotationPresent(WolfController.class)){
                continue;
            }

            String baseUrl = "";










        }
    }
}
