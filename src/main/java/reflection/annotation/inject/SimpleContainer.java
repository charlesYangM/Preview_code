package reflection.annotation.inject;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by CharlesYang on 2018/7/10/010.
 */
public class SimpleContainer {
    public static final Map<Class<?>, Object> instances = new ConcurrentHashMap<>();

//    public static <T> T getInstance(Class<T> cls){
//        try {
//            T obj = cls.newInstance();
//            Field[] fields = cls.getDeclaredFields();
//
//            for (Field f : fields){
//                if (f.isAnnotationPresent(SimpleInject.class)){
//                    if (!f.isAccessible()){
//                        f.setAccessible(true);
//                    }
//                    Class<?> fieldCls = f.getType();
//                    f.set(obj, getInstance(fieldCls));//为什么这里要递归？
//                }
//            }
//            return  obj;
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    public static <T> T createInstance(Class<T> cls){
        try {
            T obj = cls.newInstance();
            Field[] fields = cls.getDeclaredFields();

            for (Field f : fields){
                if (f.isAnnotationPresent(SimpleInject.class)){
                    if (!f.isAccessible()){
                        f.setAccessible(true);
                    }
                    Class<?> fieldCls = f.getType();
                    f.set(obj, getInstance(fieldCls));//为什么这里要递归？因为变量域仍然可能存在需要注入的情况
                }
            }
            return  obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static <T> T getInstance(Class<T> cls){
        try {
            boolean isSingleton = cls.isAnnotationPresent(SimpleSingleton.class);
            if (!isSingleton){
              return createInstance(cls);
            }
            Object obj = instances.get(cls);
            if (obj != null){
                return (T) obj;
            }
            synchronized (cls){
                obj = instances.get(cls);
                if (obj == null){
                    obj = createInstance(cls);
                    instances.put(cls, obj);
                }
            }
            return (T) obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
