package reflection.annotation.inject;

/**
 * Created by CharlesYang on 2018/7/10/010.
 */
public class ServiceA {
    @SimpleInject
    ServiceB b;

    @SimpleInject
    ServiceC c;
    public void call(){
        b.action();
        c.actionC();
    }

}
