package com.lonely.wolf.note.design.pattern.visitor;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class CustomerA implements ICustomer{
    @Override
    public void visit(Meat meat) {
        System.out.println("肉类：" + meat.getPrice());
    }

    @Override
    public void visit(Cabbage cabbage) {
        System.out.println("时蔬：" + cabbage.getPrice());
    }
}
