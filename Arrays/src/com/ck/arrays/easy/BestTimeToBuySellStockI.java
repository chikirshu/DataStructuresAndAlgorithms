package com.ck.arrays.easy;

// LC - 121: Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuySellStockI {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 4, 15, 1, 8, 0 }));
	}

	public static int maxProfit(int[] prices) {
		int minSoFar = Integer.MAX_VALUE, maxProfitSoFar = Integer.MIN_VALUE;

		for (int i = 0; i < prices.length; i++) {
			minSoFar = Math.min(minSoFar, prices[i]);
			maxProfitSoFar = Math.max(maxProfitSoFar, prices[i] - minSoFar);
		}

		return maxProfitSoFar;
	}

}
