package arrayAndString;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by CharlesYang on 2018/7/22/022.
 */
public class Coco2 {
    static String[] name = new String[]{"Alice","Bob","Cathy","Dave"};
    static int N ;
    public static String coco(int N, String[] name)
    {
        Deque<Integer> line= new LinkedList<>();
        for (int i = 0; i <name.length ; i++)
        {
            line.offer(i);
        }
        while (N>1)
        {
            int buyer = line.pollFirst();
            line.offerLast(buyer);
            line.offerLast(buyer);
            N--;
        }
        return name[line.pollFirst()];
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        System.out.println(coco(N, name));
    }
}
