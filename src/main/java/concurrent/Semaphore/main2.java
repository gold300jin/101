package concurrent.Semaphore;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountdownLatch and Semaphore
 */
@Slf4j
public class main2 {

    private final static int maxPersonNum = 12;
    private final static CountDownLatch countDownLatch = new CountDownLatch(maxPersonNum);

    public static void main(String[] args) {
        Bridge bridge = Bridge.getInstance();
        ExecutorService exec = Executors.newFixedThreadPool(maxPersonNum);
        for (int i = 0; i < maxPersonNum; i++) {
            Person guy = new Person("person" + i);
            Runnable runnable = () -> {
                bridge.acquire();
                guy.crossBridge();
                bridge.release();
                countDownLatch.countDown();
            };
            exec.execute(runnable);
        }
        try {
            countDownLatch.await();
            log.info("all guys passed!!!!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
