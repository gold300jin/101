package concurrent.Semaphore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    void crossBridge() {
        long time = (long)(Math.random() * 10);
        try {
            log.info("[START] {} is crossing the bridge", this.name);
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("[END] {} passed the bridge in {} s", this.name, time);
    }

}
