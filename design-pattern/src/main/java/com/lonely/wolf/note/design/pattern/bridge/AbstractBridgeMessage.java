package com.lonely.wolf.note.design.pattern.bridge;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/24
 * @since jdk1.8
 */
public abstract class AbstractBridgeMessage {
    private IMessage iMessage;

    public AbstractBridgeMessage(IMessage iMessage) {
        this.iMessage = iMessage;
    }

    public void sendMessage(String content,String toUser){
        this.iMessage.send(content,toUser);
    }
}
