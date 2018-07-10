package ArrayListContain;

/**
 * Created by CharlesYang on 2018/7/5/005.
 */
public class BytePrint {
    public static void main(String[] args) {
        int n = 1000000;
        byte[] bit = new byte[n];

        for (int i = 0; i < n ; i++){
            bit[i] = 2;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(bit[i]);
        }
    }
}
