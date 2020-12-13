package com.lonely.wolf.note.design.pattern.bridge;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/24
 * @since jdk1.8
 */
public class UrgentMessage extends AbstractBridgeMessage {
    public UrgentMessage(IMessage iMessage) {
        super(iMessage);
    }

    @Override
    public void sendMessage(String content, String toUser) {
        doSomething();
        super.sendMessage(content, toUser);
    }


    private void doSomething() {
        System.out.println("这是紧急消息，请优先发送");
    }
}
