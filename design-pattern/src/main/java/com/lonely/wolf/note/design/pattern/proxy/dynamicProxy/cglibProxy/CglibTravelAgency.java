package com.lonely.wolf.note.design.pattern.proxy.dynamicProxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/12
 * @since jdk1.8
 */
public class CglibTravelAgency implements MethodInterceptor {

    public Object getInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();//相当于JDK动态代理中的Proxy类
        enhancer.setSuperclass(clazz);//设置为即将生成的代理类的父类
        enhancer.setCallback(this);//设置回调对象
        return enhancer.create();//相当于JDK动态代理的Proxy.newProxyInstance方法，生成新的字节码文件，并加载到JVM中
    }


    /**
     *
     * @param o - CBLIG生成的代理对象
     * @param method - 被代理对象中被拦截的方法
     * @param objects - 方法中的参数
     * @param methodProxy - 代理对象中对应的方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o,objects);
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
