package concurrent.cyclicBarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public abstract class BaseHealthChecker implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String serviceName;
    private boolean isStartUp;

    public BaseHealthChecker(CyclicBarrier cyclicBarrier, String serviceName) {
        super();
        log.info("serviceName={} construct function start", serviceName);
        this.cyclicBarrier = cyclicBarrier;
        this.serviceName = serviceName;
    }

    public void run() {
        verifyService();
        isStartUp = true;
        try {
            if (this.cyclicBarrier != null) {
                log.info("wait other guys!!");
                this.cyclicBarrier.await();
            }
        } catch (Exception e) {
            log.info("run fail");
            isStartUp = false;
        }
    }

    abstract public void verifyService();

    protected String getServiceName() {
        return this.serviceName;
    }

    protected boolean isStartUp() {
        return this.isStartUp;
    }

}
