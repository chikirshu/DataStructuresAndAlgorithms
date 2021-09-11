package com.ck.dp.medium;

// GFG - Longest common subarray in the given two arrays
// https://www.geeksforgeeks.org/longest-common-subarray-in-the-given-two-arrays/
// Total sub arrays - n*(n+1)/2
public class LongestCommonSubarray {

	public static void main(String[] args) {
		System.out.println(getSizeLongestCommonSubArray(new int[] { 1, 2, 8, 2, 1 }, new int[] { 8, 2, 1, 4, 7 }));
	}

	// Time complexity is O(N*M); Space Complexity is O(N*M)
	public static int getSizeLongestCommonSubArray(int[] a, int[] b) {

		int n = a.length;
		int m = b.length;
		int max=0;
		int[][] dp = new int[n + 1][m + 1]; // m+1 and n+1 coz of code at line 20
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				if(a[i]==b[j]) {
					dp[i][j]=dp[i+1][j+1]+1;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				max= Math.max(max, dp[i][j]);
			}
		}
		return max;
	}

}
