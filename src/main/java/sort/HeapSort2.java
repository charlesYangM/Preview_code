package sort;

/**
 * Created by CharlesYang on 2018/7/12/012.
 */
public class HeapSort2 {
    static int[] arr = new int[]{-1, -5, 6, -16, 5, 5, 1, 1, 1, 5, -5555, 52, 1, 5, 5, 2, 3, 7};

    //    static int[] arr = new int[] {-1,-5,6,-16,1,7,9};
    public static void main(String[] args) {

        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr) {
        //初始化堆
        for (int j = arr.length  / 2 - 1; j >= 0; j--) {
            heapSort(arr, j, arr.length - 1);
        }
        int temp;
        for (int i = arr.length - 1; i >= 0; i--) {
            //将堆顶位置和最后一个元素交换
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapSort(arr, 0, i-1);
        }

    }

    static void heapSort(int[] arr, int parent, int end) {  //调整堆的过程只需要 logN

        int child ,temp;
        while( 2 * parent + 1 <= end){
            child = 2 * parent + 1;
            if ((child + 1) <= end && arr[child + 1] < arr[child]) {
                child += 1;
            }
            if (arr[child] < arr[parent]) {
                temp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = temp;
            }
            parent = child;
        }
    }
}
