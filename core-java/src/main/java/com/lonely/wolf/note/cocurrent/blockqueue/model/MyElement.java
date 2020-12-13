package com.lonely.wolf.note.cocurrent.blockqueue.model;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/7/8
 * @since jdk1.8
 */
public class MyElement implements Delayed {
    private long expireTime;//过期时间(毫秒)
    private int id;

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyElement(int id, long expireTime) {
        this.id = id;
        this.expireTime = System.currentTimeMillis() + expireTime;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        //类里面接收的是毫秒，但是getDelay方法在DelayQueue里面传的是纳秒，所以这里需要进行一次单位转换
        return unit.convert(expireTime - System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.valueOf(expireTime).compareTo(((MyElement) o).expireTime);
    }

    public static void main(String[] args) {
//        long l1 = System.currentTimeMillis() + 2000l;
//        System.out.println(TimeUnit.MILLISECONDS.convert(l1,TimeUnit.NANOSECONDS));
        String s = new String("aa");
        System.out.println(s==s.intern());
    }
}
