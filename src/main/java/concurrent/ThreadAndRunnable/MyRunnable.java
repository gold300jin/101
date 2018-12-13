package concurrent.ThreadAndRunnable;

// RunnableTest.java 源码
class MyRunnable implements Runnable{
    private int ticket=10;
    public void run(){
        for(int i=0;i<20;i++){
            if(this.ticket>0){
                System.out.println("[Runnable] " +Thread.currentThread().getName()+" 卖票：ticket"+this.ticket--);
            }
        }
    }
};

