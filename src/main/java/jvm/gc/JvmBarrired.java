package jvm.gc;

/**
 * Created by CharlesYang on 2018/7/15/015.
 */
public class JvmBarrired {
    private static volatile Integer a;

    public static void main(String[] args) {
        a = 1;
    }
}
