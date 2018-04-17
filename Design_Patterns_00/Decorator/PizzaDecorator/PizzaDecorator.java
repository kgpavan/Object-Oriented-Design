package com.decorator.test;

/**
 * Created by Chaklader on 2/13/17.
 */
public abstract class PizzaDecorator implements Pizza {

    // this method has no value, it will be Overrided anyway
    @Override
    public String getDescription() {
        return "Topping";
    }
}
