package ArrayListContain;

/**
 * Created by CharlesYang on 2018/7/20/020.
 */

class A {
    public A() {
        System.out.println("A的构造方法");
    }

    public static int j = print();

    public static int print() {
        System.out.println("A print");
        return 521;
    }
}

public class OrderProgram2 extends A {
    public OrderProgram2() {
        System.out.println("Test1的构造方法");
    }

    public static int k = print();

    public static int print() {
        System.out.println("Test print");
        return 522;
    }

    public static void main(String[] args) {
        System.out.println("main start");
        OrderProgram2 t1 = new OrderProgram2();
    }
}

