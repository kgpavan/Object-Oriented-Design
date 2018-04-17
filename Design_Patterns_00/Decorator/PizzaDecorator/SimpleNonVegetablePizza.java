package com.decorator.test;

/**
 * Created by Chaklader on 2/13/17.
 */
public class SimpleNonVegetablePizza implements Pizza{

    @Override
    public String getDescription() {
        return "Simple non-vegetable pizza (350)";
    }

    @Override
    public double getPrice() {
        return 350.0;
    }
}
