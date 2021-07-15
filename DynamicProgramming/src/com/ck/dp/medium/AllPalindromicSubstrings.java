package com.ck.dp.medium;

// LC - 647 : Palindromic Substrings
// https://leetcode.com/problems/palindromic-substrings/
// Help - https://www.youtube.com/watch?v=XmSOWnL6T_I
// Refer Manchers Algorithm for O(N) time complexity
public class AllPalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countSubstrings("abc"));
	}

	// O(N*N) time and O(N*N) space
	public static int countSubstrings(String s) {
		int cnt = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		// g is for gap between start and end chars of substring
		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; i < s.length() && j < s.length(); i++, j++) {
				if (i == j) {
					dp[i][j] = true;
					cnt++;
				} else if (g == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = true;
						cnt++;
					} else
						dp[i][j] = false;
				} else {
					if (s.charAt(i) == s.charAt(j))
						dp[i][j] = dp[i + 1][j - 1];
					else
						dp[i][j] = false;
					if (dp[i][j])
						cnt++;
				}
			}
		}
		return cnt;
	}

}
