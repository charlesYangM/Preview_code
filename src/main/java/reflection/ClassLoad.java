package reflection;

/**
 * Created by CharlesYang on 2018/7/9/009.
 */
public class ClassLoad {
    public static void main(String[] args) {
        String name = "[Ljava.lang.String;";
        try {
            Class cls = Class.forName(name);

            System.out.println(cls == String[].class);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
