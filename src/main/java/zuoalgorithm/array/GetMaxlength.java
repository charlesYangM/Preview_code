package zuoalgorithm.array;

import java.util.HashMap;

/**
 * Created by CharlesYang on 2018/7/31/031.
 */
public class GetMaxlength {
    static int[] arr = new int[]{-1, -5, 6, -16, 5, 5, 1, 1, 1, 5, -5555, 52, 1, 5, 5, 2, 3, 7};
    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i ++){

            if (arr[i] < 0) arr[i] = -1;
            else if (arr[i] > 0) arr[i] = 1;
            else  arr[i] = 1;
        }

        System.out.println(maxLength(arr, 0));
    }


    public static int maxLength(int[] arr, int k){
        if (arr == null || arr.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
            if (map.containsKey(sum - k)){
                len = Math.max(i - map.get(sum - k), len);
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;
    }
}
