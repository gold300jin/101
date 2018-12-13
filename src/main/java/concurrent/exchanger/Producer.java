package concurrent.exchanger;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
public class Producer implements Runnable {

    private List<String> basket;

    @Override
    public void run() {
        try {
            while(true) {
                String product = "product-" + Math.random() * 100;
                basket = Arrays.asList(product);
                log.info("start produce the product[{}]..", product);
                Thread.sleep((long)(Math.random() *10000));
                log.info("finish produce the product[{}]..", product);
                List<String> basketFromConsumer = (List<String>)ExchangerUtil.exchanger.exchange(basket);
                log.info("basket from consumer, {}", basketFromConsumer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
