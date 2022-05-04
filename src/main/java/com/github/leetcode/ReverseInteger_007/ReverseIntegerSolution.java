package com.github.leetcode.ReverseInteger_007;

public class ReverseIntegerSolution {

    public int reverse(int x) {
        double res = 0;
        while(x!=0){
            int reminder = x%10;
            x/=10;
            res = res * 10 + reminder;
        }
        if(res>Integer.MAX_VALUE || res<Integer.MIN_VALUE){
            return 0;
        }
        return (int)res;
    }

}
