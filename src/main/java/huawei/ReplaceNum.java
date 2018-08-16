package huawei;

import java.util.Scanner;

/**
 * Created by CharlesYang on 2018/8/15/015.
 */
public class ReplaceNum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String order = in.nextLine();
        String num = deleteSame(order);
        System.out.println(num);
    }

    public static String deleteSame(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean[] poss = new boolean[256];
        char[] chars = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (!poss[chars[i]]) {
                poss[chars[i]] = true;
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }
}
