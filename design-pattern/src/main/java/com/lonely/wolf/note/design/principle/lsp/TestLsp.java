package com.lonely.wolf.note.design.principle.lsp;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/7
 * @since jdk1.8
 */
public class TestLsp {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();
        //替换成子类Eagle，子类重写了父类Bird的fly方法
        Eagle eagle = new Eagle();
        eagle.fly();
    }



}
