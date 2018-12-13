package concurrent.cyclicBarrier;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CBMain {
    public static void main(String[] args) throws InterruptedException {
        boolean result = ApplicationStartupUtil.checkService();
        log.info("finish, result={}", result);
    }
}
