package com.ck.dp.easy;

import java.util.Scanner;

public class climbStairs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		//System.out.println(findPathI(n));
		//System.out.println(findPathII(n,arr));
		System.out.println(findPathIII(n));
	}

	// Recursion
	public static int findPathI(int n) {
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		System.out.println("Hello "+n);
		int cntPath1 = findPathI(n - 1);
		int cntPath2 = findPathI(n - 2);
		int cntPath3 = findPathI(n - 3);

		return cntPath1 + cntPath2 + cntPath3;
	}
	
	// DP Memoize - from n to 0
	public static int findPathII(int n,int[] qb) {
		
		if(n==0) {
			return 1;
		}
		else if(n<0) {
			return 0;
		}
		if(qb[n]>0) {
			return qb[n];
		}
		System.out.println("Hello "+ n);
		int cntPath1 = findPathII(n-1,qb);
		int cntPath2 = findPathII(n-2,qb);
		int cntPath3 = findPathII(n-3,qb);
		
		int res = cntPath1 + cntPath2 + cntPath3;
		qb[n] = res;
		
		return res;
		
	}
	
	// DP Table - from 0 to n
	// Decide 3 things - 1) create storage and give meaning 2) identify direction 3) Traverse and solve
	public static int findPathIII(int n) {
		int[] dp = new int[n+1];
		dp[0]=1;
		for(int i=1;i<=n;i++) {
			System.out.println("Hello "+i);
			if(i==1) {
				dp[i]=dp[i-1];
			}
			else if(i==2) {
				dp[i]=dp[i-1]+dp[i-2];
			}
			else {
				dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
			}
		}
		return dp[n];
	}

}
