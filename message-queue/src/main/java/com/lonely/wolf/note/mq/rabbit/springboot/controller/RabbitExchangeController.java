package com.lonely.wolf.note.mq.rabbit.springboot.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/6
 * @since jdk1.8
 */
@RestController
@RequestMapping("/exchange")
public class RabbitExchangeController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping(value="/send/direct")
    public String sendDirect(String routingKey,@RequestParam(value = "msg",defaultValue = "no direct message") String msg){
        rabbitTemplate.convertAndSend("LONGLY_WOLF_DIRECT_EXCHANGE",routingKey,msg);
        return "succ";
    }
    @GetMapping(value="/send/topic")
    public String sendTopic(String routingKey,@RequestParam(value = "msg",defaultValue = "no topic message") String msg){
        rabbitTemplate.convertAndSend("LONGLY_WOLF_TOPIC_EXCHANGE",routingKey,msg);
        return "succ";
    }
    @GetMapping(value="/send/fanout")
    public String sendFaout(String routingKey,@RequestParam(value = "msg",defaultValue = "no faout message") String msg){
        rabbitTemplate.convertAndSend("LONGLY_WOLF_FANOUT_EXCHANGE",routingKey,msg);
        return "succ";
    }

    @GetMapping(value="/send/ttl")
    public String sendTtl(String routingKey,@RequestParam(value = "msg",defaultValue = "no ttl message") String msg){
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setExpiration("5000");//5秒后被删除，即TTL属性（针对单条消息）
//        messageProperties.setDeliveryMode(MessageDeliveryMode.PERSISTENT);//消息持久化
        Message message = new Message(msg.getBytes(), messageProperties);
        rabbitTemplate.convertAndSend("LONGLY_WOLF_DIRECT_EXCHANGE",routingKey,message);
        return "succ";
    }

    //publisher-confirm-type参数配置为simple时，使用此种方式发送消息
    @GetMapping(value="/send/confirm")
    public String sendWithSimpleConfirm(String routingKey,@RequestParam(value = "msg",defaultValue = "no direct message") String msg){
        //使用waitForConfirms方法确认
        boolean sendFlag = rabbitTemplate.invoke(operations -> {
            rabbitTemplate.convertAndSend(
                    "LONGLY_WOLF_DIRECT_EXCHANGE",
                    "routingKey",
                    msg
            );
            return rabbitTemplate.waitForConfirms(5000);
        });
        //也可以使用waitForConfirmsOrDie方法确认
        boolean sendFlag2 = rabbitTemplate.invoke(operations -> {
            rabbitTemplate.convertAndSend(
                    "LONGLY_WOLF_DIRECT_EXCHANGE",
                    "routingKey",
                    msg
            );
            try {
                rabbitTemplate.waitForConfirmsOrDie(5000);
            }catch (Exception e){
                return false;
            }
            return true;
        });
        System.out.println(sendFlag);
        System.out.println(sendFlag2);
        return "succ";
    }


    @GetMapping(value="/send/bak")
    public String sendBak(String routingKey,@RequestParam(value = "msg",defaultValue = "no bak message") String msg){
        rabbitTemplate.convertAndSend("LONGLY_WOLF_BAK_ORIGIN_DIRECT_EXCHANGE",routingKey,msg);
        return "succ";
    }

}
