package reflection.annotation.selfserilizaiton;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by CharlesYang on 2018/7/10/010.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Format {
    String pattern() default "yyyy-mm-dd HH:mm:ss";
    String timezone() default "GMT+8";
}
