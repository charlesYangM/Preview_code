package reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CharlesYang on 2018/7/10/010.
 */
public class GenericDemo {
    static class GenercTest<U extends Comparable<U>, V> {
        U u;
        V v;
        List<String> list;

        public U test(List<? extends Number> numbers) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        Class<?> cls = GenercTest.class;

        for (TypeVariable t : cls.getTypeParameters()) {
            System.out.println(t.getName() + " extents " + Arrays.toString(t.getBounds()));
        }

        Field fu = cls.getDeclaredField("u");
        System.out.println(fu.getGenericType());

        Field flist = cls.getDeclaredField("list");
        Type listType = flist.getGenericType();
        if (listType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) listType;

            System.out.println("raw type " + pType.getRawType()
                    + ",type arguments : " + Arrays.toString(pType.getActualTypeArguments()));
        }

        Method m = cls.getMethod("test" , new Class[]{List.class});
        for (Type t : m.getGenericParameterTypes()){
            System.out.println(t);
        }
    }
}
