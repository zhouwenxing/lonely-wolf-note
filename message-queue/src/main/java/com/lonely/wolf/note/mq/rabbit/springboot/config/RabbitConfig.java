package com.lonely.wolf.note.mq.rabbit.springboot.config;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
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
 * @date 2020/12/6
 * @since jdk1.8
 */
@Configuration
public class RabbitConfig {

//    @Bean
////    public ConnectionFactory connectionFactory() throws Exception {
//////        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
//////        cachingConnectionFactory.setUri("amqp://admin:123456@localhost:5672");
//////        return cachingConnectionFactory;
//////    }

    @Bean("simpleRabbitQueue")
    public Queue getFirstQueue(){
//        Map<String, Object> args = new HashMap<String, Object>();
//        args.put("name","双子孤狼");
//        Queue queue = new Queue("SIMPLE_QUEUE", false, false, true, args);
//        return queue;
        return new Queue("SIMPLE_QUEUE");
    }

    //直连交换机
    @Bean("directExchange")
    public DirectExchange directExchange(){
        return new DirectExchange("LONGLY_WOLF_DIRECT_EXCHANGE");
    }

    //主题交换机
    @Bean("topicExchange")
    public TopicExchange topicExchange(){
        return new TopicExchange("LONGLY_WOLF_TOPIC_EXCHANGE");
    }

    //广播交换机
    @Bean("fanoutExchange")
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("LONGLY_WOLF_FANOUT_EXCHANGE");
    }


    //用于测试备份交换机的原直连交换机
    @Bean("bakDirectEchange")
    public DirectExchange bakDirectEchange(){
        Map argMap = new HashMap<>();
        argMap.put("alternate-exchange", "LONGLY_WOLF_BAK_FANOUT_EXCHANGE");
        return new DirectExchange("LONGLY_WOLF_BAK_ORIGIN_DIRECT_EXCHANGE",false,false,argMap);
    }

    //备份广播交换机
    @Bean("bakFanoutExchange")
    public FanoutExchange bakFanoutExchange(){
        return new FanoutExchange("LONGLY_WOLF_BAK_FANOUT_EXCHANGE");
    }

    //直连死信交换机(也可以用topic或者fanout类型交换机)
    @Bean("deadLetterExchange")
    public DirectExchange deadLetterExchange(){
        return new DirectExchange("LONGLY_WOLF_DEAD_LETTER_DIRECT_EXCHANGE");
    }

    @Bean("orderQueue")
    public Queue orderQueue(){
        return new Queue("LONGLY_WOLF_ORDER_QUEUE");
    }

    @Bean("userQueue")
    public Queue userQueue(){
        return new Queue("LONGLY_WOLF_USER_QUEUE");
    }

    @Bean("productQueue")
    public Queue productQueue(){
        return new Queue("LONGLY_WOLF_PRODUCT_QUEUE");
    }

    //备份队列
    @Bean("bakQueue")
    public Queue bakQueue(){
        return new Queue("LONELY_WOLF_BAK_QUEUE");
    }

    @Bean("ttlQueue")
    public Queue ttlQueue(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("x-message-ttl", 5000);//队列中所有消息5秒后过期
        map.put("x-dead-letter-exchange", "LONGLY_WOLF_DEAD_LETTER_DIRECT_EXCHANGE");//已死消息会进入死信交换机
//        map.put("x-expires", 100000);//队列闲置10秒后被删除
        //参数1-name：队列名称
        //参数2-durable：是否持久化
        //参数3-exclusive:是否排他。设置为true时，则该队列只对声明当前队列的连接(Connection)可用,一旦连接断开，队列自动被删除
        //参数4-autoDelete：是否自动删除。前提是必须要至少有一个消费者先连上当前队列，然后当所有消费者都断开连接之后，队列自动被删除
        return new Queue("LONGLY_WOLF_TTL_QUEUE",false,false,false,map);
    }


    //死信队列
    @Bean("deadLetterQueue")
    public Queue deadLetterQueue(){
        return new Queue("LONGLY_WOLF_DEAD_LETTER_QUEUE");
    }

    //Direct交换机和orderQueue绑定，绑定键为：order.detail
    @Bean
    public Binding bindDirectExchange(@Qualifier("orderQueue") Queue queue, @Qualifier("directExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("order.detail");
    }

    //Topic交换机和userQueue绑定，绑定键为：user.#
    @Bean
    public Binding bindTopicExchange(@Qualifier("userQueue") Queue queue, @Qualifier("topicExchange") TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("user.#");
    }

    //Fanout交换机和productQueue绑定
    @Bean
    public Binding bindFanoutExchange(@Qualifier("productQueue") Queue queue, @Qualifier("fanoutExchange") FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
    //ttl队列绑定到direct交换机（交换机和队列可以多对多）
    @Bean
    public Binding ttlBindFanoutExchange(@Qualifier("ttlQueue") Queue queue, @Qualifier("directExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("test.ttl");
    }

    //死信队列和死信交换机绑定
    @Bean
    public Binding deadLetterQueueBindExchange(@Qualifier("deadLetterQueue") Queue queue, @Qualifier("deadLetterExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("test.ttl");
    }

    //备份交换机和备份队列进行绑定
    @Bean
    public Binding BindExchange(@Qualifier("bakQueue") Queue queue, @Qualifier("bakFanoutExchange") FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
//        rabbitTemplate.setChannelTransacted(true);//开启事务

        ////publisher-confirm-type参数配置为correlated时，使用此种方式确认消息是否成功发送到Exchange
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if (!ack){//消息发送失败
                    System.out.println("消息未成功发送到交换机，原因为：" + cause);
                    return;
                }
                //消息发送成功
                System.out.println("消息确认成功发送到交换机");
            }
        });

//        rabbitTemplate.setMandatory(true);//开启监听回调
       //消息是否成功被路由到队列，没有路由到队列时会收到回调（原setReturnCallback在2.0版本已过期）
//        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
//            @Override
//            public void returnedMessage(ReturnedMessage returnedMessage) {
//                System.out.println("收到未路由到队列的回调消息：" + new String(returnedMessage.getMessage().getBody()));
//            }
//        });

        return rabbitTemplate;
    }
}
