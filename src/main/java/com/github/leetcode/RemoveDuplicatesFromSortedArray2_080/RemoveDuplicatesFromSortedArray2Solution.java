package com.github.leetcode.RemoveDuplicatesFromSortedArray2_080;

public class RemoveDuplicatesFromSortedArray2Solution {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            nums[j++] = nums[i++];
            if (i < nums.length && nums[i] == nums[j - 1]) {
                nums[j++] = nums[i++];
            }
            while (i < nums.length && nums[i] == nums[j - 1]) {
                i++;
            }
        }
        return j;
    }
}
