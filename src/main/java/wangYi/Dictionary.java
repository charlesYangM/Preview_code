package wangYi;

import java.util.Arrays;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            System.out.println(findKth(n, m, k));

        }
    }

    public static String findKth(int n, int m, int k) {

        if ((k - 2) > n * m + 2) return "-1";

        char[] dictionary = new char[n + m];

        if (k == 1) {
            Arrays.fill(dictionary, 0, n, 'a');
            Arrays.fill(dictionary, n, n + m, 'z');
            return String.valueOf(dictionary);
        }

        int overNum = (k - 2) / m;
        int leftNum = (k - 2) % m;

        if (leftNum == 0) {
            Arrays.fill(dictionary, n + m - overNum, n + m, 'a');
            for (int i = 0; i < n - overNum; i++) {
                dictionary[i] = 'a';
            }
            for (int i = n - overNum; i < n + m - overNum; i++) {
                dictionary[i] = 'z';
            }
            return String.valueOf(dictionary);
        }

        Arrays.fill(dictionary, n + m - overNum, n + m, 'a');
        dictionary[n - 1 + leftNum] = 'a';
        int zIndex = 0;
        int zPosition = (n + m - overNum - 1);
        while (zIndex < m) {
            if (zPosition != (n - 1 + leftNum)) {
                dictionary[zPosition--] = 'z';
                zIndex++;
            }
        }

        for (int i = 0; i <= zPosition; i++) {
            if (dictionary[i] != 'z' && dictionary[i] != 'a')
                dictionary[i] = 'a';
        }


        return String.valueOf(dictionary);
    }

}
