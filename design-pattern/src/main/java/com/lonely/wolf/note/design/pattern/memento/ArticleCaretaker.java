package com.lonely.wolf.note.design.pattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/4
 * @since jdk1.8
 */
public class ArticleCaretaker {
    private final List<ArticleMemento> list = new ArrayList<>();

    public ArticleMemento getArticle(int index){
        return list.get(index);
    }

    public void setArticle(ArticleMemento articleMemento){
        list.add(articleMemento);
    }
}
