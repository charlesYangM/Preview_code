package collection.map;

import java.util.*;

/**
 * Created by CharlesYang on 2018/7/17/017.
 */
public class TreeSetRun {
    public static void main(String[] args) {

        Set<String> words = new TreeSet<>();

        words.addAll(Arrays.asList(new String[]{
                "trre", "map", "hash", "Map"
        }));

        Map<String, Integer> accessMap = new LinkedHashMap<>(16, 0.75f, true);

        accessMap.put("c", 100);
        accessMap.put("d", 200);
        accessMap.put("a", 500);
        accessMap.get("c");
        accessMap.put("d", 100);
        for (Map.Entry<String, Integer> w : accessMap.entrySet()){
            System.out.println(w);
        }
    }
}
