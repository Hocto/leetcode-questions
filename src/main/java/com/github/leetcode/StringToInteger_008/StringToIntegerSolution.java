package com.github.leetcode.StringToInteger_008;

public class StringToIntegerSolution {
    public int myAtoi(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int result = 0;
        boolean isNegative=false;
        boolean isPositive=false;
        boolean containsNumeric=false;
        boolean firstIsDigit=true;
        char tmp;
        for(int i=0 ; i<s.length() ; i++){
            tmp = s.charAt(i);
            if(containsNumeric && (!Character.isDigit(tmp) || tmp == '+' || tmp == '-')){
                break;
            }
            if(tmp == ' '){
                if(isNegative || isPositive){
                    return 0;
                }
                continue;
            }
            if(Character.isDigit(tmp)){
                if(!firstIsDigit){
                    return 0;
                }
                if(!containsNumeric && tmp == 0){
                    continue;
                }
                stringBuilder.append(tmp);
                containsNumeric = true;
                continue;
            }
            if(tmp == '+'){
                if(isNegative || isPositive){
                    return 0;
                }
                isPositive=true;
                stringBuilder.append(tmp);
                continue;
            }
            if(tmp == '-'){
                if(isPositive || isNegative){
                    return 0;
                }
                isNegative = true;
                stringBuilder.append(tmp);
                continue;
            }
            if(tmp == '.'){
                break;
            }
            firstIsDigit=false;
        }
        if(!containsNumeric){
            return 0;
        }
        if(Double.parseDouble(stringBuilder.toString())<Integer.MIN_VALUE){
            result = Integer.MIN_VALUE;
        }else if (Double.parseDouble(stringBuilder.toString())>Integer.MAX_VALUE){
            result = Integer.MAX_VALUE;
        }else {
            result = Integer.parseInt(stringBuilder.toString());
        }
        return result;
    }
}
