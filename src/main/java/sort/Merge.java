package sort;

/**
 * Created by CharlesYang on 2018/6/23/023.
 */
public class Merge {
    private static Comparable[] aux;

    public static void main(String[] args) {
        String[] strs = {"a","d","E","E","g","t","r","sdd"};
        sort(strs);

        for (String s : strs){
            System.out.print(s + " ");
        }

    }
    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo){
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo, j = mid +1;

        System.arraycopy(a, lo, aux, lo, hi + 1 - lo);

        for (int k = lo; k <= hi; k++){
            if (i > mid){
                a[k] = aux[j++];
            }else if (j > hi){
                a[k] = aux[i++];
            }else if (less(aux[j],aux[i])){
                a[k] = aux[j++];
            }else {
                a[k] = aux[i++];
            }
        }
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }
}
