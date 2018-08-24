package leetcode;

import java.util.Arrays;

/**
 * 找得到两个数组中的中位数
 * Created by CharlesYang on 2018/8/23/023.
 */
public class MedianTwo4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }
        for (int j = nums1.length; j < nums.length; j++) {
            nums[j] = nums2[j - nums1.length];
        }
        Arrays.sort(nums);
        if ((nums.length & 1) == 0) {
            return (nums[nums.length / 2 - 1] + nums[nums.length / 2]) / 2.0;
        } else {
            return (nums[nums.length / 2]) / 1.0;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2, 3};
        findMedianSortedArrays(nums1,nums2);
    }
}
