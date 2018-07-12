package classloader;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by CharlesYang on 2018/7/12/012.
 */
public class HotDeployDemo {
    private static final String CLASS_NAME = "classloader.User";
    private static final String FILE_NAME = "data/class/" + CLASS_NAME.replaceAll("\\.", "/")  + ".class";

    private static volatile IHello helloService;

    public static IHello getHelloService(){
        if (helloService == null){
            synchronized (HotDeployDemo.class){
                if (helloService == null){
                    helloService = createHelloService();
                }
            }
        }
        return helloService;
    }

    private static IHello createHelloService() {

        try {
            MyClassLoader cl = new MyClassLoader();
            Class<?> cls = cl.loadClass(CLASS_NAME);
            if (cls != null){
                return (IHello) cls.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void client(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){

                        IHello hello = getHelloService();
                        hello.hello();
                        System.out.println(hello.getClass().getClassLoader());
                        TimeUnit.SECONDS.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public static void monitor(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                long lastModified = new File(FILE_NAME).lastModified();

                try {
                    while(true){
                        TimeUnit.SECONDS.sleep(1);
//                        System.out.println("lastmodifed :" + lastModified);

                        long now = new File(FILE_NAME).lastModified();
                        if (now != lastModified){
                            lastModified = now;
                            reloadHelloService();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    private static void reloadHelloService() {
        System.out.println("reload......");
        helloService = createHelloService();
    }

    public static void main(String[] args) {


        monitor();
        client();
    }
}
