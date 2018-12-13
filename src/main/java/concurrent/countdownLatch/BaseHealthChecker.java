package concurrent.countdownLatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public abstract class BaseHealthChecker implements Runnable {

    private CountDownLatch countDownLatch;
    private String serviceName;
    private boolean isStartUp;

    public BaseHealthChecker(CountDownLatch countDownLatch, String serviceName) {
        super();
        log.info("serviceName={} construct function start", serviceName);
        this.countDownLatch = countDownLatch;
        this.serviceName = serviceName;
    }

    public void run() {
        try {
            verifyService();
            isStartUp = true;
        } catch (Exception e) {
            log.info("run fail");
            isStartUp = false;
        } finally {
            if (this.countDownLatch != null) {
                log.info("countdown");
                this.countDownLatch.countDown();
            }
        }
        try {
            this.countDownLatch.await();
            log.info("we are all finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
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
