package design.design_patterns.command.JobHandler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/*
* A blocking queue is a queue that blocks when you try to dequeue from it 
* and the queue is empty, or if you try to enqueue items to it and the queue 
* is already full. A thread trying to dequeue from an empty queue is blocked 
* until some other thread inserts an item into the queue. A thread trying to 
* enqueue an item in a full queue is blocked until some other thread makes 
* space in the queue, either by dequeuing one or more items or clearing the 
* queue completely.


BlockingQueue Methods
---------------------

A BlockingQueue has 4 different sets of methods for inserting, removing and examining the elements in the queue. Each set of methods behaves differently in case the requested operation cannot be carried out immediately. Here is a table of the methods:


-------------------------------------------------------------------------------
        Throws Exception    Special Value   Blocks  Times Out
Insert  add(o)              offer(o)        put(o)  offer(o, timeout, timeunit)
Remove  remove(o)           poll()          take()  poll(timeout, timeunit)
Examine element()           peek()       
-------------------------------------------------------------------------------

The 4 different sets of behaviour means this:

    Throws Exception
    ----------------
    If the attempted operation is not possible immediately, 
    an exception is thrown.

    Special Value
    -------------
    If the attempted operation is not possible immediately, 
    a special value is returned (often true / false).

    Blocks
    ------
    If the attempted operation is not possible immedidately, 
    the method call blocks until it is.

    Times Out
    ---------
    If the attempted operation is not possible immedidately, 
    the method call blocks until it is, but waits no longer 
    than the given timeout. Returns a special value telling 
    whether the operation succeeded or not (typically true / false)
*/
public class ThreadPool {


    private final Thread[] jobThreads;
    private volatile boolean shutdown;
    private final BlockingQueue<Job> jobQueue;

    public ThreadPool(int n) {

        jobQueue = new LinkedBlockingQueue<Job>();
        jobThreads = new Thread[n];

        for (int i = 0; i < n; i++) {
            jobThreads[i] = new Worker("Pool Thread " + i);
            jobThreads[i].start();
        }
    }

    public void addJob(Job r) {
        try {
            jobQueue.put(r);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdownPool() {
        while (!jobQueue.isEmpty()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        shutdown = true;
        for (Thread workerThread : jobThreads) {
            workerThread.interrupt();
        }
    }

    private class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        public void run() {
            while (!shutdown) {
                try {
                    Job r = jobQueue.take();
                    r.run();
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
