package com.ck.striver.basics.recursion;

/*
    Time Complexity:O(n) due to the loop checking divisibility up to n/2.
    Space Complexity:O(1) since no additional space is used that grows with input.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-recursion/check-if-a-number-is-prime-or-not/submissions
public class IsPrimeNumber {

    public static void main(String[] args){
        int n=343;
        System.out.println(isPrimeNumber(n));
    }

    private static boolean isPrimeNumber(int n) {
        // can also use Math.sqrt(n)
        for(int i =2;i<n/2;i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
