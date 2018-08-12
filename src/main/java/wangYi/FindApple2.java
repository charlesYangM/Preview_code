package wangYi;

import java.util.Scanner;

public class FindApple2 {
    static int[] apples;

    public static long find(int heapNum, int[] nums, int index) {
        int count = 0;
        for (int i = 0; i < heapNum; i++) {
            count += nums[i];
            if (count >= index) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void initApples(int[] nums) {
        apples = new int[nums.length + 1];
        apples[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            apples[i + 1] = apples[i] + nums[i];
        }
    }

    public static int find(int index) {
        int s = 0,
                e = apples.length - 1;
        int mid = (s + e) / 2;
        while (s < e) {
            mid = (s + e) / 2;
            if (apples[mid] < index && apples[mid + 1] >= index) {
                return mid + 1;
            } else if (apples[mid] < index) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return mid;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int heap = sc.nextInt();
        int[] nums = new int[heap];
        int i = 0;
        while (i < heap) {
            nums[i++] = sc.nextInt();
        }
        initApples(nums);
        int query = sc.nextInt();
        int[] querys = new int[query];
        i = 0;
        while (i < query) {
            querys[i++] = sc.nextInt();
        }
        for (int j = 0; j < query; j++) {
            System.out.println(find(querys[j]));
        }
    }
}

