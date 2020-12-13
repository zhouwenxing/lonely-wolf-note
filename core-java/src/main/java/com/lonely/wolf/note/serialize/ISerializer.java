package com.lonely.wolf.note.serialize;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/1
 * @since jdk1.8
 */
public interface ISerializer {

    <T> byte[] serialize(T obj);

    <T> T deserialize(byte[] data, Class<T> clazz);
}
