package generic;

/**
 * Created by CharlesYang on 2018/7/13/013.
 */
public class NumberPair<U extends Number, V extends Number>
        extends Pair<U, V> {
    public NumberPair(U first, V second) {
        super(first, second);
    }

    public double sum(){
        return getFirst().doubleValue() + getSecond().doubleValue();
    }


    public static void main(String[] args) {
        NumberPair<Integer, Double> number = new NumberPair<>(2,3.0);
        System.out.println(number.sum());
    }
}
