package concurrent.cyclicBarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;

@Slf4j
public class NetworkHealthChecker extends BaseHealthChecker {

    public NetworkHealthChecker(CyclicBarrier cyclicBarrier) {
        super(cyclicBarrier, "Network Service");
        log.info("NetworkHealthChecker start");
    }

    @Override
    public void verifyService() {
        log.info("Checking " + this.getServiceName());
        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        log.info(this.getServiceName() + " is UP");
    }
}
