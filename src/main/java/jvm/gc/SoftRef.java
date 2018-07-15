package jvm.gc;

import java.lang.ref.SoftReference;

/**
 * Created by CharlesYang on 2018/7/13/013.
 */
public class SoftRef {
    static class User{
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


    }

    public static void main(String[] args) {
        User u = new User(1, "geym");
        SoftReference<User> userSoftReference = new SoftReference<User>(u);

        u = null;
        System.out.println(userSoftReference.get());

        System.gc();
        System.out.println("After GC:");

        System.out.println(userSoftReference.get());

        byte[] bytes = new byte[1024 * 900 * 7];
        System.out.println(userSoftReference.get());
    }
}
