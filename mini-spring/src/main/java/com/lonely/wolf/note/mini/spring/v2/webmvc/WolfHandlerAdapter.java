package com.lonely.wolf.note.mini.spring.v2.webmvc;

import com.lonely.wolf.note.mini.spring.annotation.WolfRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/15
 * @since jdk1.8
 */
public class WolfHandlerAdapter {

    public boolean supports(Object handler){
        return (handler instanceof WolfHandlerMapping);
    }

    public WolfModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        WolfHandlerMapping wolfHandlerMapping = (WolfHandlerMapping)handler;


        Map<String,Integer> paramIndexMapping = new HashMap<>();
        Annotation[] [] pa = wolfHandlerMapping.getMethod().getParameterAnnotations();
        for (int i = 0; i < pa.length ; i ++) {
            for(Annotation a : pa[i]){
                if(a instanceof WolfRequestParam){
                    String paramName = ((WolfRequestParam) a).value();
                    if(!"".equals(paramName.trim())){
                        paramIndexMapping.put(paramName, i);
                    }
                }
            }
        }

        Class<?> [] paramsTypes = wolfHandlerMapping.getMethod().getParameterTypes();
        for (int i = 0; i < paramsTypes.length ; i ++) {
            Class<?> type = paramsTypes[i];
            if(type == HttpServletRequest.class ||
                    type == HttpServletResponse.class){
                paramIndexMapping.put(type.getName(),i);
            }
        }

        Object [] paramValues = new Object[paramsTypes.length];
        Map<String,String[]> params = request.getParameterMap();

        //循环赋值参数
        for (Map.Entry<String, String[]> parm : params.entrySet()) {
            String value = Arrays.toString(parm.getValue()).replaceAll("\\[|\\]","")
                    .replaceAll("\\s",",");

            if(!paramIndexMapping.containsKey(parm.getKey())){continue;}

            int index = paramIndexMapping.get(parm.getKey());
            paramValues[index] = caseStringValue(value,paramsTypes[index]);
        }
        //赋值request
        if(paramIndexMapping.containsKey(HttpServletRequest.class.getName())) {
            int reqIndex = paramIndexMapping.get(HttpServletRequest.class.getName());
            paramValues[reqIndex] = request;
        }
        //赋值response
        if(paramIndexMapping.containsKey(HttpServletResponse.class.getName())) {
            int respIndex = paramIndexMapping.get(HttpServletResponse.class.getName());
            paramValues[respIndex] = response;
        }

        //反射调用方法
        Object result = wolfHandlerMapping.getMethod().invoke(wolfHandlerMapping.getController(),paramValues);
        if(result == null || result instanceof Void){ return null; }

        boolean isModelAndView = wolfHandlerMapping.getMethod().getReturnType() == WolfModelAndView.class;
        if(isModelAndView){
            return (WolfModelAndView) result;
        }
        return null;
    }


    private Object caseStringValue(String value, Class<?> paramsType) {
        if(String.class == paramsType){
            return value;
        }
        //如果是int
        if(Integer.class == paramsType){
            return Integer.valueOf(value);
        }
        else if(Double.class == paramsType){
            return Double.valueOf(value);
        }else {
            if(value != null){
                return value;
            }
            return null;
        }

        //...

    }
}
