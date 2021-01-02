package com.lonely.wolf.note.mq.rabbit.springboot.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zwx
 * @version 1.0
 * @date 2020/12/6
 * @since jdk1.8
 */
@RestController
@RequestMapping("/hello")
public class HelloRabbitController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
//    @Autowired
//    private AmqpTemplate amqpTemplate;

    @GetMapping(value="/send")
    public String clearVipInfo(@RequestParam(value = "msg",defaultValue = "no message") String msg){
        //交换机可以默认为空
        rabbitTemplate.convertAndSend("SIMPLE_QUEUE",msg);
        return "succ";
    }
}
