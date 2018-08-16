package huawei;

import java.util.*;

/**
 * Created by CharlesYang on 2018/8/15/015.
 */
public class Party {
    public static class timeIv
    {
        int start;
        int end;

        public timeIv(String str)
        {
            String[] time = str.split(",");
            this.start = Integer.valueOf(time[0]);
            this.end = Integer.valueOf(time[1]);
        }

        public boolean isContain(int start,int end)
        {
            return this.start<= start && this.end>=end;
        }
    }

    public static void find(List<timeIv> times)
    {
        if (times == null || times.isEmpty())
        {
            return;
        }

        for (int i =12 ; i <=19; i++)
        {
            int end = i+1;
            int count = 0;
            for(timeIv timin : times)
            {
                if(timin.isContain(i,end))
                {
                    count ++;
                }
            }
            System.out.println(String.format("[%d,%d):%d",i ,end, count));
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String time;
        List<timeIv> times = new ArrayList<>();
        while (!(time = scanner.next()).equals("-1,-1"))
        {
            times.add(new timeIv(time));
        }
        find(times);
    }
}