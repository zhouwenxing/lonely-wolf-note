package com.lonely.wolf.note.serialize;

import com.alibaba.fastjson.JSON;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/8/1
 * @since jdk1.8
 */
public class FastJsonSerialize implements ISerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        return JSON.toJSONString(obj).getBytes();
    }

    @Override
    public <T> T deserialize(byte[] data, Class<T> clazz) {
        return (T)JSON.parseObject(new String(data),clazz);
    }
}
