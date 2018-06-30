package recursion;

import util.Profiler;

/**
 * Created by CharlesYang on 2018/6/29/029.
 */
public class floor {
    public static int countWays(int n ,int[] map){
        if (n < 0){
            return 0 ;
        }else if (n == 0){
            return 1;
        }else if (map[n] > -1){
            return map[n];
        }
        else {
            map[n] = countWays(n - 1,map) + countWays(n - 2, map) + countWays(n - 3, map);
        }
        return map[n];

    }

    public static void main(String[] args) {
        int step = 35;
        int[] map = new int[step+1];
        for (int i = 0; i< map.length; i++){
            map[i] = Integer.MIN_VALUE;
        }
        Profiler.begin();
        System.out.println(countWays(step, map));
        System.out.println(Profiler.end());
        System.out.println("------------------------");
        Profiler.begin();
        System.out.println(countWays2(step));
        System.out.println(Profiler.end()/1000.0);
        for (int i : map){
            System.out.println(i);
        }

    }
    public static int countWays2(int n){
        if (n < 0){
            return 0 ;
        }else if (n == 0){
            return 1;
        }
        else {
            return countWays2(n - 1) + countWays2(n - 2) + countWays2(n - 3);
        }


    }
}
