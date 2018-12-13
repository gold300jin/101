package concurrent.waitAndNotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainInteractOutput {

    public static void main(String[] args) {
        Object lock = new Object();
        InteractOutput a = new InteractOutput(lock, 1);
        InteractOutput b = new InteractOutput(lock, 2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(a);
        executorService.execute(b);
    }
}
