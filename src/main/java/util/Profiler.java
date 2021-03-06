package util;

import java.util.concurrent.TimeUnit;

/**
 * 线程安全的计时器可以在多个线程中使用，
 * Created by CharlesYang on 2018/4/9.
 */
public class Profiler {
    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>(){
        protected Long initialValue(){
            return System.currentTimeMillis();
        }
    };

    public static final long end(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(2);
        System.out.println("cost : " + Profiler.end()+ " ms ");
//        System.out.println(1 + 5 > 4);
    }
}
