package com.lonely.wolf.note.design.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式写法适用于创建实例非常多的情况，便于管理。但是，是非线程安全的
 * 此实现方法为spring中单例写法
 * @author zwx
 * @version 1.0
 * @date 2020/4/21
 * @since jdk1.8
 */
public class ContainerSingleton {
    private ContainerSingleton(){

    }

    private static Map<String,Object> ioc = new ConcurrentHashMap<>();

    public static Object getBean(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object obj = null;
                try {
                    obj = Class.forName(className).newInstance();
                    ioc.put(className,obj);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return obj;
            }
            return ioc.get(className);
        }
    }
}
