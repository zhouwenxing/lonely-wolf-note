package com.lonely.wolf.note.design.pattern.visitor;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public interface ICustomer {
    void visit(Meat meat);

    void visit(Cabbage cabbage);
}
