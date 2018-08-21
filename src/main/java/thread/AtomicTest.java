package thread;

public class AtomicTest {
    public static void main(String[] args) {
        CustomAtomic a = new CustomAtomic();
//        T2 t2 = new T2(new increase());
//        t2.start();
        T1 b = new T1(a);
        T1 c = new T1(a);
        T1 d = new T1(a);
        T1 e = new T1(a);
        b.start();
//        c.start();
//        d.start();
//        e.start();
    }
}

class T1 extends Thread {
    CustomAtomic a;

    T1(CustomAtomic a) {
        this.a = a;
    }

    @Override
    public void run() {

        while (true) {
            a.complexOperate();
        }
    }
}
