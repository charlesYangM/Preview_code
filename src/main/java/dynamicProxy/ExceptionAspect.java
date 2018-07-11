package dynamicProxy;

import reflection.annotation.inject.ServiceB;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by CharlesYang on 2018/7/11/011.
 */
@Aspect({ServiceB.class})
public class ExceptionAspect {

    public static final void exception(Object object, Method method,
                                      Object[] args, Throwable e){
        System.out.println("exception when calling : "
        + method.getName() + ", " + Arrays.toString(args));
    }
}
