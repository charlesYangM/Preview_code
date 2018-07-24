package stack;

import java.util.Stack;

/**
 * Created by CharlesYang on 2018/7/16/016.
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush = new Stack<>();
    private Stack<Integer> stackPop = new Stack<>();;

    public void add(int num){
        stackPush.push(num);
    }

    public int poll(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if (stackPop.isEmpty() && stackPush.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public int size(){
        return stackPush.size() + stackPop.size();
    }

    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.add(2);
        twoStackQueue.add(3);
        twoStackQueue.add(4);

        while (twoStackQueue.size() > 0){
            System.out.println(twoStackQueue.poll());
        }
    }
}
