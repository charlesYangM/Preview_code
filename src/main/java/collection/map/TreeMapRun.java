package collection.map;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by CharlesYang on 2018/7/17/017.
 */
public class TreeMapRun {
    public static void main(String[] args) {
//        ByteBuffer.allocateDirect()
        Map<String, String> map = new TreeMap<>(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
        map.put("a", "abstract");
        map.put("c", "call");
        map.put("b", "basic");
        map.put("T", "tree");
        for (Map.Entry<String, String> kv : map.entrySet()){

            System.out.println(kv.getKey() + " = " + kv.getValue());
        }

    }


}
