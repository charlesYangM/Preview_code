package arrayAndString;

/**
 * Created by CharlesYang on 2018/6/22/022.
 */
public class replaceSpace {
    public static void main(String[] args) {
        replace("13 ");
    }
    public static void replace(String str){
        char[] chars = str.toCharArray();
        int len = chars.length;
        int spaceCount = 0;
        for (int i = 0; i < len; i++){
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }

        int newlen = len + 2 * spaceCount;

        char[] newchar = new char[newlen];

        for (int j = len -1; j >= 0; j--){
            if (chars[j] == ' '){
                newchar[newlen - 1] = '0';
                newchar[newlen - 2] = '2';
                newchar[newlen - 3] = '%';
                newlen = newlen - 3;
            }else {
                newchar[newlen - 1] = chars[j];
                newlen = newlen -1;
            }
        }
        System.out.println(new String(newchar));
    }
}
