import entity.User;
import junit.framework.TestCase;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharlesYang on 2018/6/22/022.
 */
public class Main extends TestCase{
    public static void main(String[] args) {

        System.out.printf("{} ", "s");
        User user = new User(1,"s");

        List<String> spiitles = new ArrayList<>();

        for (String spiitle : spiitles){

        }

        label1:
        for (int i = 0; i < 10; i++) {
            System.out.println("i : " + i);
            for (int j = 0; j < 2; j++) {
                System.out.println("j : " + j);
                for (int k = 0; k < 2; k++) {
                    continue label1;
                }
            }
        }
        System.out.println("hello world");
    }

    public static void printUser(@Valid User user){
        System.out.println(user);
    }


    public static void testAnd(){
//        HashMap
//        ArrayList.this.remove()
        int tail = -1;
        int length = 8 -1;
        System.out.println(tail  & length);
    }

    public void testString(){
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1.intern() == str2.intern());
        System.out.println(str2.intern());
        System.out.println(str1 == str2);
    }

    public void testInt(){
        Integer i = new Integer(127);
        Integer j = 127;
//        int j = 1287;
        System.out.println(i .equals( j));
        System.out.println(i == j);

    }
}
