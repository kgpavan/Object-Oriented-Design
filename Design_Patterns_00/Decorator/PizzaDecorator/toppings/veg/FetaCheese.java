package com.decorator.test.toppings.veg;

import com.decorator.test.Pizza;
import com.decorator.test.PizzaDecorator;


/**
 * Created by Chaklader on 2/13/17.
 */
public class FetaCheese extends PizzaDecorator{


    private final Pizza pizza;

    public FetaCheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "Feta Cheese (25.21)";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 25.21;
    }
}
