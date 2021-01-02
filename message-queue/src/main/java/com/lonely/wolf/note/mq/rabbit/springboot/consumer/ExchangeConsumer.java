package com.lonely.wolf.note.mq.rabbit.springboot.consumer;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/20
 * @since jdk1.8
 */
@Component
public class ExchangeConsumer {
    /**
     * 监听绑定了direct交换机的的消息队列
     */
//    @RabbitHandler
//    @RabbitListener(queues = "LONGLY_WOLF_ORDER_QUEUE")
//    public void directConsumer(String msg){
//        System.out.println("direct交换机收到消息：" + msg);
//    }

    /**
     * 监听绑定了direct交换机的的消息队列，实现手动应答
     */
    @RabbitHandler
    @RabbitListener(queues = "LONGLY_WOLF_ORDER_QUEUE")
    public void manualDirectConsumer(String msg, Channel channel,Message message) throws IOException {
        System.out.println("direct交换机收到消息：" + msg + "。此消息需要手动应答");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    /**
     * 监听绑定了topic交换机的的消息队列，并进行手动应答
     */
    @RabbitHandler
    @RabbitListener(queues = "LONGLY_WOLF_USER_QUEUE")
    public void topicConsumer(String msg){
        System.out.println("topic交换机收到消息：" + msg);
    }

    /**
     * 监听绑定了fanout交换机的的消息队列
     */
    @RabbitHandler
    @RabbitListener(queues = "LONGLY_WOLF_PRODUCT_QUEUE")
    public void fanoutConsumer(String msg){
        System.out.println("fanout交换机收到消息：" + msg);
    }

    /**
     * 监听ttl消息队列
     */
    @RabbitHandler
//    @RabbitListener(queues = "LONGLY_WOLF_TTL_QUEUE")
    public void ttlConsumer(Message message){
        System.out.println("ttl队列收到消息：" + new String(message.getBody()));
        System.out.println("ttl队列收到消息：" + JSONObject.toJSONString(message.getMessageProperties()));
    }

    /**
     * 监听备份消息队列
     */
    @RabbitHandler
    @RabbitListener(queues = "LONELY_WOLF_BAK_QUEUE")
    public void bakQueueConsumer(Message message){
        System.out.println("备份队列收到消息：" + new String(message.getBody()));
    }
}
