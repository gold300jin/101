package concurrent.countdownLatch;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationStartupUtil {

    private static List<BaseHealthChecker> services;
    private static CountDownLatch countDownLatch;

    private ApplicationStartupUtil(){}

    private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance() {
        return INSTANCE;
    }

    public static boolean checkService() {
        countDownLatch = new CountDownLatch(3);
        services = Arrays.asList(new NetworkHealthChecker(countDownLatch),
                new CacheHealthChecker(countDownLatch),
                new DatabaseHealthChecker(countDownLatch));
        ExecutorService executor = Executors.newFixedThreadPool(services.size());
        for (BaseHealthChecker baseHealthChecker: services) {
            executor.execute(baseHealthChecker);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        for (BaseHealthChecker baseHealthChecker: services) {
            if (!baseHealthChecker.isStartUp()) {
                return false;
            }
        }
        return true;
    }

}
