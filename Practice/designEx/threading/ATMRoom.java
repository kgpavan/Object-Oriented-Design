//package com.sqli.nespresso.training.threading;
package design.practice.designEx.threading;

import java.util.concurrent.Semaphore;
//This class simulates a situation where an ATM room has only two ATM machines
//and five people are waiting to access the machine. Since only one person can access
//an ATM machine at a given time, others wait for their turn

class ATMRoom {

    public static void test() throws InterruptedException {

        // assume that only two ATM machines are available in the ATM room
        Semaphore machines = new Semaphore(2);
        // list of people waiting to access the machine
        new Person(machines, "Mickey");
        new Person(machines, "Donald");
        new Person(machines, "Tom");
        new Person(machines, "Jerry");
        Thread.sleep(10000);
        new Person(machines, "Casper");
    }
}

