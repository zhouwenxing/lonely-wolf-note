package com.lonely.wolf.note.design.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zwx
 * @version 1.0
 * @date 2020/10/8
 * @since jdk1.8
 */
public class RestaurantMenu {
    private List<IRecipe> recipeList = new ArrayList<>();

    public RestaurantMenu(IRecipe recipe) {
        recipeList.add(recipe);
    }

    public void addRecipe(IRecipe recipe){
        recipeList.add(recipe);
    }

    public void display(ICustomer customer){
        for (IRecipe recipe : recipeList){
            recipe.accept(customer);
        }
    }
}
