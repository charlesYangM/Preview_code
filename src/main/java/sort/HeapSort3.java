package sort;

/**
 * Created by CharlesYang on 2018/7/30/030.
 */
public class HeapSort3 {

    static int[] arr = new int[]{-1, -5, 6, -16, 5, 5, 1, 1, 1, 5, -5555, 52, 1, 5, 5, 2, 3, 7};

    //    static int[] arr = new int[] {-1,-5,6,-16,1,7,9};
    public static void main(String[] args) {

        int k = 11;

        int[] kHeap = new int[k];
        for (int i = 0; i < k; i ++){
            heapInsert(kHeap, arr[i], i);
        }

        for (int i = k; i < arr.length; i++){
            if (arr[i] < kHeap[0]){
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k -1);
            }
        }
        for (int i : kHeap) {
            System.out.print(i + " ");
        }
    }



    public static void heapInsert(int[] arr, int value, int index){
        int temp ;
        arr[index] = value;
        while (index != 0){
            int parent = (index - 1) / 2;
            if (arr[parent] < arr[index]){
                temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
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
            if ((child + 1) <= end && arr[child + 1] > arr[child]) {
                child += 1;
            }
            if (arr[child] > arr[parent]) {
                temp = arr[child];
                arr[child] = arr[parent];
                arr[parent] = temp;
            }
            parent = child;
        }

    }
}
