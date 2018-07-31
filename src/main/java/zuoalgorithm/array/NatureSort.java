package zuoalgorithm.array;

/**
 * Created by CharlesYang on 2018/7/31/031.
 */
public class NatureSort {

    public static void main(String[] args) {
        int[] arr = {7, 2, 1, 5, 4, 6, 3};
        sort(arr);

        for (int i : arr){
            System.out.printf(i + " ");
        }
    }
    public static void sort(int[] arr){
        int temp;
        int next;
        for (int i = 0; i != arr.length; i++){
            temp = arr[i];
            while (arr[i] != i + 1){
                next = arr[temp - 1];
                arr[temp - 1] = temp;
                temp = next;
            }
        }
    }
}
