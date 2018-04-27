//package com.sqli.nespresso.training.threading;
package design.practice.designEx.threading;

//This class instantiates two threads - CoffeeMachine and Waiter threads
//and these two threads interact with each other through wait/notify
//till you terminate the application explicitly by pressing Ctrl-C
class CoffeeShop {

    public static void testThreading() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Waiter waiter = new Waiter();
        waiter.start();
        coffeeMachine.start();
    }
}
