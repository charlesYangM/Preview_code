package arrayAndString;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by CharlesYang on 2018/7/22/022.
 */
public class Cart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n , m = 0;
        HashMap<Integer, String> map = new HashMap<>();
        int[] players = new int[256];
        int line = 0;
        while (sc.hasNextLine()){
            if (line == 0){
                String str = sc.nextLine();
                String arr[] = str.split(" ");
                n = Integer.valueOf(arr[0]);//使用valueof有缓存
                m = Integer.valueOf(arr[1]);

            }else {
                String str = sc.nextLine();
                char[] votes = str.toCharArray();
                for (int i = 0; i < votes.length; i++){
                    int ind = (int)votes[i];
                    players[ind]++;
                }
            }
            if (m == line){
                break;
            }
            line ++;
        }

        for (int i = 0; i < players.length; i++){
            if (players[i] > 0){
                map.put(players[i], String.valueOf((char)(i + 96)));
            }
        }

//        map.put(100, (char) (b + 48));
//        for (int)
        System.out.println(map.entrySet());

    }

}
