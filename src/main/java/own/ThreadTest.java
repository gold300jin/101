package own;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadTest test = new ThreadTest();
//        test.useThread();
//        test.basicMechanism();
//        test.reentrantLockTest();
//        test.testNotify();
//        test.testCountDown();
        test.testCyclicBarrier();
//        test.testSemaphore();
    }


    void useThread() throws ExecutionException, InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<>(myCallable);
        Thread thread1 = new Thread(ft);
        thread1.start();
        System.out.println(ft.get());

        MyThread thread2 = new MyThread();
        thread2.start();
    }

    void basicMechanism() {
        ExecutorService executorService = Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool(5);
//        Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
    }

    Semaphore semaphore = new Semaphore(3);
    void testSemaphore() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }
    }

    CyclicBarrier cyclicBarrier = new CyclicBarrier(10, () -> System.out.println("end"));

    void testCyclicBarrier() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            executorService.execute(() -> {
                System.out.println(j + " - before");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    CountDownLatch countDownLatch = new CountDownLatch(10);

    void testCountDown() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int j = i;
            executorService.execute(() -> {
                System.out.println(j +"   running...");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();
    }

    public void testNotify() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            final int j = i;
            executorService.execute(() -> after(j));
        }
        executorService.execute(() -> before());

    }

    public synchronized void before() {
        System.out.println("before");
        notify();
//        notifyAll();
    }

    public synchronized void after(int i) {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after" + i);

    }

    public void reentrantLockTest() {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(this::reentrantLock);
        service.execute(this::reentrantLock);
    }

    private Lock lock = new ReentrantLock();

    private void reentrantLock() {
        lock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        lock.unlock();
    }


    private class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable");
        }
    }

    private class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            return 1;
        }
    }

    private class MyThread extends Thread {
        public void run() {
            System.out.println("Thread");
        }
    }
}

