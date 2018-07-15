package jvm.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by CharlesYang on 2018/7/14/014.
 */
public class WeakRef {
    static User obj;
    public static class User{
        public int id;
        public String name;

        public User(int id, String name){
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
        @Override
        public void finalize() throws Throwable {
            super.finalize();
            System.out.println("user finalize called");
            obj = this;
        }
    }


    static ReferenceQueue<User> softQueue = null;
    public static class CheckRefQueue extends Thread{
        @Override
        public void run(){
            while(true){
                if (softQueue != null){

                    UserWeakReference obj = null;
                    try{
                        obj = (UserWeakReference) softQueue.remove();
//                        System.out.println(obj);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (obj != null){
                        System.out.println(obj + " is delete ");
                    }
                }
            }
        }
    }

    private static class UserWeakReference extends WeakReference<User> {
        int uid;
        public UserWeakReference(User referent, ReferenceQueue<? super User> q) {
            super(referent, q);
            uid = referent.id;
        }

        @Override
        public String toString() {
            return "UserWeakReference{" +
                    "uid=" + uid +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();

        obj = new User(1, "zhangsan");
        softQueue = new ReferenceQueue<>();
        WeakReference<User> userWeakReference = new UserWeakReference(obj,softQueue);

        obj = null;//置为null之后并不会马上被回收 而是等到垃圾回收产生的时候
        System.out.println(userWeakReference.get());
        System.gc();

        System.out.println("after gc:");
        System.out.println(userWeakReference.get());

        Thread.sleep(1000);
    }
}
