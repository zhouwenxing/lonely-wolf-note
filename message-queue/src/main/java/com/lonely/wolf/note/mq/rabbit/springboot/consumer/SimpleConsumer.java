package com.lonely.wolf.note.mq.rabbit.springboot.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/6
 * @since jdk1.8
 */
@RabbitListener(queues = "SIMPLE_QUEUE")
@Component
public class SimpleConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("收到消息：" + msg);
    }
}
