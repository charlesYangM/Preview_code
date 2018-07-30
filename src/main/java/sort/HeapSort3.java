package sort;

/**
 * Created by CharlesYang on 2018/7/30/030.
 */
public class HeapSort3 {

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
            heapify(arr, j, arr.length - 1);
        }

        int temp;

        for (int i = arr.length - 1; i >= 0; i--) {
            //将堆顶位置和最后一个元素交换
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i - 1);
        }

    }


    public static void heapInsert(int[] arr, int value, int index){
        arr[index] = value;
        while (index != 0){
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]){
                parent = index;
            }else {
                break;
            }
        }
    }

    public static void heapify(int[] arr, int parent, int end){
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
