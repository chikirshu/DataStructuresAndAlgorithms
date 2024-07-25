package com.ck.strings.medium;

// LC - 6. Zigzag Conversion
// https://leetcode.com/problems/zigzag-conversion/description/
public class ZigZagConversion {

    public static void main(String[] args){
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {

        if(numRows==1) return s;

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<numRows;i++){
            int idx = i;
            int deltaUp = 2*i;
            int deltaDown = 2*(numRows-1-i);
            boolean downDirection = true;

            while(idx<s.length()){
                sb.append(s.charAt(idx));

                if(i==0){
                    idx+=deltaDown;
                    continue;
                }
                else if(i==numRows-1){
                    idx+=deltaUp;
                    continue;
                }
                if(downDirection) idx+=deltaDown;
                else idx+=deltaUp;

                downDirection=!downDirection;
            }
        }
        return sb.toString();
    }
}
