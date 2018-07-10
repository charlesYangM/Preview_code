package sort;

/**
 * Created by CharlesYang on 2018/7/9/009.
 */
public class BubbleSort {

    static int[] arr = new int[] {-1,-5,6,-16,5,5,1,1,1,5,-5555,52,1,5,5,2,3,7};

    public static void main(String[] args) {
        sort(arr);
        for (int i : arr){
            System.out.print(i + " ");
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
