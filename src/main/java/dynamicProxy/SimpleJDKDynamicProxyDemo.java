package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by CharlesYang on 2018/7/11/011.
 */
public class SimpleJDKDynamicProxyDemo {
    static interface IService{
        public void sayHello();
        void sayGoodBye();
    }

    static class RealService implements IService{

        @Override
        public void sayHello() {
            System.out.println("hello");
        }

        @Override
        public void sayGoodBye() {

        }
    }

    static class SimpleInvocationHandler implements InvocationHandler{
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("entering " + method.getName());
            Object result = method.invoke(realObj, args);
            System.out.println("leaving " + method.getName());
            return result;
        }

        private Object realObj;

        public SimpleInvocationHandler(Object obj){
            this.realObj = obj;
        }
    }

    public static void main(String[] args) {
        IService realService = new IServiceImp();
        IService proxyService = (IService) Proxy.newProxyInstance(
                IService.class.getClassLoader(),new Class<?>[] {IService.class, IService2.class},
                new SimpleInvocationHandler(realService)
        );
        proxyService.sayGoodBye();
    }
}
