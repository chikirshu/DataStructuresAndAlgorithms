package com.ck.dp.medium;

// GFG - Longest Common Subsequence
// https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1#
// Help - https://www.youtube.com/watch?v=0Ql40Llp09E
// Total subsequence - 2^n (considering empty string)
public class LongestCommonSequence {

	public static void main(String[] args) {
		System.out.println(lcs(5, 5, "ABCDGH", "AEDFHR"));
	}

	public static int lcs(int x, int y, String s1, String s2) {
		// your code here
		int n = s1.length(), m = s2.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m-1; j >= 0; j--) {
				char c1 = s1.charAt(i);
				char c2 = s2.charAt(j);
				if (c1 == c2) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		return dp[0][0];
	}

}
