package com.github.leetcode.LongestSubstringWithoutRepeatingCharacters_003;

public class LongestSubstringWithoutRepeatingCharactersSolution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0 || s.length()==1) return s.length();

        String longestString = "";
        StringBuilder tmp = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            String t = String.valueOf(s.charAt(i));
            if(tmp.indexOf(t)==-1){
                tmp.append(t);
            }
            else{
                if(tmp.length() >= longestString.length()){
                    longestString = tmp.toString();
                    if(!tmp.substring(tmp.length()-1).equalsIgnoreCase(t)){
                        getTmp(tmp, t);
                    }
                    else {
                        tmp.setLength(0);
                        tmp.append(t);
                    }
                }
                else {
                    getTmp(tmp, t);
                }
            }
        }
        return Math.max(longestString.length(), tmp.length());
    }

    private StringBuilder getTmp(StringBuilder tmp, String t){
        int lastIndex = tmp.indexOf(t);
        String last = tmp.substring(lastIndex + 1);
        tmp.setLength(0);
        tmp.append(last).append(t);
        return tmp;
    }
}
