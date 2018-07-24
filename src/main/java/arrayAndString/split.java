package arrayAndString;

/**
 * Created by CharlesYang on 2018/7/23/023.
 */
public class split {
    public static void main(String[] args) {
        String ss = ",aa,bb,cc,dd,,,";
        String[] array = ss.split(",");
        System.out.println(array.length);
    }
}

