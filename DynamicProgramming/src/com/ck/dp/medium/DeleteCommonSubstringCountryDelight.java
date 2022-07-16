package com.ck.dp.medium;

public class DeleteCommonSubstringCountryDelight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int deleteSubString(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for(int g=0;g<n;g++) {
			for(int i=0,j=g;i<n && j<n;i++,j++) {
				if(g==0)dp[i][j]=0;
			}
		}
		return -1;
	}

}
