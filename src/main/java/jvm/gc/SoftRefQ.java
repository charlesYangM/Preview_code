package jvm.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 *
 * 此类用来跟踪软引用队列实验
 * Created by CharlesYang on 2018/7/13/013.
 */
public class SoftRefQ {
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

                    UserSoftReference obj = null;
                    try{
                        obj = (UserSoftReference) softQueue.remove();
                        System.out.println(obj);
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

    private static class UserSoftReference extends SoftReference<User> {
        int uid;
        public UserSoftReference(User referent, ReferenceQueue<? super User> q) {
            super(referent, q);
            uid = referent.id;
        }

        @Override
        public String toString() {
            return "UserSoftReference{" +
                    "uid=" + uid +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new CheckRefQueue();
        t.setDaemon(true);
        t.start();
        User u = new User(1, "geym");
//        User u2 = new User(2, "geym2");
//        User u3 = new User(3, "geym3");
//        User u4 = new User(4, "geym4");
        softQueue = new ReferenceQueue<>();
        UserSoftReference userSoftReference = new UserSoftReference(u, softQueue);
//        UserSoftReference userSoftReference2 = new UserSoftReference(u2, softQueue);
//        UserSoftReference userSoftReference3 = new UserSoftReference(u3, softQueue);

        u = null;
//        u2 = null;
//        u3 = null;
        System.out.println(userSoftReference.get());
        System.gc();

        //内存足够不会被回收
        System.out.println("after GC");
        System.out.println(userSoftReference.get());
//        System.out.println(userSoftReference2.get());
//        System.out.println(userSoftReference3.get());
        u = null;
        System.out.println("try to create byte array and GC");
        byte[] bytes = new byte[1024 * 900 * 7];
        System.gc();
        System.out.println(userSoftReference.get());
        System.out.println(userSoftReference);
//        System.out.println(userSoftReference2.get());
//        System.out.println(userSoftReference3.get());

        Thread.sleep(1000);
    }
}
