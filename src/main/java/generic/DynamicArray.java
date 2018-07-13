package generic;

/**
 * Created by CharlesYang on 2018/7/13/013.
 */
public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;
    public DynamicArray(){
        this.elementData = new Object[DEFAULT_CAPACITY];

    }

    public void add(E e){
        elementData[size++] = e;
    }

    public E get(int i ){
        return (E) elementData[i];
    }


    public void addAll(DynamicArray<? extends E> c){
        for (int i = 0; i < c.size; i++) {
            add(c.get(i));
        }
    }

    public static <E> void swapInternal(DynamicArray<E> arr, int i, int j){
        E temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j,temp);
    }
    public static  void swap(DynamicArray<?> arr, int i, int j){
        swapInternal(arr, i, j);
    }
    private void set(int index, E elemt) {
        elementData[index] = elemt;
    }

    public static void main(String[] args) {
        DynamicArray<Integer> ints = new DynamicArray<>();
        DynamicArray<Number> numbers = new DynamicArray<>();
        DynamicArray<? extends Number> numbers2 = ints;

        ints.add(100);
        ints.add(34);
        numbers2.swap(ints, 0, 1);

        System.out.println(ints.get(0));
        numbers.add(new Double(3.0));
        numbers.addAll(ints);
//        numbers2.add(1);

    }
}
