package huawei;

import java.util.Scanner;

/**
 * Created by CharlesYang on 2018/8/15/015.
 */
public class ConverStr {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        if (string.length() > 20) {
            System.out.print("ERROR!");
            return;
        }
        char[] str = string.toCharArray();
        char[] output = new char[(str.length + 1) / 2];
        ConvertStr(str, output);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i]);
        }
    }

    private static void ConvertStr(char[] str, char[] output) {
        Character character = str[0];


    }

}
