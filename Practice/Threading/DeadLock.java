//package com.sqli.nespresso.training.threading;
package design.practice.designEx.threading;

//Balls class has a globally accessible data member to hold the number of balls thrown so far
class Balls {

    public static long balls = 0;
}

//Runs class has a globally accessible data member to hold the number of runs scored so far
class Runs {

    public static long runs = 0;
}

//Counter is a thread class that has two methods � IncrementBallAfterRun and
//IncrementRunAfterBall.
//For demonstrating deadlock, we call these two methods in the run method,
//so that locking can be requested in opposite order in these two methods
class Counter implements Runnable {

    // this method increments runs variable first and then increments the balls variable
    // since these variables are accessible from other threads,
    // we need to acquire a lock before processing them
    public void IncrementBallAfterRun() {
        // since we're updating runs variable first, lock the Runs.class reference first
        synchronized (Runs.class) {
            // now acquire lock on Balls.class variable before updating balls variable
            synchronized (Balls.class) {
                Runs.runs++;
                Balls.balls++;
            }
        }
    }

    public void IncrementRunAfterBall() {
        // since we're updating balls variable first, lock the Balls.class reference first
        synchronized (Balls.class) {
            // now acquire lock on Runs.class variable before updating runs variable
            synchronized (Runs.class) {
                Balls.balls++;
                Runs.runs++;
            }
        }
    }

    public void run() {
        // call these two methods which acquire locks in different order
        // depending on thread scheduling and the order of lock acquision,
        // a deadlock may or may not arise
        IncrementBallAfterRun();
        IncrementRunAfterBall();
    }
}

public class DeadLock {

//    public static void main(String args[]) throws InterruptedException {
//        Counter c = new Counter();
//        // create two threads and start them at the same time
//        Thread t1 = new Thread(c);
//        Thread t2 = new Thread(c);
//        t1.start();
//        t2.start();
//        System.out.println("Waiting for threads to complete execution. . .");
//        t2.join();
//        t2.join();
//        System.out.println("Done.");
//    }
}
