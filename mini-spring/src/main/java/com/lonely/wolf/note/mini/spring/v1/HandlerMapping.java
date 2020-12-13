package com.lonely.wolf.note.mini.spring.v1;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/3
 * @since jdk1.8
 */
public class HandlerMapping {
    private String requestUrl;
    private Object target;//保存方法对应的实例
    private Method method;//保存映射的方法
    private Map<Integer,String> methodParams;//记录方法参数

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Map<Integer, String> getMethodParams() {
        return methodParams;
    }

    public void setMethodParams(Map<Integer, String> methodParams) {
        this.methodParams = methodParams;
    }
}
