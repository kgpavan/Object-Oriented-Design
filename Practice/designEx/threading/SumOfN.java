//package com.sqli.nespresso.training.threading;
package design.practice.designEx.threading;

import java.util.*;
import java.util.concurrent.*;
// We create a class SumOfN that sums the values from 1..N where N is a large number.
// We divide the task
// to sum the numbers to 10 threads (which is an arbitrary limit just for illustration).
// Once computation is complete, we add the results of all the threads,
// and check if the calculation is correct by using the formula (N * (N + 1))/2.

class SumOfN {

    private static long N = 1000000000L; // one million
    private static long calculatedSum = 0; // value to hold the sum of values in range 1..N
    private static final int NUM_THREADS = 3; // number of threads to create for distributing the effort

    // This Callable object sums numbers in range from..to
    static class SumCalc implements Callable<Long> {

        long from, to, localSum = 0;

        public SumCalc(long from, long to) {
            this.from = from;
            this.to = to;
        }

        public Long call() {
            // add in range 'from' .. 'to' inclusive of the value 'to'
            for (long i = from; i <= to; i++) {
                localSum += i;
            }
            return localSum;
        }
    }

    // In the main method we implement the logic to divide the summation tasks to
    // given number of threads and finally check if the calculated sum is correct
    public static void main(String[] args) {
        // Divide the task among available fixed number of threads
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        // store the references to the Future objects in a List for summing up together
        List<Future<Long>> summationTasks = new ArrayList<Future<Long>>();
        long nByTen = N / 10; // divide N by 10 so that it can be submitted as 10 tasks
        for (int i = 0; i < NUM_THREADS; i++) {
            // create a summation task
            // starting from (10 * 0) + 1 .. (N/10 * 1) to (10 * 9) + 1 .. (N/10 * 10)
            long fromInInnerRange = (nByTen * i) + 1;
            long toInInnerRange = nByTen * (i + 1);
            System.out.printf("Spawning thread for summing in range %d to %d %n", fromInInnerRange, toInInnerRange);
            // Create a callable object for the given summation range
            Callable<Long> summationTask = new SumCalc(fromInInnerRange, toInInnerRange);
            // submit that task to the executor service
            Future<Long> futureSum = executorService.submit(summationTask);
            // it will take time to complete, so add it to the list to revisit later
            summationTasks.add(futureSum);
        }
        long startTime = System.currentTimeMillis();
        // now, find the sum from each task
        for (Future<Long> partialSum : summationTasks) {
            try {
                // the get() method will block (i.e., wait) until the computation is over
                calculatedSum += partialSum.get();
            }
//            } catch (CancellationException | ExecutionException | InterruptedException exception) {
//                // unlikely that you get an exception - exit in case something goes wrong
//                exception.printStackTrace();
//                System.exit(-1);
//            }
            catch (Exception ex) {

            }

        }
        System.out.println("Elapsed Time : " + (System.currentTimeMillis() - startTime));
        // now calculate the sum using formula (N * (N + 1))/2 without doing the hard-work
        long formulaSum = (N * (N + 1)) / 2;
        // print the sum using formula and the ones calculated one by one
        // they must be equal!
        System.out.printf("Sum by threads = %d, sum using formula = %d", calculatedSum, formulaSum);
        executorService.shutdown();
    }
}
