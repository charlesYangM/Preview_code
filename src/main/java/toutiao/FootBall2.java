package toutiao;

import java.util.Scanner;

/**
 * 寻找球迷中的最大球迷数 和 球队数量
 * Created by CharlesYang on 2018/8/14/014.
 */
public class FootBall2 {
    static int P;
    static int qMax;
    static int Q;

    static class Fan {
        int value;
        public Fan(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] m_n = scanner.nextLine().trim().split(",");
        int m = Integer.valueOf(m_n[0]);
        int n = Integer.valueOf(m_n[1]);
        Fan[][] foot_matrix = new Fan[m][n];


        for (int i = 0; i < foot_matrix.length; i++) {
            String[] fans = scanner.nextLine().trim().split(",");
            for (int j = 0; j < fans.length; j++) {
                foot_matrix[i][j] = new Fan(Integer.valueOf(fans[j]));
            }
        }
        //遍历整个观众席
        for (int i = 0; i < foot_matrix.length; i++) {
            for (int j = 0; j < foot_matrix[0].length; j++) {
                if (foot_matrix[i][j].value == 1) {
                    P++;
                    find(i, j, foot_matrix);
                    qMax = Math.max(qMax, Q);
                    Q = 0;
                }
            }
        }
        System.out.println(P + " "+qMax);
    }

    /**
     * 将一个球队附近的节点递归地变为0，这样同一个球队的球员都会被赋值为0
     * @param i
     * @param j
     * @param fans
     */
    public static void find(int i, int j, FootBall2.Fan[][] fans) {
        if (i < 0 || j < 0 || i >= fans.length || j >= fans[0].length) {
            return;
        }
        FootBall2.Fan fan = fans[i][j];   //如果不等于1就不是球迷直接忽略，
        if (fan.value != 1) {
            return;
        }

        fan.value = 0;
        Q++;
        find(i - 1, j - 1, fans);
        find(i - 1, j, fans);
        find(i - 1, j + 1, fans);
        find(i, j - 1, fans);
        find(i, j + 1, fans);
        find(i + 1, j - 1, fans);
        find(i + 1, j, fans);
        find(i + 1, j + 1, fans);
    }
}
