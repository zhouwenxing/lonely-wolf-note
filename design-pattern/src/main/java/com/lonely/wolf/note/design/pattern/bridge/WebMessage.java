package com.lonely.wolf.note.design.pattern.bridge;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/19
 * @since jdk1.8
 */
public class WebMessage implements IMessage {
    @Override
    public void send(String content, String toUser) {
        System.out.println(String.format("站内消息->%s：%s",toUser,content));
    }
}
