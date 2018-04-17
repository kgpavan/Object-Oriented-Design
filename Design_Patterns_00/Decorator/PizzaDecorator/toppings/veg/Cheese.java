package com.decorator.test.toppings.veg;

import com.decorator.test.Pizza;
import com.decorator.test.PizzaDecorator;


/**
 * Created by Chaklader on 2/13/17.
 */
public class Cheese extends PizzaDecorator{

    private final Pizza pizza;

    public Cheese(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + "Cheese (20.24)";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 20.25;
    }
}
