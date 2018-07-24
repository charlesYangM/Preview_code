package ArrayListContain;

import java.util.concurrent.TimeUnit;

/**
 * Created by CharlesYang on 2018/7/20/020.
 */
public class TestBlocked {
    public static void main(String[] args) throws InterruptedException {

        final Object lock = new Object();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                synchronized(lock){
                    while (true){
//                        System.out.println("1");
                    }
                }
            }
        };

        Thread t  =  new Thread(r);
        Thread t2  =  new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    System.out.println(" t2 ");
                }
            }
        });
        System.out.println(Runtime.getRuntime().availableProcessors());
        t.start();
        TimeUnit.SECONDS.sleep(1000);
        System.out.println("start t2");
        t2.start();

        t2.interrupt();

        System.out.println(t2.isInterrupted());
    }
}
