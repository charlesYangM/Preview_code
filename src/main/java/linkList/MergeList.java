package linkList;

/**
 * Created by CharlesYang on 2018/8/13/013.
 */
public class MergeList {
    static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public static Node merge(Node n1, Node n2) {
        if (n1 == null) {//n1 便利完了就把
            return n2;
        } else if (n2 == null) {
            return n1;
        }
        Node head;
        if (n1.value < n2.value) {
            head = n1;
            head.next = merge(n2, head.next);
        } else {
            head = n2;
            head.next = merge(n1, head.next);
        }
        return head;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node head1 = n1;
        n1.next = new Node(7);
        n1 = n1.next;
        n1.next = new Node(8);

        Node n2 = new Node(2);
        n2.next = new Node(5);

        Node head = merge(head1, n2);

        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }
}
