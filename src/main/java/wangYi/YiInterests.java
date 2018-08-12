package wangYi;

import java.util.Scanner;

/**
 * Created by CharlesYang on 2018/8/11/011.
 */
public class YiInterests {
    static int MAX_I = Integer.MIN_VALUE;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        String[] n_k = scanner.nextLine().trim().split(" ");
        int n = Integer.valueOf(n_k[0]);
        int k = Integer.valueOf(n_k[1]);
        int[] matrix_i = new int[n];
        int[] matrix_w = new int[n];

        String[] interests = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < interests.length; i++) {
            matrix_i[i] = Integer.valueOf(interests[i]);
        }
        String[] wakeup = scanner.nextLine().trim().split(" ");
        for (int i = 0; i < wakeup.length; i++) {
            matrix_w[i] = Integer.valueOf(wakeup[i]);
        }

        for (int i = 0; i < n; i++) {
            int ind;
            if (matrix_w[i] == 0){
                boolean[] wake_p = new boolean[k];//记录该索引位置是否为以前有过的。
                ind = i;
                int count = 0;
                while (ind < n && count < k){
                    if (matrix_w[ind] == 1){
                        wake_p[count] = true;
                    }
                    matrix_w[ind++] = 1;
                    count++;
                }
                ind --;
                count --;
                getMaxI(matrix_w, matrix_i);

                while (count >= 0){
                    if (wake_p[count]){
                        matrix_w[ind--] = 1;
                    }else {
                        matrix_w[ind--] = 0;
                    }
                    count--;
                }
            }
        }
        System.out.println(MAX_I);
    }

    public static int getMaxI(int[] arr, int[] arr_i){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1){
                sum += arr_i[i];
            }
        }
        MAX_I = Math.max(MAX_I, sum);
        return MAX_I;
    }
}
