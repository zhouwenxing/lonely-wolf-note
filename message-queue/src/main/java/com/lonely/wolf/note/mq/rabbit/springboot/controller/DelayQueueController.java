package com.lonely.wolf.note.mq.rabbit.springboot.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author zwx
 * @version 1.0
 * @date 2021/1/28
 * @since jdk1.8
 */
@RestController
@RequestMapping("/delay")
public class DelayQueueController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping(value="/ttl/send")
    public String ttlMsgSend(@RequestParam(value = "msg",defaultValue = "no message") String msg,
                             @RequestParam(value = "time") String millTimes){
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setExpiration(millTimes);//单条消息设置过期时间，单位：毫秒
        Message message = new Message(msg.getBytes(), messageProperties);
        rabbitTemplate.convertAndSend("TTL_DELAY_FANOUT_EXCHANGE","",message);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送成功【" + sdf.format(new Date()) + "】");
        return "succ";
    }

    @GetMapping(value="/plugin/send")
    public String pluginMsgSend(@RequestParam(value = "msg",defaultValue = "no message") String msg){
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("x-delay",5000);//延迟5秒被删除
        Message message = new Message(msg.getBytes(), messageProperties);
        amqpTemplate.convertAndSend("PLUGIN_DELAY_EXCHANGE","delay.test",message);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送成功【" + sdf.format(new Date()) + "】");
        return "succ";
    }
}
