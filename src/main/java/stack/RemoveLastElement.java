package stack;

import java.util.Stack;

/**
 * Created by CharlesYang on 2018/7/16/016.
 */
public class RemoveLastElement {
    private static Stack<Integer> stackData = new Stack<>();

    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }else {
            int i = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(i);
        }
    }
    public static void main(String[] args) {
        stackData.push(2);
        stackData.push(5);
        stackData.push(6);

        reverse(stackData);

        while (stackData.size() != 0){
            System.out.println(stackData.pop());
        }
    }
}
