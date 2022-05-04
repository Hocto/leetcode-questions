package com.github.leetcode.LongestPalindromicSubstring_005;

public class LongestPalindromicSubstringSolution {
    public String longestPalindrome(String s) {
        String result = "";
        int maxLength = 0;
        boolean isOdd;
        for (int index = 0; index < s.length(); index++) {
            int left = index;
            int right = index;
            isOdd = false;
            while(true){
                while ((left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))) {
                    if (maxLength < right-left+1) {
                        result= s.substring(left,right+1);
                        maxLength = right-left+1;
                    }
                    left--;
                    right++;
                }
                if(isOdd){
                    break;
                }

                left = index;
                right = index + 1;
                isOdd = true;
            }
        }
        return result;
    }
}
