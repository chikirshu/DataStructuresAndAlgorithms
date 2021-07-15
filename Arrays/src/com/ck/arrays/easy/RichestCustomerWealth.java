package com.ck.arrays.easy;

// LC - 1672 : Richest Customer Wealth
// https://leetcode.com/problems/richest-customer-wealth/
public class RichestCustomerWealth {

	public static void main(String[] args) {
		System.out.println(maximumWealth(new int[][] { { 1, 5 }, { 7, 3 }, { 3, 5 } }));
	}

	public static int maximumWealth(int[][] accounts) {
		int sum = 0, max = 0;
		for (int i = 0; i < accounts.length; i++) {
			sum = 0;
			for (int j = 0; j < accounts[i].length; j++) {
				sum += accounts[i][j];
			}
			max = Math.max(max, sum);
		}
		return max;
	}

}
