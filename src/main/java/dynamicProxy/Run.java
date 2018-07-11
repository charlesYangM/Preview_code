package dynamicProxy;

import reflection.annotation.inject.ServiceA;

/**
 * Created by CharlesYang on 2018/7/11/011.
 */
public class Run {
    public static void main(String[] args) {
        ServiceA a = CGLibContainer.getInstance(ServiceA.class);
        a.call();
    }

}
