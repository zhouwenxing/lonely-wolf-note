package com.lonely.wolf.note.design.pattern.bridge;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/24
 * @since jdk1.8
 */
public interface IMessage {
    void send(String content, String toUser);
}
