package sort;

/**
 * Created by CharlesYang on 2018/7/12/012.
 */
public class ShellSort {
    static int[] arr = new int[]{-1, -5, 6, -16, 5, 5, 1, 1, 1, 5, -5555, 52, 1, 5, 5, 2, 3, 7};

    //    static int[] arr = new int[] {-1,-5,6,-16,1,7,9};
    public static void main(String[] args) {
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2){
            for (int i = gap;i < arr.length; i++){
                int j = i;
                int target = arr[j];
                while(j - gap >= 0 && arr[j - gap] > target){
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = target;
            }
        }
    }
}
