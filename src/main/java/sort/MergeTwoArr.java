package sort;

/**
 * 使用递归合并两个有序数组
 * Created by CharlesYang on 2018/8/14/014.
 */
public class MergeTwoArr {
    static int[] arr1 = {1, 3, 4};
    static int[] arr2 = {2, 2, 2, 99, 100};
    static int[] merge = new int[arr1.length + arr2.length];

    public static void main(String[] args) {
        merge(arr1, arr2, 0, 0, 0);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i]);
        }
    }

    public static void merge(int[] arr1, int[] arr2, int i, int j, int ind) {
        if (ind == merge.length - 1) {//这里已经是最后一位了，所以不用再继续排序
            return;
        }
        if (i == arr1.length) {
            while (j < arr2.length) {
                merge[ind++] = arr2[j++];
            }
        } else if (j == arr2.length) {
            while (i < arr1.length) {
                merge[ind++] = arr1[i++];
            }
        } else if (arr1[i] < arr2[j]) {
            merge[ind++] = arr1[i++];
            merge(arr1, arr2, i, j, ind);
        } else {
            merge[ind++] = arr2[j++];
            merge(arr1, arr2, i, j, ind);
        }
    }
}
