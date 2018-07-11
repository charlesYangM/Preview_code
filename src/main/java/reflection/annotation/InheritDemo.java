package reflection.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by CharlesYang on 2018/7/10/010.
 */
public class InheritDemo {
//    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    static @interface Test{

    }

    @InheritDemo.Test
    static class Base{

    }

    static class Child extends Base{}

    public static void main(String[] args) {
        System.out.println(Child.class.isAnnotationPresent(Test.class));
    }
}
