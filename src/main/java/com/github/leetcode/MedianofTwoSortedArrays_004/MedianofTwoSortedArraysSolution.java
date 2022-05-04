package com.github.leetcode.MedianofTwoSortedArrays_004;

public class MedianofTwoSortedArraysSolution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int numLength1=nums1.length, numLength2=nums2.length;
        int[] merge = new int[numLength1 + numLength2];
        while (i < numLength1 && j < numLength2) {
            if (nums1[i] < nums2[j])
                merge[k++] = nums1[i++];
            else
                merge[k++] = nums2[j++];
        }
        while (i < numLength1)
            merge[k++] = nums1[i++];
        while (j < numLength2)
            merge[k++] = nums2[j++];
        int length = merge.length;
        return length % 2 == 0 ? (double) (merge[(length/2)-1] + merge[(length/2)])/2 : (double) merge[(length/2)];
    }
}
