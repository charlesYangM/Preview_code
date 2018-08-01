package zuoalgorithm.array;

import java.util.concurrent.Executors;

/**
 * Created by CharlesYang on 2018/7/31/031.
 */
public class EvenAndOdd {

    public static void main(String[] args) {

        int[] arr = {1,1,1};
        modify(arr);

        for (int i : arr){
            System.out.printf(i + " ");
        }
    }
    public static void modify(int[] arr){
        Executors.newFixedThreadPool(2);
        int even = 0;
        int odd = 1;
        int end = arr.length -1;
        while (even <= end && odd <= end){
            if ((arr[end] & 1) == 1){
                swap(arr, odd, end);
                odd += 2;
            }else {
                swap(arr, even, end);
                even += 2;
            }
        }
    }

    public static void swap(int[] arr, int ind1, int ind2){
        int temp  = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

}
