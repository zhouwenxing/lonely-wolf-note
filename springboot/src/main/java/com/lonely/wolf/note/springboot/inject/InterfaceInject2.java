package com.lonely.wolf.note.springboot.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/3/19
 * @since jdk1.8
 */
@Component
public class InterfaceInject2 {
    @Qualifier("wolf1Bean")
    @Autowired
    private IWolf iWolf;

    @Bean
    public MyElement test(@Autowired Wolf1Bean wolf1Bean){
        return new MyElement();
    }

//    @Bean
//    public MyElement test(@Qualifier("wolf1Bean") IWolf iWolf){
//        return new MyElement();
//    }
}
