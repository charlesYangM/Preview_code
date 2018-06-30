package arrayAndString;

/**
 * Created by CharlesYang on 2018/6/22/022.
 */
public class Permutation {
    public static void main(String[] args) {
        System.out.println(permutaion("ha", "Hah"));
    }
    public static boolean permutaion(String str1, String str2){
        if (str1.length() != str2.length()){
            return false;
        }

        return sort(str1).equals(sort(str2));

    }
    public static String sort(String str){
        char[] chars = str.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }
}
