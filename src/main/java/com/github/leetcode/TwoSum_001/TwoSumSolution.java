package com.github.leetcode.TwoSum_001;

import java.util.*;

public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> integerMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            final int diff = target - nums[i];
            if (integerMap.containsKey(diff)) {
                return new int[]{integerMap.get(diff), i};
            }
            integerMap.putIfAbsent(nums[i], i);
        }
        return nums;
    }
}
