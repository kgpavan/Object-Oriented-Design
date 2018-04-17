//package com.sqli.nespresso.training.threading;
package design.practice.designEx.threading;

//The Waiter runs as an independent thread
//It interacts with the CoffeeMachine to wait for a coffee
//and deliver the coffee once ready and request the coffee machine
//for the next one, and this activity keeps going on forever . . .
class Waiter extends Thread {

    public void getCoffee() {
        synchronized (CoffeeMachine.lock) {
            if (CoffeeMachine.coffeeMade == null) {
                try {
                    // wait till the CoffeeMachine says (notifies) that
                    // coffee is ready
                    System.out.println("Waiter: Will get orders till coffee machine notifies me ");
                    CoffeeMachine.lock.wait();
                } catch (InterruptedException ie) {
                    // its okay to ignore this exception
                    // since we're not using thread interrupt mechanism
                    ie.printStackTrace();
                }
            }
            System.out.println("Waiter: Delivering " + CoffeeMachine.coffeeMade);
            CoffeeMachine.coffeeMade = null;
            // ask (notify) the coffee machine to prepare the next coffee
            CoffeeMachine.lock.notifyAll();
            System.out.println("Waiter: Notifying coffee machine to make another one");
        }
    }

    public void run() {
        // keep going till the user presses ctrl-C and terminates the program
        while (true) {
            getCoffee();
        }
    }
}
