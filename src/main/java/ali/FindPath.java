package ali;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by CharlesYang on 2018/8/10/010.
 */
public class FindPath {
    static final Point START = new Point(0, 0);
    static int minpath = Integer.MAX_VALUE;

    static class Point {
        int x;
        int y;
        boolean visited;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.visited = false;
        }

        public int distence(Point p) {
            return Math.abs(x - p.x) + Math.abs(y - p.y);
        }
    }

    public static int findMinPath(Point start, ArrayList<Point> points, int sum, int count) {
        if (count == points.size()) {
            minpath = Math.min(minpath, sum + start.distence(START));
            return minpath;
        }
        for (Point point : points) {
            if (!point.visited) {
                sum += point.distence(start);
                if (sum < minpath) {
                    point.visited = true;
                    findMinPath(point, points, sum, count + 1);
                }
                sum -= point.distence(start);
                point.visited = false;
            }
        }
        return minpath;
    }

    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int point_num = Integer.parseInt(scanner.nextLine().trim());

        for (int i = 0; i < point_num; i++) {

            String[] x_y = scanner.nextLine().trim().split(",");

            points.add(new Point(Integer.parseInt(x_y[0]), Integer.parseInt(x_y[1])));
        }

        System.out.println(findMinPath(START, points, 0, 0));
    }
}
