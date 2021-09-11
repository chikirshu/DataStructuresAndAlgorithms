package com.ck.dp.medium;

import java.util.Arrays;

// https://www.youtube.com/watch?v=odrfUCS9sQk
public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(longestIncreasingSubsequence(new int[] { 10, 22, 9, 33, 21, 50, 41, 60, 80, 3 }));
	}

	public static int longestIncreasingSubsequence(int[] arr) {

		int[] dp = new int[arr.length];
		int max = 0, oMax = 0;
		for (int i = 0; i < arr.length; i++) {
			max = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					max = Math.max(max, dp[j]);
				}
			}
			dp[i] = max + 1;
			oMax = Math.max(oMax, dp[i]);
		}
		System.out.println(Arrays.toString(dp));
		return oMax;
	}

}
