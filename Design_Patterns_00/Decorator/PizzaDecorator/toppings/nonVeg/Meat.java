package com.decorator.test.toppings.nonVeg;

import com.decorator.test.Pizza;
import com.decorator.test.PizzaDecorator;

/**
 * Created by Chaklader on 2/13/17.
 */
public class Meat extends PizzaDecorator {

    private final Pizza pizza;

    public Meat(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 100.12;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " , Meat (100.12)";
    }
}
