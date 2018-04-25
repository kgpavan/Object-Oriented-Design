package com.decorator.test;

/**
 * Created by Chaklader on 2/13/17.
 */
public class SimpleVegetablePizza implements Pizza {

    @Override
    public String getDescription() {
        return "Simple vegetable pizza (230)";
    }

    @Override
    public double getPrice() {
        return 230.0;
    }
}
