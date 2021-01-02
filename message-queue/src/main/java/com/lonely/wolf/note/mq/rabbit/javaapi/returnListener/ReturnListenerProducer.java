package com.lonely.wolf.note.mq.rabbit.javaapi.returnListener;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author zwx
 * @version 1.0
 * @date 2021/1/2
 * @since jdk1.8
 */
public class ReturnListenerProducer {
    private static String QUEUE_NAME = "LINTENER_QUEUE";//队列
    private static String EXCHANGE_NAME = "DIRECT_EXCHANGE_JAVA";//交换机
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
        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
        //队列和交换机进行绑定
        channel.queueBind(QUEUE_NAME,EXCHANGE_NAME,ROUTEING_KEY);
        //监听消息是否正确路由到队列
        channel.addReturnListener(new ReturnListener() {
            @Override
            public void handleReturn(int replyCode, String replyText, String exchange, String routingKey, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("收到未路由到队列的回调消息：" + new String(body));
            }
        });

        String msg = "I'm a listener msg";

        //注意这里的第三个参数，mandatory需要设置为true
        channel.basicPublish(EXCHANGE_NAME,"ERROR_ROUTING_KEY",true,null,msg.getBytes());

        channel.close();
        conn.close();

    }
}
