package com.ck.striver.basics.strings;

/*
    Time Complexity:O(n) because we iterate over half of the string's length
    Space Complexity:O(1) as no additional space is used apart from a few variables
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-strings/palindrome-check/submissions
public class PalindromeString {

    public static void main(String[] args){
        String s="abba";
        System.out.println(isPalindromeString(s));
    }

    private static boolean isPalindromeString(String s) {
        int n = s.length();
        for(int i=0;i<n/2;i++){
            if(s.charAt(i)!=s.charAt(n-1-i)) return false;
        }
        return true;
    }
}
