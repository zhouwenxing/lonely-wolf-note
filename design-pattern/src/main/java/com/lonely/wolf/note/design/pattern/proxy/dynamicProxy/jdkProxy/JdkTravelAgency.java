package com.lonely.wolf.note.design.pattern.proxy.dynamicProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/11
 * @since jdk1.8
 */
public class JdkTravelAgency implements InvocationHandler {
    private Object target;//被代理对象

    public Object getInstance(Object target){//动态获取代理对象
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target,args);//调用代理对象方法
        after();
        return obj;
    }

    private void before() {
        System.out.println("付定金");
    }

    private void after() {
        System.out.println("付尾款");
    }
}
