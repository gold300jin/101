package concurrent.cyclicBarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ApplicationStartupUtil {

    private static List<BaseHealthChecker> services;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(4, () -> log.info("prior to run when all guys finished"));

    private ApplicationStartupUtil(){}

    private final static ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

    public static ApplicationStartupUtil getInstance() {
        return INSTANCE;
    }

    public static boolean checkService() {
        services = Arrays.asList(new NetworkHealthChecker(cyclicBarrier),
                new CacheHealthChecker(cyclicBarrier),
                new DatabaseHealthChecker(cyclicBarrier));
        ExecutorService executor = Executors.newFixedThreadPool(services.size());
        for (BaseHealthChecker baseHealthChecker: services) {
            executor.execute(baseHealthChecker);
        }
        try {
            cyclicBarrier.await();
            log.info("let's go");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
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
