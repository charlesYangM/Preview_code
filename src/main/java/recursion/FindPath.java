package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * 寻找一个方格中的左上角顶点到右下角顶点的路径
 * Created by CharlesYang on 2018/6/29/029.
 */
public class FindPath {
    private static ArrayList<Point> bans = new ArrayList<Point>(Arrays.asList(new Point(0, 3), new Point(2, 2)));
//    private static ArrayList<Point> bans = new ArrayList<Point>();


    public static boolean getPath(int x, int y, ArrayList<Point> path,
                           Hashtable<Point, Boolean> cache){

        Point p = new Point(x, y);
        path.add(p);

        boolean success = false;

        if (x == 0 && y == 0){
            return true;
        }

        if (cache.contains(p)){
            return cache.get(p);
        }

        if (x > 0 && !isBan(x - 1, y)){
            success = getPath(x - 1, y, path, cache);
        }

        if (!success && y > 0 && !isBan(x, y - 1)){
            success = getPath(x, y - 1, path, cache);
        }

        if(!success){
            path.remove(p);
        }
        cache.put(p,success);
        return success;
    }



    public static boolean isBan(int x, int y){

        Point p = new Point(x, y);
        return bans.contains(p);
    }


    public static void main(String[] args) {
        ArrayList<Point> path = new ArrayList<Point>();
        Hashtable<Point, Boolean> cache = new Hashtable<Point, Boolean>();
        if (getPath(100, 100, path, cache)){
            for (Point p : path){
                System.out.println(p);
            }
        }
    }
}
