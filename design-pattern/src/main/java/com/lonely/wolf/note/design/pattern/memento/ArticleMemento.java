package com.lonely.wolf.note.design.pattern.memento;

import java.util.Date;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/4
 * @since jdk1.8
 */
public class ArticleMemento {
    private String title;
    private String content;
    private Date createTime;

    public ArticleMemento(String title, String content, Date createTime) {
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
