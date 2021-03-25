package com.lonely.wolf.note;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lonely_wolf
 * @version 1.0
 * @date 2021/3/21
 * @since jdk1.8
 */
@Configuration
public class MyAutoConfiguration {

    @Bean
    public JsonSerial jsonSerial(){
        return new JsonSerial();
    }
}
