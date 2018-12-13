package concurrent.countdownLatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean result = ApplicationStartupUtil.checkService();
        log.info("finish, result={}", result);
    }
}
