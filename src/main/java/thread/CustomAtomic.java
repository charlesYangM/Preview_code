package thread;

import sun.misc.Unsafe;

public class CustomAtomic {

    private static final Unsafe unsafe = UnsafeFactory.get();
    private volatile int  value;
    private static final long valueOffset;

    static {
        try {
            valueOffset = unsafe.objectFieldOffset(CustomAtomic.class
                    .getDeclaredField("value"));
        } catch (Exception ex) {
            throw new Error(ex);
        }
    }

    public void complexOperate() {
        for (;;) {
            int formerValue = value;
            int newValue = action(formerValue);
            if (compareAndSet(formerValue, newValue)) {
                System.out.println("线程" + Thread.currentThread() + "成功赋值;原值:"
                        + formerValue + ",新值:" + newValue + "!!!!!!!!!!!");
                return;
            }
            System.out.println("线程" + Thread.currentThread()
                    + "发现值改变，重新执行...........");
        }
    }
    public int action(int formerValue) {
        long start = System.currentTimeMillis();
        int update = 0;
        try {
            System.out.println("线程" + Thread.currentThread()
                    + "开始执行,值为:" + formerValue);
            Thread.sleep(500);
            return update = formerValue + 1;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException("!!");
        } finally {
            System.out.println("线程" + Thread.currentThread()
                    + "执行完毕，耗时" + (System.currentTimeMillis() - start)
                    + ",值为:" + update);
        }
    }
    private boolean compareAndSet(int expect, int update) {
        return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
    }

}
