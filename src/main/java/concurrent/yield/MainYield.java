package concurrent.yield;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.yield;


public class MainYield {

    public static void main(String[] args) {
        final int maleNum = 10;
        final int femaleNum = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(maleNum + femaleNum);
        for (int i = 0; i < maleNum; i++) {
            final int a = i;
            executorService.execute(() ->{
                yield();
                new Gentleman("man-" + a).crossBridge();
            });
        }
        for (int i = 0; i < femaleNum; i++) {
            final int a = i;
            executorService.execute(() ->{
                new Lady("female-" + a).crossBridge();
            });
        }

    }
}
