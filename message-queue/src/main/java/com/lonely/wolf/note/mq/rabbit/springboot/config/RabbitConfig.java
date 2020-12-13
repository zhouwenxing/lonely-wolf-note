package com.lonely.wolf.note.mq.rabbit.springboot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/6
 * @since jdk1.8
 */
@Configuration
public class RabbitConfig {

//    @Bean
//    public ConnectionFactory connectionFactory() throws Exception {
////        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
////        cachingConnectionFactory.setUri("amqp://admin:123456@localhost:5672");
////        return cachingConnectionFactory;
////    }

    @Bean("simpleRabbitQueue")
    public Queue getFirstQueue(){
//        Map<String, Object> args = new HashMap<String, Object>();
//        args.put("name","双子孤狼");
//        Queue queue = new Queue("SIMPLE_QUEUE", false, false, true, args);
//        return queue;
        return new Queue("SIMPLE_QUEUE");
    }

}
