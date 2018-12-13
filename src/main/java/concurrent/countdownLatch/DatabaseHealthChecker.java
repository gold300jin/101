package concurrent.countdownLatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class DatabaseHealthChecker extends BaseHealthChecker {

    public DatabaseHealthChecker(CountDownLatch countDownLatch) {
        super(countDownLatch, "Database service");
        log.info("DatabaseHealthChecker start");
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
