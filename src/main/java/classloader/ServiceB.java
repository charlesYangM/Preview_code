package classloader;

/**
 * Created by CharlesYang on 2018/7/12/012.
 */
public class ServiceB implements IService {
    @Override
    public void action() {
        System.out.println("this is ServiceB to groundControl");
    }
}
