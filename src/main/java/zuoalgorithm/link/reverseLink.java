package zuoalgorithm.link;

/**
 * Created by CharlesYang on 2018/7/19/019.
 */
public class reverseLink {
    static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node getReverse(Node n){

        return n;
    }
    public static Node reverse(Node n){
        if (n.next == null){
            return n;
        }
        Node suc = reverse(n);
        Node temp = n;
        temp.next = suc;
        n.next = n.next.next;
        n.next.next = n;
        return temp.next;


//        n = n.next;
    }
    public static void main(String[] args) {

        String s = new String("1") + new String("2");
        System.out.println(s.intern() == s);
//        String s3 = s.intern();
//        String s2 = "1";
//        System.out.println(s3 == s2);
//        System.out.println(s == s2);


        String str1 = new String("SEU") + new String("Calvin");
        System.out.println(str1.intern() == str1);
        System.out.println(str1 == "SEUCalvin");

    }

}
