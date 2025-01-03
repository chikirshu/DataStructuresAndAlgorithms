package com.ck.striver.basics.maths;

/*
    Time Complexity:O(d) where d is the number of digits in the integer n
    Space Complexity:O(1) as only a fixed number of extra variables are used
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/palindrome-number/submissions
public class IsPalindromeNumber {

    public static void main(String[] args){
        int n=121;
        System.out.println(isPalindromeNumber(n));
    }

    private static boolean isPalindromeNumber(int n) {
        int originalCount=n;
        int sum=0;
        while(n!=0){
            int rem=n%10;
            sum = sum*10+rem;
            n=n/10;
        }
        return sum==originalCount;
    }
}
