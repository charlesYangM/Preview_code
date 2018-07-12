package classloader;

/**
 * Created by CharlesYang on 2018/7/12/012.
 */
public class CLInitDemo {
    public static class Hello{
        static {
            System.out.println("class static print");
        }
    }

    public static void main(String[] args) {
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String className = CLInitDemo.class.getName()+"$Hello";
        try{
            Class<?> cls = cl.loadClass(className);
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
