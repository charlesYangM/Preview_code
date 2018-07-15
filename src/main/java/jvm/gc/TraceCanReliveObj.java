package jvm.gc;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * Created by CharlesYang on 2018/7/14/014.
 */
public class TraceCanReliveObj {
    public static TraceCanReliveObj obj;
    static ReferenceQueue<TraceCanReliveObj> phantonQueue = null;

    public static class CheckRefQueue extends Thread{
        @Override
        public void run(){
            while(true){
                if (phantonQueue != null){
                    PhantomReference<TraceCanReliveObj> obj = null;
                    try{
                        obj = (PhantomReference<TraceCanReliveObj>) phantonQueue.remove();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (obj != null){
                        System.out.println(obj.get() + " is delete");
                    }
                }
            }
        }
    }
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("CanReliveObj finalize called");
        obj = this;
    }

    @Override
    public String toString() {
        return "TraceCanReliveObj{}";
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();

        phantonQueue = new ReferenceQueue<TraceCanReliveObj>();

        obj =new TraceCanReliveObj();

        PhantomReference<TraceCanReliveObj> phantomReference = new PhantomReference<>(obj, phantonQueue);

        obj = null;
        System.out.println("first time to gc");
        System.gc();
        Thread.sleep(1000);
        if (obj == null){
            System.out.println("obj is null");
        }else {
            System.out.println("obj is usable");
        }
        System.out.println("second time to gc");
        obj = null;
        System.gc();

        Thread.sleep(1000);

        if (obj == null){
            System.out.println("obj is null");
        }else {
            System.out.println("obj is usable");
        }


    }
}
