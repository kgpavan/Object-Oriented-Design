package com.decorator.test.toppings.veg;

import com.decorator.test.Pizza;
import com.decorator.test.PizzaDecorator;

/**
 * Created by Chaklader on 2/13/17.
 */
public class RomaTomatoes extends PizzaDecorator {

    private final Pizza pizza;

    public RomaTomatoes(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Roma Tomatoes 12.56";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 12.56;
    }
}
