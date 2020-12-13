package com.lonely.wolf.note.design.pattern.visitor;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class TestVistor {
    public static void main(String[] args) {
        IRecipe recipe = new Meat();
        RestaurantMenu menu = new RestaurantMenu(recipe);
        menu.addRecipe(new Cabbage());
        menu.display(new CustomerA());
    }
}
