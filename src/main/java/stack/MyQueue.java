package stack;

import java.util.IdentityHashMap;
import java.util.Stack;

/**
 * Created by CharlesYang on 2018/6/26/026.
 */
public class MyQueue<T> {
    Stack<T> stackNew, stackOld;

    public MyQueue(){
        stackNew = new Stack<T>();
        stackOld = new Stack<T>();
    }

    public int size(){
        return stackOld.size() + stackNew.size();
    }

    public void add(T value){
        stackNew.push(value);
    }

    private void shiftStack(){
        if (stackOld.isEmpty()){
            while (!stackNew.isEmpty()){
                stackOld.push(stackNew.pop());
            }
        }
    }

    public T peek(){
        shiftStack();
        return stackOld.peek();
    }

    public T remove(){
        shiftStack();
        return stackOld.pop();
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();

        myQueue.add(1);
        myQueue.add(2);
        myQueue.add(3);
        myQueue.add(3);
        myQueue.add(3);
        myQueue.add(3);
        myQueue.add(7);
        myQueue.add(3);
        myQueue.add(3);

        while (myQueue.size() > 0){
            System.out.println(myQueue.remove());
        }
    }
}
