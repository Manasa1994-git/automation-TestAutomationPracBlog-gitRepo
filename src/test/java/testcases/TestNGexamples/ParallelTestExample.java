package testcases.TestNGexamples;

import org.testng.annotations.Test;

public class ParallelTestExample {

    @Test
    public void testA() throws InterruptedException {
        System.out.println("Starting testA - Thread: " + Thread.currentThread().getName());
        Thread.sleep(2000); // simulate some work by sleeping 2 seconds
        System.out.println("Ending testA - Thread: " + Thread.currentThread().getName());
    }

    @Test
    public void testB() throws InterruptedException {
        System.out.println("Starting testB - Thread: " + Thread.currentThread().getName());
        Thread.sleep(2000);
        System.out.println("Ending testB - Thread: " + Thread.currentThread().getName());
    }

    @Test
    public void testC() throws InterruptedException {
        System.out.println("Starting testC - Thread: " + Thread.currentThread().getName());
        Thread.sleep(2000);
        System.out.println("Ending testC - Thread: " + Thread.currentThread().getName());
    }

    @Test
    public void testD() throws InterruptedException {
        System.out.println("Starting testD - Thread: " + Thread.currentThread().getName());
        Thread.sleep(2000);
        System.out.println("Ending testD - Thread: " + Thread.currentThread().getName());
    }
}
