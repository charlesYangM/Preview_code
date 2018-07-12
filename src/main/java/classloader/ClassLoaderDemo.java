package classloader;

/**
 * Created by CharlesYang on 2018/7/12/012.
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {

        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println(cl);
        try {
            Class<?> cls = cl.loadClass("java.util.ArrayList");
            ClassLoader actualLoader = cls.getClassLoader();
            System.out.println(actualLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        ClassLoader classloder = ClassLoaderDemo.class.getClassLoader();
//
//        while(classloder != null){
//            System.out.println(classloder.getClass().getName());
//            classloder = classloder.getParent();
//        }
//        System.out.println(String.class.getClassLoader());
    }
}
