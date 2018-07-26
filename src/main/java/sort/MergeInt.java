package sort;

/**
 * Created by CharlesYang on 2018/7/2/002.
 */
public class MergeInt {

    private static  int[] aux;

    public static void sort(int[] arr){
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
    }
    public static void sort(int[] arr, int low, int high){

        if (low >= high){
            return;
        }
        int mid = (low + high) / 2;

        sort(arr, low, mid);
        sort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {//此时的arr已经是上次递归中排序好的，故aux需要重新赋值

        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = arr[k];
        }

        for (int k =low; k <= high; k++){
            if (i > mid){
                arr[k] = aux[j++];
            }else if (j > high){
                arr[k] = aux[i++];
            }else if (aux[i] <= aux[j]){
                arr[k] = aux[i++];
            }else {
                arr[k] = aux[j++];
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {-1,-5,6,-16,5,5,1,1,1,5,-5555,52,1,5,5,2,3,7};
        sort(arr);

        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
