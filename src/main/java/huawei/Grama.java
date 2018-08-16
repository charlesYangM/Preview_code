package huawei;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by CharlesYang on 2018/8/15/015.
 */
public class Grama {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        ArrayList<Integer> nums = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String tokens = scanner.nextLine().trim();
        char[] chars = tokens.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            if (chars[j] != ')') {
                if (Character.isDigit(chars[j]) && chars[j - 1] == '('){
                    stack.pop();
                    break;
                }
                stack.push(chars[j]);

            } else {
                int sum = 0;
                while (!stack.isEmpty()) {

                    Character cur = stack.pop();
                    if (cur != '(') {
                        if (Character.isDigit(cur)) {
                            sum = sum * 10 + (cur - '0');
                            if (stack.peek() == 32){
                                nums.add(sum);
                                sum = 0;
                            }
                        } else if (cur == '*') {
                            int num1 = nums.get(0);
                            int num2 = nums.get(1);
                            int num = (num1 * num2);
                            char[] ress = String.valueOf(num).toCharArray();
                            stack.push(' ');
                            for (int k = ress.length - 1; k >= 0; k--) {
                                stack.push(ress[k]);
                            }
                            nums.clear();
                            break;
                        } else if (cur == '^') {
                            int num1 = nums.get(0);
                            num1++;
                            char[] ress = String.valueOf(num1).toCharArray();
                            stack.push(' ');
                            for (int k = ress.length - 1; k >= 0; k--) {
                                stack.push(ress[k]);
                            }
                            nums.clear();
                            break;
                        } else if (cur == '+') {
                            int num1 = nums.get(0) ;
                            int num2 = nums.get(1);
                            int num = (num1 + num2);
                            stack.push(' ');
                            char[] ress = String.valueOf(num).toCharArray();
                            for (int k = ress.length - 1; k >= 0; k--) {
                                stack.push(ress[k]);
                            }
                            nums.clear();
                            break;
                        }
                    }
                }
            }
        }
        int sum =0 ;
        while (stack.peek() != '(') {
            Character cur = stack.pop();
            sum = sum * 10 + (cur - '0');
            if (stack.peek() == 32){
                nums.add(sum);
                sum = 0;
            }
        }

        if (stack.size() == 1 && stack.peek() == '(') {
            System.out.println(nums.get(0));
        } else {
            System.out.println(-1);
        }

    }
}
