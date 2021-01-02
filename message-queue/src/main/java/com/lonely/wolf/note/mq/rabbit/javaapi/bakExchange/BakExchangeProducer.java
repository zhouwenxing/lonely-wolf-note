package com.lonely.wolf.note.mq.rabbit.javaapi.bakExchange;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/1/2
 * @since jdk1.8
 */
public class BakExchangeProducer {
    private static String QUEUE_NAME = "BAK_EXCHANGE_QUEUE";//队列
    private static String EXCHANGE_NAME = "BAK_EXCHANGE";//交换机
    private static String ROUTEING_KEY = "direct";
    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqp://admin:123456@47.107.155.197:5672");
        // 建立连接
        Connection conn = factory.newConnection();
        // 创建消息通道
        Channel channel = conn.createChannel();

        //声明队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //声明交换机且指定备份交换机
        Map<String,Object> argMap = new HashMap<String,Object>();
        argMap.put("alternate-exchange","TEST_ALTERNATE_EXCHANGE");
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT,false,false,argMap);
        //队列和交换机进行绑定
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTEING_KEY);

        //声明备份交换机和备份队列，并绑定（为了防止收不到消息，备份交换机一般建议设置为Fanout类型）
        channel.queueDeclare("BAK_QUEUE", false, false, false, null);
        channel.exchangeDeclare("TEST_ALTERNATE_EXCHANGE", BuiltinExchangeType.TOPIC);
        channel.queueBind("BAK_QUEUE","TEST_ALTERNATE_EXCHANGE","ERROR.#");

        String msg = "I'm a bak exchange msg";
        //deliveryMode=2表示消息持久化
        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder().deliveryMode(2).
                contentEncoding("UTF-8").build();
        channel.basicPublish(EXCHANGE_NAME,"ERROR.ROUTING_KEY",properties,msg.getBytes());

        channel.close();
        conn.close();

    }
}
