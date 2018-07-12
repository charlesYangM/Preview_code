package classloader;

import util.BinaryFileUtils;

import java.io.IOException;

/**
 * Created by CharlesYang on 2018/7/12/012.
 */
public class MyClassLoader extends ClassLoader {
    private static final String BASE_DIR = "data/class/";

    @Override
    public Class<?> findClass(String name) {
        String fileName = name.replaceAll("\\.", "/");
        fileName = BASE_DIR + fileName + ".class";

        try {
            byte[] bytes = BinaryFileUtils.readFileToByte(fileName);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> cls = myClassLoader.findClass("classloader.User");
        IHello demo = (IHello) cls.newInstance();
        demo.hello();
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(demo.getClass().getClassLoader().getParent());
    }
}
