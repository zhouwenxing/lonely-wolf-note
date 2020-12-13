package com.lonely.wolf.note.design.pattern.templete;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/4/11
 * @since jdk1.8
 */
public class TestCooking {

    public static void main(String[] args) {
        CookingVegetables cookingVegetables = new CookingCabbage();
        cookingVegetables.cooking();
    }
}
