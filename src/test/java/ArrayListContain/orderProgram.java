package ArrayListContain;

/**
 * Created by CharlesYang on 2018/7/20/020.
 */
public class orderProgram {

    public static int k = 0;
    public static orderProgram t1 = new orderProgram("t1");

    public static int i = print("i");
    public static orderProgram t2 = new orderProgram("t2");
    public static int n = 99;
    public orderProgram(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++i;
        ++n;
    }
    public int j = print("j");
    {
        print("构造块");
    }

    static {
        print("静态块");
    }



    public static int print(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "    n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String args[]) {
        orderProgram t = new orderProgram("init");
    }

}
