package com.ck.dp.medium;

import java.util.ArrayList;
import java.util.List;
// very nice problem
// LC - 62 : Unique Paths
// https://leetcode.com/problems/unique-paths/
// Reference - https://www.youtube.com/watch?v=sdE0A2Oxofw&t=742s - Stryver
public class FindUniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePathsIII(3,7));// fastest
		System.out.println(uniquePathsII(3,7));// faster
		System.out.println(uniquePathsI(3,7));// slower
		
	}
	
	// Recursion - will give TLE in LC -  - Time complexity - O(2^(m+n-1)){destination cell will not do any further calls that's why -1}; Space Complexity - O(m-1 + n-1) {for storing stack data of each path} + O(nxm){for memo matrix}
	public static int uniquePathsI(int m, int n) {
		List<Integer> list = new ArrayList<>();
        int res =  fetchCountsI(m,n,0,0,list);
        System.out.println("Recursive loop calls = "+list.size());
        return res;
    }
    
    public static int fetchCountsI(int m, int n, int r, int c, List<Integer> loopCalls){
    	loopCalls.add(1);
        if(r>=m || c>=n){
            return 0;
        }
        
        if(r==m-1 && c==n-1){
            return 1;
        }
        
        return fetchCountsI(m,n,r,c+1,loopCalls) + fetchCountsI(m,n,r+1,c,loopCalls);
    }
    
    // Memoization - Time complexity - O(m*n){each cell is visited once}; Space Complexity - O(m-1 + n-1) {for storing stack data of each path} + O(nxm){for memo matrix}
    public static int uniquePathsII(int m, int n) {
    	List<Integer> list = new ArrayList<>();
        int res = fetchCountsII(m,n,0,0, new int[m][n], list);
        System.out.println("Memoization loop calls = "+list.size());
        return res;
    }
    
    public static int fetchCountsII(int m, int n, int r, int c, int [][] memo, List<Integer> loopCalls){
    	loopCalls.add(1);
        if(r>=m || c>=n){
            return 0;
        }
        
        if(r==m-1 && c==n-1){
            return 1;
        }
        
        if(memo[r][c]!=0){
            return memo[r][c];
        }
        int res = fetchCountsII(m,n,r,c+1,memo, loopCalls);
        memo[r][c] += res;
        res = fetchCountsII(m,n,r+1,c,memo, loopCalls);
        memo[r][c] += res;
        
        return memo[r][c];
    }
    
    // DP Tabulation - Time complexity - O(nxm); Space Complexity - O(n-1) (considering the array grid is already given)
    public static int uniquePathsIII(int m, int n) {
        return fetchCountsIII(new int[m][n]);
    }
    
    public static int fetchCountsIII(int[][] arr){
        int m= arr.length, n=arr[0].length;
        int[] dp = new int[n], temp = new int[n];
        
        for(int i=m-1;i>=0;i--){
            temp=dp;
            for(int j=n-1;j>=0;j--){
                if(j==n-1 && i==m-1) dp[n-1]=1;
                else{
                    if(j!=n-1)
                        dp[j] = dp[j+1]+temp[j];
                }
            }
            //System.out.println(Arrays.toString(dp));
        }
        return dp[0];
    }

}
