package com.lonely.wolf.note.springboot.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationObjectSupport;

import javax.annotation.PostConstruct;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/3/19
 * @since jdk1.8
 */
@Component
public class SpringUtil extends /*WebApplicationObjectSupport*/ ApplicationObjectSupport {
    private static ApplicationContext applicationContext = null;

    public static <T>T getBean(String beanName){
        return (T) applicationContext.getBean(beanName);
    }

    @PostConstruct
    public void init(){
        applicationContext = super.getApplicationContext();
    }

}
