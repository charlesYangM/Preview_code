package reflection.annotation.inject;

/**
 * Created by CharlesYang on 2018/7/10/010.
 */
public class Run {
    public static void main(String[] args) {
        ServiceA a = SimpleContainer.getInstance(ServiceA.class);
        a.call();
    }
}
