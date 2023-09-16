package com.github.leetcode.RemoveDuplicatesFromSortedArray_026;

public class RemoveDuplicatesFromSortedArraySolution {

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }

        int k = 1;
        int firstPointer = 0;
        int secondPointer = 1;

        while (secondPointer < nums.length) {
            if (nums[firstPointer] == nums[secondPointer]) {
                secondPointer++;
            } else {
                nums[firstPointer + 1] = nums[secondPointer];
                firstPointer++;
                secondPointer++;
                k++;
            }
        }

        return k;
    }
}
