package dynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import reflection.annotation.inject.SimpleInject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by CharlesYang on 2018/7/11/011.
 */
public class CGLibContainer {
    static Map<Class<?>, Map<InterceptionPoint, List<Method>>> interceptMethodMap
            = new HashMap<>();

    static Class<?>[] aspects = new Class[]{
            ServiceLogAspect.class,ExceptionAspect.class
    };

    static {
        try {
            init();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private static Method getMethod(Class<?> cls, String name, Class<?>[] paramTypes) {
        try {
            return cls.getMethod(name, paramTypes);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }
    private static void init() throws NoSuchMethodException {
        for (Class<?> cls : aspects){
            Aspect aspect = cls.getAnnotation(Aspect.class);
            if (aspect != null){
                Method before = getMethod(cls, "before", new Class<?>[]{
                        Object.class, Method.class, Object[].class
                });
                Method afeter = getMethod(cls, "after", new Class<?>[]{
                        Object.class, Method.class, Object[].class, Object.class
                });
                Method exception = getMethod(cls, "exception", new Class<?>[]{
                        Object.class, Method.class, Object[].class, Throwable.class
                });

                Class<?>[] intercepttedArr = aspect.value();
                for (Class<?> interceptted : intercepttedArr){
                    addInterceptMethod(interceptted, InterceptionPoint.BEFORE, before);
                    addInterceptMethod(interceptted, InterceptionPoint.AFTER, afeter);
                    addInterceptMethod(interceptted, InterceptionPoint.EXCEPTION, exception);
                }
            }
        }
    }

    private static void addInterceptMethod(Class<?> cls, InterceptionPoint point, Method method) {
        if (method == null){
            return;
        }
        Map<InterceptionPoint, List<Method>> map =
                interceptMethodMap.get(cls);
        if (map == null){
            map = new HashMap<>();
            interceptMethodMap.put(cls, map);
        }
        List<Method> methods = map.get(point);
        if (methods == null){
            methods = new ArrayList<>();
            map.put(point, methods);
        }
        methods.add(method);
    }

    private static <T> T createInstance(Class<T> cls) throws IllegalAccessException, InstantiationException {
        if (!interceptMethodMap.containsKey(cls)){
            return (T) cls.newInstance();
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(new AspectInterceptor());
        return (T) enhancer.create();
    }

    private static class AspectInterceptor implements MethodInterceptor {
        @Override
        public Object intercept(Object ojbct, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
            List<Method> beforeMethods =
                    getInterceptMethods(ojbct.getClass().getSuperclass(), InterceptionPoint.BEFORE);
            for (Method m : beforeMethods){
                m.invoke(null, new Object[]{ojbct, method, args});
            }
            try{
                Object result = methodProxy.invokeSuper(ojbct, args);
                List<Method> afterMethods = getInterceptMethods(
                        ojbct.getClass().getSuperclass(),InterceptionPoint.AFTER);
                for (Method m : afterMethods){
                    m.invoke(null, new Object[]{ojbct, method, args, result});
                }
                return result;

            }catch (Throwable e){
                List<Method> exceptionMethods = getInterceptMethods(
                        ojbct.getClass().getSuperclass(),InterceptionPoint.EXCEPTION);
                for (Method m : exceptionMethods){
                    m.invoke(null, new Object[]{ojbct, method, args, e});
                }
                throw e;
            }
        }

        private List<Method> getInterceptMethods(Class<?> cls, InterceptionPoint point) {

            Map<InterceptionPoint, List<Method>> map =
                    interceptMethodMap.get(cls);
            if (map == null){
                return Collections.emptyList();
            }

            List<Method> methods = map.get(point);
            if (methods == null){
                return Collections.emptyList();
            }
            return methods;
        }
    }

    public static <T> T getInstance(Class<T> cls){
        try {
            T obj = createInstance(cls);
            Field[] fields = cls.getDeclaredFields();
            for (Field f : fields){
                if (f.isAnnotationPresent(SimpleInject.class)){
                    if (!f.isAccessible()){
                        f.setAccessible(true);
                    }
                    Class<?> fieldClass = f.getType();
                    f.set(obj, getInstance(fieldClass));
                }
            }
            return obj;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
