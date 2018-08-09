package sort;

/**
 * Created by CharlesYang on 2018/8/7/007.
 */
public class partition {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 7, 8, 8, 8, 9, 9, 9,};

    public static void main(String[] args) {
        partition(arr);
        printArr(arr);
    }
    public static void printArr(int[] arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void partition(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int u = 0;
        int i = 1;
        while (i != arr.length) {
            if (arr[i++] != arr[u]) {
                swap(arr, ++u, i - 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
