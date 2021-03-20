package com.lonely.wolf.note.springboot.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/3/19
 * @since jdk1.8
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /**
     * 通过名称获取bean
     */
    public static <T>T getBeanByName(String beanName){
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 通过类型获取bean
     */
    public static <T>T getBeanByType(Class<T> clazz){
        return (T) applicationContext.getBean(clazz);
    }
}
