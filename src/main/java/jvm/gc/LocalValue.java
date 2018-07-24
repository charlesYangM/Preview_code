package jvm.gc;

/**
 * Created by CharlesYang on 2018/7/15/015.
 */
public class LocalValue {
    boolean i;

    void hello(){
        System.out.println("hello");
    }
    public static void main(String[] args) {
        int b= 0;
        LocalValue  a = new LocalValue();
        a.hello();
        a.i = false;
    }
}
