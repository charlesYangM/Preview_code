package jvm.gc;

/**
 * Created by CharlesYang on 2018/7/13/013.
 */
public class CanReliveObj {
    public static CanReliveObj obj;

    @Override
    public void finalize() throws Throwable{
        super.finalize();
        System.out.println("CanRelive finilized called");
        obj = this;
    }

    @Override
    public String toString(){
        return "i am CanReliveObj";
    }

    public static void main(String[] args) throws InterruptedException {
        obj = new CanReliveObj();
        obj = null;
        System.gc();
        System.out.println("this is second gc");
        Thread.sleep(1000);

        if (obj == null){
            System.out.println("obj is null");
        }else {
            System.out.println("obj is usable");
        }

        System.out.println("this is second gc");

        obj = null;
        System.gc();

        Thread.sleep(1000);

        if (obj == null){
            System.out.println("obj is null");
        }else {
            System.out.println("obj is usable");
        }
    }

}
