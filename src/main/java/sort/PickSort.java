package sort;

/**
 * Created by CharlesYang on 2018/7/9/009.
 */
public class PickSort {
    static int[] arr = new int[] {-1,-5,6,-16,5,5,1,1,1,5,-5555,52,1,5,5,2,3,7};

    public static void main(String[] args) {
        sort2(arr);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
    public static void sort2(int[] arr){
        int temp;
        for (int i = 0; i < arr.length; i++){
            int min = 0;
            for (int j = i + 1; j < arr.length; j ++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }






    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0){
            return;
        }
        int temp;
        for (int i = 0; i < arr.length; i++){
//            System.out.println(i);
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] <= arr[min]){
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}
