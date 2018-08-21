package thread;

import sun.misc.Unsafe;

import java.util.concurrent.TimeUnit;

/**
 * Created by CharlesYang on 2018/8/19/019.
 */
public class increase {

    private static final Unsafe unsafe = UnsafeFactory.get();
    private  int value;
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset
                    (increase.class.getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public void complexOperate() {
//        for (;;) {
        int formerValue = value;
        if (formerValue == 18) {
            System.out.println("2" + Thread.currentThread() + " " + formerValue);
        }
        int newValue = formerValue + 1;
        if (compareAndSet(formerValue, newValue)) {
            if (newValue == 18) {
                System.out.println("1" + Thread.currentThread() + " " + formerValue);
            }
            System.out.println("线程" + Thread.currentThread() + "成功赋值;原值:"
                    + formerValue + ",新值:" + newValue + "!!!!!!!!!!!");
            return;
        }
        System.out.println("线程" + Thread.currentThread()
                + "发现值改变，重新执行...........");
//        }
    }


    public int action(int formerValue) {
        long start = System.currentTimeMillis();
        int update = 0;
        try {
            System.out.println("线程" + Thread.currentThread()
                    + "开始执行,值为:" + formerValue);
//            Thread.sleep(500);
            return update = formerValue + 1;
        } finally {
            System.out.println("线程" + Thread.currentThread()
                    + "执行完毕，耗时" + (System.currentTimeMillis() - start)
                    + ",值为:" + update);
        }
    }

    private boolean compareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

    public static void main(String[] args) throws InterruptedException {
        final increase increase = new increase();

//        Thread thread = new T2(increase);
//        thread.start();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increase.complexOperate();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increase.complexOperate();
                }
            }
        });
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    increase.complexOperate();
                }
            }
        });
        thread.start();
        thread2.start();
        thread3.start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(increase.getValue());
    }


    public int getValue() {
        return value;
    }
}

class T2 extends Thread {
    increase a;

    T2(increase a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            a.complexOperate();
        }
    }
}