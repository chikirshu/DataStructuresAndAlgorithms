package com.ck.strings.medium;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Tom and Jerry
// Tom and Jerry love to play games so they both put separate strings string S1 and string S2 respectively and they want to check whether they both are friends or not. If we delete any character from the S1 and obtain the string S2 at last then they both are friends otherwise they are not. Without changing the order of the strings. so tom and jerry want you to check whether they are friends or not.
// Note: Spaces do NOT present in the strings..
// Sample Input
// 4
// 12sd78f
// sf
// 12345efd
// 1e3d
// ijkfgds
// jkf
// 1111456
// 116
// 
// Sample Output
// YES
// NO
// YES
// YES
public class SkillenzaEzeTap {

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			int k = 0;
			String[] arr = new String[2 * t];
			for (int i = 0; i < t; i++) {
				arr[k++] = br.readLine();
				arr[k++] = br.readLine();
			}
			for (int i = 0; i < arr.length; i = i + 2) {
				System.out.println(areFriends(arr[i], arr[i + 1]));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String areFriends(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (s2.charAt(i) == s1.charAt(j))
					dp[i][j] = 1 + dp[i + 1][j + 1];
				else
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
			}
		}
		return dp[0][0] == s2.length() ? "YES" : "NO";
	}
}
