import java.io.*;

/**
 * Created by CharlesYang on 2018/7/5/005.
 */
public class Serialize implements Serializable {
    private static final long serialVersionUID = -68497944707546611L;

    public int num  = 1390;

    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:/serialize.dat");

            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            Serialize serialize = new Serialize();

            oos.writeObject(serialize);
            oos.flush();
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
