package concurrent.exchanger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Consumer con = new Consumer();
        Producer pro = new Producer();
        executor.execute(con);
        executor.execute(pro);
    }
}
