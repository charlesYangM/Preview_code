package reflection.annotation.inject;

/**
 * Created by CharlesYang on 2018/7/10/010.
 */
@SimpleSingleton
public class ServiceB {
    @SimpleInject
    ServiceC c;
    public void action(){
        System.out.println("i am Service B");
        System.out.println("after....");
        c.actionC();
    }
}
