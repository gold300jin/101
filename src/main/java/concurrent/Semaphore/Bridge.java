package concurrent.Semaphore;

import java.util.concurrent.Semaphore;

public class Bridge {

    private static final int CAPATITY = 5;
    private static Semaphore semaphore = new Semaphore(CAPATITY);

    private Bridge(){}

    public static Bridge getInstance() {
        return new Bridge();
    }

    public void acquire() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void release() {
        semaphore.release();
    }


}
