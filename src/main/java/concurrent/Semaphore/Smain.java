package concurrent.Semaphore;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Smain {

    public static void main(String[] args) {
        int number = 12;
        Bridge bridge = Bridge.getInstance();
        ExecutorService exec = Executors.newFixedThreadPool(number);
        for (int i = 0; i < number; i++) {
            Person guy = new Person("person" + i);
            Runnable runnable = () -> {
                bridge.acquire();
                guy.crossBridge();
                bridge.release();
            };
            exec.execute(runnable);
        }
    }
}
