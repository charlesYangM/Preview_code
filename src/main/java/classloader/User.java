package classloader;

/**
 * Created by CharlesYang on 2018/7/12/012.
 */
public class User implements IHello {

    public static void main(String[] args) {
        System.out.println("user HA");
    }

    @Override
    public void hello() {
        System.out.println("user hello hell");
    }
}
