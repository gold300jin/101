package concurrent.yield;

class ThreadA implements Runnable {

    public synchronized void run(){
        for(int i=0; i <10; i++){
            System.out.printf("%s [%d]\n", Thread.currentThread().getName(), i);
            // i整除4时，调用yield
//            if (i%4 == 0)
//                Thread.yield();
        }
    }
}

public class YieldTest{
    public static void main(String[] args){
        ThreadA a = new ThreadA();
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(a);
        t1.start();
        t2.start();
    }
}