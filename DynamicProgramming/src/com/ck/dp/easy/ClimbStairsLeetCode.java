package com.ck.dp.easy;

// LC - 70: Climbing Stairs
// https://leetcode.com/problems/climbing-stairs/
public class ClimbStairsLeetCode {

	public static void main(String[] args) {
		System.out.println(climbStairs(5));
	}
	
	public static int climbStairs(int n) {
        
        int[]  dp = new int[n+1];
        dp[n] = 1;
        dp[n-1] = 1;
        
        for(int i=n-2;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }
        
        return dp[0];
    }

}
