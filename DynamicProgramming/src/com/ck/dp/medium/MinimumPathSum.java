package com.ck.dp.medium;

// LC - 64 : Minimum Path Sum
// https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum {

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
	}
	
	public static int minPathSum(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[] dp = new int[n], temp = new int[n];
        for(int i=m-1;i>=0;i--){
            temp=dp;
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j!=n-1){
                    dp[j]=grid[i][j]+dp[j+1];
                }
                else if(j==n-1){
                    dp[j]=grid[i][j]+temp[j];
                }
                else if(j!=n-1){
                    dp[j]=grid[i][j]+Math.min(temp[j],dp[j+1]);
                }
                // System.out.println(Arrays.toString(dp));
            }
        }
        return dp[0];
    }

}
