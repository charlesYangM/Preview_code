import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by CharlesYang on 2018/7/5/005.
 */
public class Reader {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();

        char[] buf = new char[1024];

        try {
            FileReader f = new FileReader("testReader.txt");
            System.out.println(f.getEncoding());
            while (f.read(buf) > 0){
                str.append(buf);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(str.toString());

    }
}
