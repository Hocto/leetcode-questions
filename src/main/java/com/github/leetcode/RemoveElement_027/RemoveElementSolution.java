package com.github.leetcode.RemoveElement_027;

import java.util.LinkedList;
import java.util.Queue;

public class RemoveElementSolution {

    public int removeElement(int[] nums, int val) {

        int index = 0;
        int counter = 0;
        Queue<Integer> indexes = new LinkedList<>();
        while (index < nums.length) {
            if (nums[index] == val) {
                indexes.offer(index);
                counter++;
                index++;
            } else {
                if (counter > 0 && indexes.peek() != null) {
                    int availableIndex = indexes.poll();
                    nums[availableIndex] = nums[index];
                    nums[index] = val;
                    counter--;
                } else {
                    index++;
                }
            }

        }

        return nums.length - counter;
    }

}
