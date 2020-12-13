package com.lonely.wolf.note.design.pattern.observe.trendsNotice;

import java.util.Observable;

/**
 * 被观察者
 * @author zwx
 * @version 1.0
 * @date 2020/4/25
 * @since jdk1.8
 */
    public class Zone extends Observable {
    //发表动态
    public void publishTrends(Trends trends){
        System.out.println(trends.getNickName() + "发表了一个动态【" + trends.getContent() + "】" );
        setChanged();//占位,只是设置一个标记说明数据改变了
        notifyObservers(trends);//通知所有观察者
    }

}
