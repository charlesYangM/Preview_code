package collection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by CharlesYang on 2018/7/16/016.
 */
public class HashSetRun {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.addAll(Arrays.asList(new String[] {"hello", "老马"}));
        for (String s : set){
            System.out.println(s + " ");
        }
    }
}
