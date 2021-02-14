package com.lonely.wolf.note.mq.rabbit.springboot.delayQueue.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/2/1
 * @since jdk1.8
 */
@Configuration
public class PluginDelayRabbitConfig {

    @Bean("pluginDelayExchange")
    public CustomExchange pluginDelayExchange() {
        Map<String, Object> argMap = new HashMap<>();
        argMap.put("x-delayed-type", "direct");//必须要配置这个类型，可以是direct,topic和fanout
        //第二个参数必须为x-delayed-message
        return new CustomExchange("PLUGIN_DELAY_EXCHANGE","x-delayed-message",false, false, argMap);
    }

    @Bean("pluginDelayQueue")
    public Queue pluginDelayQueue(){
        return new Queue("PLUGIN_DELAY_QUEUE");
    }

    @Bean
    public Binding pluginDelayBinding(@Qualifier("pluginDelayQueue") Queue queue,@Qualifier("pluginDelayExchange") CustomExchange customExchange){
        return BindingBuilder.bind(queue).to(customExchange).with("delay").noargs();
    }

}
