package com.lonely.wolf.note.mini.spring.v2.webmvc;

import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/14
 * @since jdk1.8
 */
public class WolfHandlerMapping {

    private Object controller;	//保存方法对应的实例
    private Method method;		//保存映射的方法
    private Pattern pattern;    //URL的正则匹配

    public WolfHandlerMapping(Pattern pattern,Object controller, Method method) {
        this.controller = controller;
        this.method = method;
        this.pattern = pattern;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

}
