package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by CharlesYang on 2018/7/16/016.
 */
public class HashStatistic {
    public static void main(String[] args) {
        Random rnd = new Random();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            int num = rnd.nextInt(4);
            Integer count = countMap.get(num);
            if (count == null){
                countMap.put(num, 1);
            }else {
                countMap.put(num, count + 1);

            }

        }

        for (Map.Entry<Integer, Integer> kv : countMap.entrySet()){
            System.out.println(kv.getKey() + ", " + kv.getValue());
        }
    }



}
