package stack;

import java.util.Stack;
import java.util.logging.Logger;

/**
 * Created by CharlesYang on 2018/6/26/026.
 */
public class MaximumQueue{


//    final volatile int d;

    public static Stack<Integer> sort(Stack<Integer> stack){
        Stack<Integer> orderStack = new Stack<Integer>();

        while (!stack.isEmpty()){
            int temp = stack.pop();
            if (orderStack.isEmpty() || temp > orderStack.peek()){
                orderStack.push(temp);
            }else {
                while (!orderStack.isEmpty() && temp < orderStack.peek()){

                    stack.push(orderStack.pop());
                }
                orderStack.push(temp);
            }
        }
        return orderStack;
    }

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<Integer>();

        myStack.push(1);
        myStack.push(5);
        myStack.push(3);
        myStack = sort(myStack);
        while (!myStack.isEmpty()){
            System.out.println(myStack.pop());
        }
    }
}
