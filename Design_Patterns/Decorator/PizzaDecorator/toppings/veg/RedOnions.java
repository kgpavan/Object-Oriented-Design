package com.decorator.test.toppings.veg;

import com.decorator.test.Pizza;
import com.decorator.test.PizzaDecorator;

/**
 * Created by Chaklader on 2/13/17.
 */
public class RedOnions extends PizzaDecorator{

    private final Pizza pizza;

    public RedOnions(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Red Onions 25.89";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 25.89;
    }
}
