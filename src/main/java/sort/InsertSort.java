package sort;

/**
 * Created by CharlesYang on 2018/7/9/009.
 */
public class InsertSort {
    static int[] arr = new int[] {-1,-5,6,-16,5,5,1,1,1,5,-5555,52,1,5,5,2,3,7};

    public static void main(String[] args) {
        sort(arr);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int target = arr[i]; //待插入的
            while(j > 0 && arr[j -1] > target){
                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
            arr[j] = target;
        }
    }
}
