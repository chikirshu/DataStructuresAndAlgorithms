package com.ck.dp.medium;

// LC - 5 : Longest Palindromic Substring
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindromeI("cbbd"));
		System.out.println(longestPalindromeII("cbbd"));
	}

	// will give TLE for large string O(N*N*K/2)
	public static String longestPalindromeI(String s) {
		String res = String.valueOf(s.charAt(0));
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (checkPalindrome(s.substring(i, j + 1))) {
					if ((j - i + 1) > res.length())
						res = s.substring(i, j + 1);
				}
			}
		}
		return res;
	}

	// O(N*N) time and O(N*N) space using dp
	public static String longestPalindromeII(String s) {
		String res = String.valueOf(s.charAt(0));
		boolean[][] dp = new boolean[s.length()][s.length()];
		// g is for gap between start and end chars of substring
		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < s.length(); i++, j++) {
				if (i == j) {
					dp[i][j] = true;
				} else if (g == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = true;
						if (res.length() < g + 1)
							res = s.substring(i, j + 1);
					} else
						dp[i][j] = false;
				} else {
					if (s.charAt(i) == s.charAt(j))
						dp[i][j] = dp[i + 1][j - 1];
					else
						dp[i][j] = false;
					if (dp[i][j])
						if (res.length() < g + 1)
							res = s.substring(i, j + 1);
				}
			}
		}
		return res;
	}

	private static boolean checkPalindrome(String s) {
		if (s.length() == 1)
			return true;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - i - 1))
				return false;
		}
		return true;
	}

}
