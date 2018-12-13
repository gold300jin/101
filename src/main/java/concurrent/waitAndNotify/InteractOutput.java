package concurrent.waitAndNotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InteractOutput implements Runnable {

    private Object lock;

    private int number;

    public InteractOutput(Object lock, int number) {
        this.lock = lock;
        this.number = number;
    }

    public void output() {
        log.info("output number = {}", number);
    }

    @Override
    public void run() {
        synchronized (lock) {
            while (true) {
                try {
                    Thread.sleep(1000);
                    lock.notifyAll();
                    lock.wait();
                    output();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.notifyAll();
                }
            }
        }
    }
}
