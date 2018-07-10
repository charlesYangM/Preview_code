package stack;

import util.Profiler;

import java.util.Stack;

/**
 * Created by CharlesYang on 2018/7/7/007.
 */
public class TowersOfHanoi {
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static Stack<Integer> stack3 = new Stack<>();
    static int count = 0;
    public static void main(String[] args) {

        int num = 31;
        for (int i = 0; i < num; i++) {
            stack.add(i);
        }
        Profiler.begin();
        towersOFHanoiSort(stack.size(), stack, stack2, stack3);
        System.out.println(Profiler.end()/1000.0);
        System.out.println(count);
//        for (int i = 0; i < num; i++) {
//            System.out.println(stack3.pop());
//        }

    }
    public static int jump3(int t){
        if (t <= 0)
            return -1;
        int[] a = new int[t + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2;i <= t;i++){
            a[i] = 0;
            for (int j = 0;j < i;j++){
                a[i] += a[j];
            }
        }
        return a[t];
    }

    static void towersOFHanoiSort(int n, Stack<Integer> stack,Stack<Integer> stack2,Stack<Integer> stack3){
        if (n == 1){
            moveToS(stack, stack3);
        }else if (n > 0){
            towersOFHanoiSort(n - 1, stack, stack3, stack2);
            moveToS(stack, stack3);
            towersOFHanoiSort(n - 1,stack2, stack, stack3);
        }
    }

    static void moveToS(Stack<Integer> src,Stack<Integer> det){
        count ++;
        det.push(src.pop());
    }
}
