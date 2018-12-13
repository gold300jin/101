package concurrent.exchanger;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Consumer implements Runnable {

    private List<String> basket = new ArrayList<>();

    @Override
    public void run() {
        try {
            while (true) {
                List<String> basketFromProducer = (List<String>)ExchangerUtil.exchanger.exchange(basket);
                log.info("basket from producer, {}", basketFromProducer);
                log.info("start consume the product[{}]..", basketFromProducer);
                Thread.sleep((long)(Math.random() *10000));
                log.info("finish consume the product[{}]..", basketFromProducer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
