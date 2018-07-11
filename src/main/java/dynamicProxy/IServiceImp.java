package dynamicProxy;

/**
 * Created by CharlesYang on 2018/7/11/011.
 */
public class IServiceImp implements IService2 {
    @Override
    public void sayGoodBye() {
        System.out.println(" good bye from Service 2");
    }

    @Override
    public void sayHello() {
        System.out.println(" hello from Imp2");
    }

    @Override
    public String toString() {
        return "IServiceImp{}";
    }
}
