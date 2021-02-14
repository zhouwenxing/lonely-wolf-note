package com.lonely.wolf.note.mq.rabbit.springboot.delayQueue.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/1/28
 * @since jdk1.8
 */
//@Configuration
public class TtlDelayRabbitConfig {

    //路由ttl消息交换机
    @Bean("ttlDelayFanoutExchange")
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("TTL_DELAY_FANOUT_EXCHANGE");
    }

    //ttl消息队列
    @Bean("ttlDelayQueue")
    public Queue ttlQueue(){
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("x-message-ttl", 5000);//队列中所有消息5秒后过期
        map.put("x-dead-letter-exchange", "TTL_DELAY_DEAD_LETTER_FANOUT_EXCHANGE");//过期后进入死信队列
        //参数1-name：队列名称
        //参数2-durable：是否持久化
        //参数3-exclusive:是否排他。设置为true时，则该队列只对声明当前队列的连接(Connection)可用,一旦连接断开，队列自动被删除
        //参数4-autoDelete：是否自动删除。前提是必须要至少有一个消费者先连上当前队列，然后当所有消费者都断开连接之后，队列自动被删除
        return new Queue("TTL_QUEUE",false,false,false,map);
    }

    //Fanout交换机和productQueue绑定
    @Bean
    public Binding bindTtlFanoutExchange(@Qualifier("ttlDelayQueue") Queue queue, @Qualifier("ttlDelayFanoutExchange") FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    //fanout死信交换机
    @Bean("ttlDelayDeadLetterExchange")
    public FanoutExchange deadLetterExchange(){
        return new FanoutExchange("TTL_DELAY_DEAD_LETTER_FANOUT_EXCHANGE");
    }


    //死信队列
    @Bean("ttlDelayDeadLetterQueue")
    public Queue ttlDelayDeadLetterQueue(){
        return new Queue("TTL_DELAY_DEAD_LETTER_FANOUT_QUEUE");
    }


    //死信队列和死信交换机绑定
    @Bean
    public Binding deadLetterQueueBindExchange(@Qualifier("ttlDelayDeadLetterQueue") Queue queue, @Qualifier("ttlDelayDeadLetterExchange") FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
