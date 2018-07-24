package arrayAndString;

import java.util.HashMap;
import java.util.Scanner;


public class Coco {
    static int N ;
    static HashMap<String, Integer> co = new HashMap<>(4);
    static String[] name = {"Alice","Bob","Cathy","Dave"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        co.put(name[0], 1);
        co.put(name[1], 1);
        co.put(name[2], 1);
        co.put(name[3], 1);
        int sum = 0 ;
        int in_name = 0;
        int pre = in_name;
        while (sum < Coco.N){
            pre = in_name;
            sum += co.get(name[in_name]);
            co.put(name[in_name], co.get(name[in_name])<<1);
            in_name += 1;
            in_name %= 4;
        }
        System.out.println(name[pre]);
    }
}
