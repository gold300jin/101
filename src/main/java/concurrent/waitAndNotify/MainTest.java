package concurrent.waitAndNotify;

import org.junit.Test;

public class MainTest {

    public static void main(String[] args) {
        Object obj = new Object();
        try {
            obj.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        obj.notify();
    }

    @Test
    public void testUseWaitWithoutLock() {
        Object obj = new Object();
        try {
            obj.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        obj.notify();
    }

    @Test
    public void testUseWaitWithDifferentLock() throws InterruptedException {
        Object obj = new Object();
        Object lock = new Object();
        synchronized (lock) {
            obj.wait();
            obj.notify();
        }
    }

    @Test
    public void testUseWaitWithLock() throws InterruptedException {
        Object obj = new Object();
        synchronized (obj) {
            obj.wait(1000);
            obj.notify();
        }
    }
}
