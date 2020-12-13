package com.lonely.wolf.note.design.pattern.observe.trendsNotice;

/**
 * 动态
 * @author zwx
 * @version 1.0
 * @date 2020/4/25
 * @since jdk1.8
 */
public class Trends {

    private String nickName;//发表动态的用户昵称

    private String content;//发表的动态内容

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
