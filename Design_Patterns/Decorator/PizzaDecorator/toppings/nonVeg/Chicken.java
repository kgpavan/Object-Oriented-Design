package com.decorator.test.toppings.nonVeg;

import com.decorator.test.Pizza;
import com.decorator.test.PizzaDecorator;

/**
 * Created by Chaklader on 2/13/17.
 */
public class Chicken extends PizzaDecorator {

    private final Pizza pizza;

    public Chicken(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " Chicken (12.15)";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 12.15;
    }
}
