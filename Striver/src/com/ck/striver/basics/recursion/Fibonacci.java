package com.ck.striver.basics.recursion;

/*
    Time Complexity:The time complexity of the given code is O(n) due to the memoization in the recursive callswhich ensures each number is computed once.
    Space Complexity:The space complexity of the given code is O(n) for storing Fibonacci numbers in the dp array.
*/

// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-recursion/fibonacci-number/submissions
public class Fibonacci {

    public static void main(String[] args){
        int n = 4;
        System.out.println(getFibonacci(n));
    }

    private static int getFibonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        return getOptimisedFibonacci(n, dp);
    }

    private static int getOptimisedFibonacci(int n, int[] dp) {
        if(n==0) return dp[0];
        if(dp[n]>0) return dp[n];

        dp[n] = getOptimisedFibonacci(n-1, dp) + getOptimisedFibonacci(n-2, dp);

        return dp[n];
    }
}
