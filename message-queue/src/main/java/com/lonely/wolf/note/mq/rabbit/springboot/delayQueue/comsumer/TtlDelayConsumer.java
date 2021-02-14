package com.lonely.wolf.note.mq.rabbit.springboot.delayQueue.comsumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/1/28
 * @since jdk1.8
 */
//@Component
public class TtlDelayConsumer {

    @RabbitHandler
    @RabbitListener(queues = "TTL_DELAY_DEAD_LETTER_FANOUT_QUEUE")
    public void fanoutConsumer(String msg){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("【延迟队列】【" + sdf.format(new Date()) + "】收到死信队列消息：" + msg);
    }
}
