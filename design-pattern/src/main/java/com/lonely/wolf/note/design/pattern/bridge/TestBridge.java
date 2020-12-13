package com.lonely.wolf.note.design.pattern.bridge;

import java.io.IOException;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/24
 * @since jdk1.8
 */
public class TestBridge {

    public static void main(String[] args) throws IOException {
        IMessage iMessage = new EmailMessage();
        AbstractBridgeMessage abstractBridgeMessage = new UrgentMessage(iMessage);//紧急邮件消息
        abstractBridgeMessage.sendMessage("您好","双子孤狼1号");
        //再来一个普通短信消息
        System.out.println("------------分割线---------------");
        iMessage = new SmsMessage();
        abstractBridgeMessage = new CommonMsg(iMessage);
        abstractBridgeMessage.sendMessage("您好","双子孤狼2号");

        //最后再来一个紧急的站内信
        System.out.println("------------分割线---------------");
        iMessage = new WebMessage();
        abstractBridgeMessage = new UrgentMessage(iMessage);
        abstractBridgeMessage.sendMessage("您好","实验楼的小伙伴");
    }
}
