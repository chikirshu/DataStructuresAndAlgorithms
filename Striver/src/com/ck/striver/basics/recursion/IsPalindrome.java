package com.ck.striver.basics.recursion;

/*
    Time Complexity:O(n) because it iterates through half of the string length
    Space Complexity:O(n) for the character array used to store the string
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-recursion/check-if-string-is-palindrome-or-not-
public class IsPalindrome {

    public static void main(String[] args){

        String s = "aabbaa";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n=arr.length;
        for(int i=0;i<n/2;i++){
            if(arr[i]!=arr[n-1-i]) return false;
        }
        return true;
    }
}
