package generic;

/**
 * Created by CharlesYang on 2018/7/13/013.
 */
public class Pair<U, V> {
    U first;
    V second;

    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public void setFirst(U first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("张三", 59);

        System.out.println(pair.getFirst());
    }
}
