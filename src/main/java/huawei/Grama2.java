package huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by CharlesYang on 2018/8/15/015.
 */
public class Grama2 {

    public static boolean isValid(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String grama = scanner.nextLine();
        System.out.println(resolve(grama));

    }


    public static int resolve(String str) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        stack.push(str.charAt(0));
        int ans = 0;
        for (int i = 1; i < str.length(); i++) {
            if (stack.isEmpty()) return nums.pop();
            if (str.charAt(i) == ' ') continue;
            if (str.charAt(i) == ')') {
                char sign = stack.pop();
                if (sign == '^') {
                    int num = nums.pop();
                    nums.push(num + 1);
                    if (stack.peek() != '(') return -1;
                    stack.pop();
                } else if (sign == '+') {
                    int a = nums.pop();
                    int b = nums.pop();
                    nums.push(a + b);
                    if (stack.peek() != '(') return -1;
                    stack.pop();
                } else if (sign == '*') {
                    int a = nums.pop();
                    int b = nums.pop();
                    nums.push(a * b);
                    if (stack.peek() != '(') return -1;
                    stack.pop();
                }
            } else if (str.charAt(i) == '(' || str.charAt(i) == '+' || str.charAt(i) == '*' || str.charAt(i) == '^') {
                stack.push(str.charAt(i));
            } else if (isValid(str.charAt(i))) {
                int num = 0;
                for (; i < str.length() && isValid(str.charAt(i)); i++) {
                    num += str.charAt(i) - '0';
                }
                i--;
                nums.push(num);
            }
        }
        if (stack.isEmpty()) return nums.pop();
        return -1;
    }




}
