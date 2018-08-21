package thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeFactory {
    private static Unsafe unsafe = null;
    static {
        try {
            Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
            unsafeField.setAccessible(true);
            unsafe = (Unsafe) unsafeField.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Error("unsafe init error");
        }
    }

    public static Unsafe get() {
        return unsafe;
    }
}
