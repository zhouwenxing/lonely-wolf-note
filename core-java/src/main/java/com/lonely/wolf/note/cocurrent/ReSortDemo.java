package com.lonely.wolf.note.cocurrent;

/**
 * CPU重排序
 * @author zwx
 * @version 1.0
 * @date 2020/5/24
 * @since jdk1.8
 */
public class ReSortDemo {

    int value;
    boolean isFinish;

    void cpu0(){
        value = 10;//S->I状态，将value写入store bufferes，通知其他CPU当前value的缓存失效
        storeMemoryBarrier();//伪代码，插入一个写屏障，使得value=10这个值强制写入主内存
        isFinish=true;//E状态
    }
    void cpu1(){
        if (isFinish){//true
            loadMemoryBarrier();//伪代码，插入一个读屏障，强制cpu1从主内存中获取最新数据
            System.out.println(value == 10);//true
        }
    }

    void storeMemoryBarrier(){//写屏障

    }
    void loadMemoryBarrier(){//读屏障

    }
}
