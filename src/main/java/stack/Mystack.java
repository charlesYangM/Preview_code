package stack;

import java.util.Stack;

/**
 * Created by CharlesYang on 2018/7/16/016.
 */
public class Mystack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public Mystack(){
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int num){
        if (this.stackMin.isEmpty()){
            stackMin.push(num);
        }else if (num <= stackMin.peek()){
            stackMin.push(num);
        }
        stackData.push(num);
    }

    public int pop(){
        if (stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        int value = stackData.pop();
        if (value == stackMin.peek()){
            value = stackMin.pop();
        }
        return value;
    }

    public int getMin(){
        return stackMin.peek();
    }

    public static void main(String[] args) {
        Mystack mystack = new Mystack();
        mystack.push(2);
        mystack.push(4);
        mystack.push(5);
        mystack.push(7);
        System.out.println(mystack.getMin());
    }
}
