package arrayAndString;

import java.util.HashMap;

/**
 * Created by CharlesYang on 2018/7/22/022.
 */
public class IsDeformation {
    public static boolean isDefromation(String str1, String str2){


        char[] chstr1 = str1.toCharArray();
        char[] chstr2 = str2.toCharArray();
        int[] len = new int[256];

        for (int i = 0; i < str1.length(); i ++){
            len[chstr1[i]] ++;
        }
        for (int i = 0; i < str2.length(); i ++){
            if (len[chstr2[i]]-- == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        System.out.println((char)(100 -'a')+'a');
        map.put(1, String.valueOf((char)((97 -'a')+'a')));
        System.out.println(map.get(1));
        System.out.println(String.valueOf((char) (1 + 96)));
        System.out.println(isDefromation("123", "2312"));
    }
}
