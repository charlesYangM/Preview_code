package recursion;

import util.Profiler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CharlesYang on 2018/7/7/007.
 */
public class Biany {
    static int num = 2;
    static char[] A = new char[num];
    static int[] A_int = new int[num];

    public static void main(String[] args) {
//        binarySearch(A.length);
//        kstring(A_int.length,20);
        Profiler.begin();
        List<String> list = solvePro(5);
        System.out.println(Profiler.end()/1000.0);
        for (String str : list){
            System.out.println(str);
        }
     }

    static void binarySearch(int n) {
//       System.out.println("begin");
        if (n < 1) {
            for (char c : A) {
                System.out.printf(String.valueOf(c));
            }
            System.out.println();
        } else {
            A[n - 1] = 'c';
            binarySearch(n - 1);
            A[n - 1] = 'a';
            binarySearch(n - 1);
            A[n - 1] = 'd';
            binarySearch(n - 1);
        }
    }

    /**
     * K进制 串
     * @param n
     * @param k 进制的大小
     */
    static void kstring(int n, int k) {
        if (n < 1) {
            for (int c : A_int) {//打印进制串
                System.out.printf(String.valueOf(c));
            }
            System.out.println();
        } else {
            for (int j = 0; j < k; j++) {
                A_int[n - 1] = j;
                kstring(n - 1, k);
            }
        }
    }

    public static List<String> solve(int n){
        List<String> list = new ArrayList<>();
        if (n <= 0){
            return null;
        }
        else if (n == 1){
            list.add("0");
            list.add("1");
            return list;
        }else {
            List<String> t = solve( n - 1);
            for (String str : t ){
//                list.addAll(t);
                list.add(str + "0");
                list.add(str + "1");
            }
        }
        return list;
    }


    public static List<String> solvePro(int n){
        List<String> list = new ArrayList<>();

        for (int i = 1;i <= n; i++){
            list.addAll(solve(i));
        }
        return list;
    }
}
