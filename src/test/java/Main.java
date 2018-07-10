import entity.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharlesYang on 2018/6/22/022.
 */
public class Main {
    public static void main(String[] args) {

        System.out.printf("{} ","s");
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
}
