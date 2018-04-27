package design.practice.designEx.threading;

import java.util.concurrent.Semaphore;

//Each Person is an independent thread; but their access to the common resource
//(two ATM machines in the ATM machine room in this case) needs to be synchronized.
class Person extends Thread {

    private Semaphore machines;

    public Person(Semaphore machines, String name) {
        this.machines = machines;
        this.setName(name);
        this.start();
    }

    public void run() {
        try {
            System.out.println(getName() + " waiting to access an ATM machine");
            machines.acquire();
            System.out.println(getName() + " is accessing an ATM machine");
            Thread.sleep(1000); // simulate the time required for withdrawing amount
            System.out.println(getName() + " is done using the ATM machine");
            machines.release();
        } catch (InterruptedException ie) {
            System.err.println(ie);
        }
    }
}

