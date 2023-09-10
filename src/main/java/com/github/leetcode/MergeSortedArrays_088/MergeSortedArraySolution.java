package com.github.leetcode.MergeSortedArrays_088;

public class MergeSortedArraySolution {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstArrayPointer = m - 1;
        int secondArrayPointer = n - 1;
        int finalArrayPointer = m + n - 1;

        while (secondArrayPointer >= 0) {
            if (firstArrayPointer >= 0 && nums1[firstArrayPointer] > nums2[secondArrayPointer]) {
                nums1[finalArrayPointer--] = nums1[firstArrayPointer--];
            } else {
                nums1[finalArrayPointer--] = nums2[secondArrayPointer--];
            }
        }
    }
}
