package reflection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharlesYang on 2018/7/9/009.
 */
public class TypeIsInstance {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            Class<?> cls = Class.forName("java.util.ArrayList");
            if (cls.isInstance(list)){
                System.out.println(toType(list, cls).getClass().getCanonicalName());
            }
            ArrayList arrayList = (ArrayList)list;
            System.out.println(arrayList.isEmpty());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static <T> T toType(Object object, Class<T> cls){
        return cls.cast(object);
    }
}
