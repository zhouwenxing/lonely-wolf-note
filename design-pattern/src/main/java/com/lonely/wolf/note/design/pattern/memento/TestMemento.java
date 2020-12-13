package com.lonely.wolf.note.design.pattern.memento;

import java.util.Date;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/4
 * @since jdk1.8
 */
public class TestMemento {
    public static void main(String[] args) {
        ArticleCaretaker articleCaretaker = new ArticleCaretaker();

        ArticleText articleText = new ArticleText("标题1","内容1",new Date());
        ArticleMemento articleMemento = articleText.saveToMemento();
        articleCaretaker.setArticle(articleMemento);//备忘1次

        articleText = new ArticleText("标题2","内容2",new Date());
        System.out.println(String.format("修改后的标题为【%s】，内容为【%s】",articleText.getTitle(),articleText.getContent()));

        articleText.getArticleFromMemento(articleCaretaker.getArticle(0));
        System.out.println(String.format("还原后的标题为【%s】，内容为【%s】",articleText.getTitle(),articleText.getContent()));


    }
}
