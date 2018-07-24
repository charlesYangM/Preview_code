package zuoalgorithm;

import java.util.LinkedList;

/**
 * Created by CharlesYang on 2018/7/17/017.
 */
public class GetMaxWindow {
    static int[] arr = new int[]{7, -5, 6, -16, 10, 80};
    public static void main(String[] args) {

        int[] res = getMaxWindow(arr, 3);
        for (int k : res){
            System.out.println(k);
        }
    }

    private static int[] getMaxWindow(int[] arr, int w){
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        LinkedList<Integer> gmax = new LinkedList<>();
        for (int i = 0; i < arr.length; i++){
            while(!gmax.isEmpty() && arr[gmax.peekLast()] <= arr[i]){
                gmax.pollLast();
            }
            gmax.addLast(i);
            if (gmax.peekFirst() == (i - w)){
                gmax.pollFirst();
            }
            if (i >= w - 1){
                res[index++] = arr[gmax.peekFirst()];
            }

//                int j = gmax.peekLast();
//                if (arr[j] <= arr[i]){
//                    gmax.poll();
//                }else {
//                    gmax.offer(i);
//                }
//            }
//            if (gmax.isEmpty()){
//                gmax.offer(i);
//            }
//
//            else {
//                if ((i - w) == gmax.peekFirst()){
//                    gmax.removeLast();
//                }
//                int j = gmax.peekLast();
//                if (arr[j] > arr[i]){
//                    gmax.offer(i);
//                }else {
//                    gmax.removeLast();
//                }
//
//                if (i >= w){
//                    res[index++] = arr[gmax.peekFirst()];
//                }
//
//            }

        }
        return res;
    }
}
