package concurrent.cyclicBarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

@Slf4j
public class CacheHealthChecker extends BaseHealthChecker {

    public CacheHealthChecker(CyclicBarrier cyclicBarrier) {
        super(cyclicBarrier, "Cache service");
        log.info("CacheHealthChecker start");
    }

    @Override
    public void verifyService() {
        log.info("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        log.info(this.getServiceName() + " is UP");
    }
}
