package com.lonely.wolf.note.design.pattern.observe.trendsNotice;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/25
 * @since jdk1.8
 */
public class TestObserver {
    public static void main(String[] args) {
        Zone zone = new Zone();
        Friends friends = new Friends();
        friends.setFriendName("张三丰");

        Trends trends = new Trends();
        trends.setNickName("张无忌");
        trends.setContent("祝太师傅长命百岁！");
        zone.addObserver(friends);
        zone.publishTrends(trends);
    }
}
