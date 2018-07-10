package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by CharlesYang on 2018/7/9/009.
 */
public class getName {
    public static void main(String[] args) {
        try {
            Class<?> cls = Class.forName("java.util.HashMap");
            System.out.println(cls.getCanonicalName());
            for (Field s : cls.getDeclaredFields()){
                System.out.println(s.getName() + "  " + Modifier.isTransient(s.getModifiers()));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
