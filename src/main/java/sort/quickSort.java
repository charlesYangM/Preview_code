package sort;

/**
 * Created by CharlesYang on 2018/7/9/009.
 */
public class quickSort {
    static int[] arr = new int[] {66,-5,6,-16,5,5,1,1,1,5,-5555,52,1,5,5,2,3,7};

    public static void main(String[] args) {
        sort(arr, 0, arr.length -1);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr,int lo,int hi) {
        if (lo >= hi){
            return;
        }
        int j = partition(arr, lo, hi);
        swap(arr, lo, j);
        sort(arr, lo, j -1);
        sort(arr, j + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi){
        int i = lo, j = hi + 1;
        int v = arr[lo];
        while(true){

            while (arr[++i] < v)if (i == hi)break;
            while (arr[--j] > v)if (j == lo)break;
            if (i >= j)break;
            swap(arr, i, j);
        }
        return j;
    }

    public static void swap(int[] arr, int src, int dst){
        int temp = arr[src];
        arr[src] = arr[dst];
        arr[dst] = temp;
    }
}
