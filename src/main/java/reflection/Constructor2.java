package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by CharlesYang on 2018/7/9/009.
 */
public class Constructor2 {
    public static void main(String[] args) {
        try {
            Constructor<StringBuilder> constructor = StringBuilder.class.getConstructor(new Class[]{int.class});

            StringBuilder sb = constructor.newInstance(100);
            System.out.println(sb);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
