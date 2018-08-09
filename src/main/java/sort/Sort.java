package sort;

/**
 * Created by CharlesYang on 2018/8/7/007.
 */
public class Sort {
    static int[] arr = {1, 1, 2, 1, 2, 2, 1, 1, 1, 2, 0, 0, 0, 0, 1, 1};

    public static void main(String[] args) {
        sort(arr);
        printArr(arr);
    }

    public static void sort(int[] arr) {
        int left = -1;
        int right = arr.length;
        int index = 0;
         while (index != right) {
            if (arr[index] == 0){
                swap(arr, index++, ++left);
            }else if (arr[index] == 2){
                swap(arr, index, --right);
            }else {
                index++;
            }

        }
    }

    public static void printArr(int[] arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
