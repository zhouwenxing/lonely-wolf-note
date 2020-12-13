package com.lonely.wolf.note.design.pattern.observe.trendsNotice;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者
 * @author zwx
 * @version 1.0
 * @date 2020/4/25
 * @since jdk1.8
 */
public class Friends implements Observer {
    private String friendName;

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    @Override
    public void update(Observable o, Object arg) {
        Trends trends = new Trends();
        if(null != arg && arg instanceof Trends){
            trends = (Trends)arg;
        }
        System.out.println(this.getFriendName() + "，您好！您收到了来自" + trends.getNickName() +
                "的一条动态【" + trends.getContent() + "】" + "快去点赞吧！");
    }
}
