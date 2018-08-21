package thread;

/**
 * Created by CharlesYang on 2018/8/14/014.
 */


import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class DeadLockBlockingQueue {

    private Object notEmpty = new Object();
    private Object notFull = new Object();
    private Queue<Object> linkedList = new LinkedList<Object>();
    private int maxLength = 10;

    public Object take() throws InterruptedException {
        synchronized (notEmpty) {
            if (linkedList.size() == 0) {
                System.out.println("empty take");
                notEmpty.wait();
            }
            synchronized (notFull) {
                if (linkedList.size() == maxLength) {
                    notFull.notifyAll();
                }
                return linkedList.poll();
            }
        }
    }

    public void offer(Object object) throws InterruptedException {
        synchronized (notEmpty) {
            if (linkedList.size() == 0) {
                notEmpty.notifyAll();
            }
            synchronized (notFull) {
                if (linkedList.size() == maxLength) {
                    System.out.println("full offer");
                    notFull.wait();//这里会将生产者线程阻塞，此时生产者线程会将notFull释放，但是不会释放notEmpty，所以造成死锁
                }
                linkedList.add(object);
            }
        }
    }

    public static void main(String[] args) {
        final DeadLockBlockingQueue a = new DeadLockBlockingQueue();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        a.offer(UUID.randomUUID().toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "生产者").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        a.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "消费者").start();
    }
}


