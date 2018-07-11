package reflection.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * Created by CharlesYang on 2018/7/10/010.
 */
public class MethodAnnotations {
    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    static @interface QueryParam{
        String value();
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    static @interface DefaultValue{
        String value() default "";
    }

    public void hello(@QueryParam("action") String action,
                      @QueryParam("sort") @DefaultValue("acs") String sort){

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> cls = MethodAnnotations.class;
        Method method = cls.getMethod("hello",
                new Class[]{String.class, String.class});

        Annotation[][] annts = method.getParameterAnnotations();
        for (int i = 0; i < annts.length; i++){
            System.out.println("annotations for parameter " + (i + 1));

            Annotation[] anntArr = annts[i];

            for (Annotation annt : anntArr){
                if (annt instanceof  QueryParam){
                    QueryParam qp = (QueryParam) annt;
                    System.out.println(qp.annotationType().getSimpleName()
                    + ": " + qp.value());
                }else if (annt instanceof DefaultValue){
                    DefaultValue dv = (DefaultValue) annt;
                    System.out.println(dv.annotationType().getSimpleName()
                    + ": " + dv.value());
                }
            }
        }
    }
}
