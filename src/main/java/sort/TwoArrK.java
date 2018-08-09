package sort;

/**
 * Created by CharlesYang on 2018/8/6/006.
 */
public class TwoArrK {

    static int[] arr = {10, 15, 20};
    static int[] arr2 = {5, 12, 25};

    public static void main(String[] args) {
        int ind1 = arr.length - 1;
        int ind2 = arr2.length - 1;
        int more = 0;
        for (int k = 3; k != 0; k--) {
            more = arr[ind1] > arr2[ind2] ? arr[ind1--] : arr2[ind2--];
        }
        System.out.println(more);
    }
}
