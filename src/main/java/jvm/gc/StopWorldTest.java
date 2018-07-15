package jvm.gc;

import java.util.HashMap;

/**
 * Created by CharlesYang on 2018/7/14/014.
 */
public class StopWorldTest {
    public static class Mythread extends Thread{
        HashMap map = new HashMap();
        @Override
        public void run(){
            try{
                while(true){
                    if (map.size() * 512/1024/1024 >= 900){
                        map.clear();
                        System.out.println("clean map");
                    }
                    byte[] bl;
                    for (int i = 0; i < 100; i++) {
                        bl = new byte[512];
                        map.put(System.nanoTime(), bl);
                    }
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class PrintThread extends Thread{
        public static final long starttime = System.currentTimeMillis();
        @Override
        public void run(){
            try{
                while (true){
                    long t = System.currentTimeMillis() - starttime;
                    System.out.println(t / 1000 + "." + t % 1000);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Mythread t = new Mythread();
        PrintThread pt = new PrintThread();
        t.start();
        pt.start();
    }
}
