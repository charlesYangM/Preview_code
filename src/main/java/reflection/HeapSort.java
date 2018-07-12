package reflection;

/**
 * Created by CharlesYang on 2018/7/11/011.
 */
public class HeapSort {
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
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapSort(arr, 0, i-1);
        }

    }

    static void heapSort(int[] arr, int parent, int end) {

        int child ,temp;
//        int right_child = start * 2 + 2;
        for (; 2 * parent + 1 <= end; parent = child){
            child = 2 * parent + 1;
            if (child > end) {
                return;
            }
            if ((child + 1) <= end && arr[child] > arr[child + 1]) {
                child += 1;
            }
            if (arr[child] < arr[parent]) {
                temp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = temp;
//            heapSort(arr, parent, end);
            }
        }

    }

}
