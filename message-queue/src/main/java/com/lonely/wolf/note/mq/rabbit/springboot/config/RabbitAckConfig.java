package com.lonely.wolf.note.mq.rabbit.springboot.config;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 监听消息，实现手动应答。不要和ExchangeConsumer类中的manualDirectConsumer方法同时使用
 * @author zwx
 * @version 1.0
 * @date 2021/1/2
 * @since jdk1.8
 */
//@Configuration
public class RabbitAckConfig {
    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames("LONGLY_WOLF_ORDER_QUEUE");//设置监听队列名
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);//手动确认
        container.setMessageListener((ChannelAwareMessageListener) (message, channel) -> {      //消息处理
            System.out.println("收到消息：" + new String(message.getBody()) + "。此消息需要手动应答");
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        });
        return container;
    }
}
