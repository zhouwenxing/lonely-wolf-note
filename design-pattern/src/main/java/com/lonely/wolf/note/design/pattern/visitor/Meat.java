package com.lonely.wolf.note.design.pattern.visitor;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class Meat implements IRecipe {

    @Override
    public void accept(ICustomer customer) {
        customer.visit(this);
    }

    public String getPrice(){
        return "88元/份";
    }
}
