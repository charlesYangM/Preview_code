package sort;

import util.Profiler;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by CharlesYang on 2018/7/9/009.
 */
public class BubbleSort {
    static int num = 10000000;
    static int[] arr = new int[num];
    static int[] arr2 = new int[num];
    static Random random = new Random(7);
    public static void main(String[] args) {

        for (int i = 0; i < num; i++){
            arr[i] = random.nextInt(10000000);
        }

//        for (int j = 0; j < 7000; j++){
//            int randomNum =  random.nextInt(num);
//            arr[randomNum] = random.nextInt(10000);
//        }
        arr2 = Arrays.copyOf(arr, num);
        System.out.println("sort start");
        Profiler.begin();
//
//        Arrays.sort(arr);
        quickSort.sort(arr, 0, arr.length -1);
        System.out.println(Profiler.end()/1000.0);

        Profiler.begin();

        ShellSort.sort(arr2);
//        quickSort.sort(arr2, 0, arr.length - 1);
//        MergeInt.sort(arr2);
        System.out.println(Profiler.end()/1000.0);
//        for (int i : arr){
//            System.out.print(i + " ");
//        }
    }

    public static void sort2(int [] arr){
        int temp;
        int pos = 0, k = arr.length -1;

        boolean isRemoved;
        for (int i = 1; i < arr.length; i++){
            isRemoved = false;
            for (int j = 0; j < k; j++){
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isRemoved = true;
                    pos = j;
                }
            }
            if (!isRemoved){
                break;
            }
            k = pos;
        }
    }



    public static void sort(int[] arr){
        int temp;
        for (int i = arr.length -1; i >= 0; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
