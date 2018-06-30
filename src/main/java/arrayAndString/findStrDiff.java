package arrayAndString;

/**
 * 实现一个算法，确定一个字符串的所有字符是否全都不相同。假使不用需使用额外的数据结构，又该如何处理（第108页）
 * Created by CharlesYang on 2018/6/22/022.
 */


public class findStrDiff {
    public static void main(String[] args) {
//        System.out.println(getReturn(2));
        System.out.println(isUniqueChars("sldkfjsldkjfsdflkj"));
    }
    public static boolean isUniqueChars(String str) {
        char[] chars = str.toCharArray();

        if (chars.length > 256){
            return false;
        }
        boolean[] char_set = new boolean[256];
        for (int i = 0; i< chars.length; i++){
            int ind = (int)str.charAt(i);
            if (char_set[ind]){
                return false;
            }else {
                char_set[ind] = true;
            }
        }
        return true;
    }

    public static int getReturn(int a){
        try{
            a = 2;
            return ++a;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
//            return a;
        }
        return a;
    }
}
