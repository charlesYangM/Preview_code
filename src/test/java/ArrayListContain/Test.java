package ArrayListContain;

import junit.framework.TestCase;
import recursion.Point;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by CharlesYang on 2018/6/29/029.
 */
public class Test extends TestCase {

    public void testContain(){
        ArrayList<Point> points = new ArrayList<Point>(Arrays.asList(new Point(1,2)));

        assert points.contains(new Point(1,2));
    }
}
