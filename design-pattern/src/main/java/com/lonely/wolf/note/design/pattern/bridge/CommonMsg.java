package com.lonely.wolf.note.design.pattern.bridge;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/24
 * @since jdk1.8
 */
public class CommonMsg extends AbstractBridgeMessage {
    public CommonMsg(IMessage iMessage) {
        super(iMessage);
    }

    @Override
    public void sendMessage(String content, String toUser) {
        this.doSomething();
        super.sendMessage(content, toUser);
    }

    private void doSomething() {
        System.out.println("这只是一个普通消息");
    }
}
