package com.ck.dp.medium;

import java.util.ArrayList;
import java.util.List;

// LC - 62 : Unique Paths
// https://leetcode.com/problems/unique-paths/
public class FindUniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePathsII(3,7));// faster
		System.out.println(uniquePathsI(3,3));// slower
		
	}
	
	// Recursion - will give TLE in LC
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
    
    // Memoization
    public static int uniquePathsII(int m, int n) {
    	List<Integer> list = new ArrayList<>();
        int res = fetchCountsII(m,n,0,0, new int[m][n], list);
        System.out.println("Memoization loop calls = "+list.size());
        return res;
    }
    
    public static int fetchCountsII(int m, int n, int r, int c, int [][] dp, List<Integer> loopCalls){
    	loopCalls.add(1);
        if(r>=m || c>=n){
            return 0;
        }
        
        if(r==m-1 && c==n-1){
            return 1;
        }
        
        if(dp[r][c]!=0){
            return dp[r][c];
        }
        int res = fetchCountsII(m,n,r,c+1,dp, loopCalls);
        dp[r][c] += res;
        res = fetchCountsII(m,n,r+1,c,dp, loopCalls);
        dp[r][c] += res;
        
        return dp[r][c];
    }

}
