package leetcode;

/**
 * 最长无重复子串
 * Created by CharlesYang on 2018/8/24/024.
 */
public class longestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {

        char[] chars = s.toCharArray();
        int[] m = new int[256];
        for (int i = 0; i < m.length; i++) {
            m[i] = -1;
        }
        int maxLen = 0, start = -1;
        for (int i = 0; i < chars.length; ++i) {
            if (m[chars[i]] > start)
                start = m[chars[i]];
            m[chars[i]] = i;
            maxLen = Math.max(maxLen, i - start);
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        String s = "abcdfad";
        String s = "abcacefg";
        System.out.println(lengthOfLongestSubstring(s));

    }
}
