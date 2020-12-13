package com.lonely.wolf.note.mybatis.cache;

import org.apache.ibatis.cache.Cache;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/9/26
 * @since jdk1.8
 */
public class MyCache implements Cache {
    @Override
    public String getId() {
        return null;
    }
    @Override
    public void putObject(Object o, Object o1) {

    }
    @Override
    public Object getObject(Object o) {
        return null;
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {
    }

    @Override
    public int getSize() {
        return 0;
    }
}
