package com.github.leetcode.ZigzagConversion_006;

import java.util.ArrayList;
import java.util.List;

public class ZigzagConversionSolution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        char[][] arr = new char[numRows][s.length()];
        int dimension=0;
        int loop = numRows-1;
        boolean transitional = false;
        int counter = 0;
        for(int i=0; i<s.length(); i++){
            if(loop != 1 && transitional){
                arr[loop-1][dimension] = s.charAt(i);
                dimension++;
                loop--;
                if(loop==1){
                    transitional=false;
                }
                continue;
            }
            if(counter%(numRows-1)==0 && counter!=0){
                arr[counter][dimension] = s.charAt(i);
                dimension++;
                transitional = true;
                counter=0;
                loop = numRows-1;
                continue;
            }
            arr[counter][dimension] = s.charAt(i);
            counter++;
        }
        StringBuilder sb = new StringBuilder();
        for(int u=0; u< arr.length ; u++){
            for(int k=0; k < arr[u].length; k++){
                if(arr[u][k]!=0){
                    sb.append(arr[u][k]);
                }
            }
        }
        return sb.toString();
    }

    public String leetCodeConvert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        rows.forEach(ret::append);
        return ret.toString();
    }
}
