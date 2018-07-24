package zuoalgorithm.link;

/**
 * Created by CharlesYang on 2018/7/17/017.
 */
public class PrintTwoLink {
    static class Node{
        public int value;
        public Node next;
        public Node(int value){
            this.value = value;
        }
    }

    private static void printCommonPart(Node n1, Node n2){
        while(n1 != null && n2 != null){
            if (n1.value < n2.value){
                n1 = n1.next;
            }else if (n2.value < n1.value){
                n2 = n2.next;
            }else if (n1.value == n2.value){
                System.out.println(n1.value);
                n1 = n1.next;
                n2 = n2.next;
            }
        }
    }
    public static void main(String[] args) {
        Node n1 = new Node(0);
        Node n2 = new Node(6);

        Node first = n1;
        Node first2 = n2;
        for (int i = 1; i < 10; i++){
            n1.next = new Node(i);
            n1 = n1.next;
            n2.next = new Node(i);
            n2 = n2.next;
        }
        Node p = first;
//        System.out.print("n1 :");
//        while(p != null){
//
//            System.out.print(p.value + " ");
//
//            p = p.next;
//        }
//        System.out.println();
        p = first2;
//        System.out.print("n2 :");
//        while(p != null){
//
//            System.out.print(p.value + " ");
//
//            p = p.next;
//        }

        printCommonPart(first, first2);
//        Node p = first;
//        while(p != null){
//            System.out.println(p.value);
//            p = p.next;
//        }
    }
}
