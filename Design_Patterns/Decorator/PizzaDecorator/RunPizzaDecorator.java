package com.decorator.test;

import com.decorator.test.toppings.veg.*;
import com.decorator.test.toppings.nonVeg.*;

import java.text.DecimalFormat;

/**
 * Created by Chaklader on 2/13/17.
 */
public class RunPizzaDecorator {


    public static void main(String[] args) {

        System.out.println("Put topping on the pizzas");

        DecimalFormat dformat = new DecimalFormat("#.##");
        Pizza pizza = new SimpleVegetablePizza();

        pizza = new RomaTomatoes(pizza);
        pizza = new GreenOlives(pizza);
        pizza = new Spinach(pizza);

        // all the description will be added
        System.out.println("DESCRIPTION: " + pizza.getDescription());
        System.out.println("PRICE: " + dformat.format(pizza.getPrice()));

        pizza = new SimpleNonVegetablePizza();

        pizza = new Meat(pizza);
        pizza = new Cheese(pizza);
        pizza = new Cheese(pizza);
        pizza = new Ham(pizza);

        System.out.println("DESCRIPTION: " + pizza.getDescription());
        System.out.println("PRICE: " + dformat.format(pizza.getPrice()));
    }
}
