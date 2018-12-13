package concurrent.ThreadAndRunnable;

public class Test {
    public static void main(String[] args) {
        MyRunnable mr=new MyRunnable();

        // 启动3个线程t1,t2,t3(它们共用一个Runnable对象)，这3个线程一共卖10张票！
        Thread t1=new Thread(mr);
        Thread t2=new Thread(mr);
        Thread t3=new Thread(mr);
        t1.start();
        t2.start();
        t3.start();
        MyThread mt1=new MyThread();
        MyThread mt2=new MyThread();
        MyThread mt3=new MyThread();
        mt1.start();
        mt2.start();
        mt3.start();

    }
}
