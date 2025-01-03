package com.ck.striver.basics.strings;

// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-strings/largest-odd-number-in-a-string/submissions
public class NiceMaxOddNumberInString {

    public static void main(String[] args){
        String s = "05347";
        System.out.println(getMaxOddNumberInStringII(s));
    }

    // will fail for 10518744893355417179
    private static String getMaxOddNumberInStringI(String s) {

        Long max = Long.MIN_VALUE;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<=s.length();j++){
                String crntString = s.substring(i, j);
                Long num = Long.valueOf(crntString);
                if(num%2!=0 && num>=max) max=num;
            }
        }
        return max==Long.MIN_VALUE?String.valueOf(0):String.valueOf(max);
    }

    /*
        Time Complexity:O(n) where n is the length of the string as there are two separate scans through the string
        Space Complexity:O(1) as only a fixed number of integer variables are used, regardless of the input size
    */
    private static String getMaxOddNumberInStringII(String s) {

        int start=0, end=0;
        for(int i=0;i<s.length();i++){
            if(Integer.valueOf(String.valueOf(s.charAt(i)))!=0){
                start=i;
                break;
            }
        }

        for(int i=s.length()-1;i>=0;i--){
            if(Integer.valueOf(String.valueOf(s.charAt(i)))%2!=0){
                end=i;
                break;
            }
        }
        return s.substring(start,end+1);
    }
}
