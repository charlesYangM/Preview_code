package wangYi;

import java.util.Scanner;

public class FindApple {
    public static long find(int heapNum, int[] counts, int query)
    {
        int sum = 0;
        for (int i = 0; i < heapNum ; i++)
        {
            sum += counts[i];
            if(query <= sum)
            {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        int heap_num = Integer.valueOf(scanner.nextLine().trim());

        int[] counts = new int[heap_num];
        String[] counts_s = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < counts_s.length; i++) {
            counts[i] = Integer.valueOf(counts_s[i]);
        }

        int queryTime = Integer.valueOf(scanner.nextLine().trim());

        int[] querys = new int[queryTime];
        String[] querys_s = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < querys_s.length; i++) {
            querys[i] = Integer.valueOf(querys_s[i]);
        }

        for (int i = 0; i < queryTime ; i++)
        {
            System.out.println(find(heap_num,counts,querys[i]));
        }
    }
}
