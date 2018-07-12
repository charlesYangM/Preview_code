package dynamicProxy;

import reflection.annotation.inject.ServiceA;
import reflection.annotation.inject.ServiceB;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by CharlesYang on 2018/7/11/011.
 */
@Aspect({ServiceA.class, ServiceB.class})
public class ServiceLogAspect {
    public static void before(Object object, Method method, Object[] args){
            System.out.println("entering " + method.getDeclaringClass().getSimpleName()
                + " :: " + method.getName() + ", args : " + Arrays.toString(args));
    }

    public static void after(Object object, Method method, Object[] args, Object result){
        System.out.println("leaving " + method.getDeclaringClass().getSimpleName()
                + " :: " + method.getName() + ", result : " + result);
    }
}
