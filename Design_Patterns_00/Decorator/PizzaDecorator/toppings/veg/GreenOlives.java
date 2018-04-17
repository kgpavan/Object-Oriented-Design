package com.decorator.test.toppings.veg;

import com.decorator.test.Pizza;
import com.decorator.test.PizzaDecorator;

/**
 * Created by Chaklader on 2/13/17.
 */
public class GreenOlives extends PizzaDecorator{

    private final Pizza pizza;

    public GreenOlives(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 25.67;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " , Green Olives (25.67)";
    }
}
