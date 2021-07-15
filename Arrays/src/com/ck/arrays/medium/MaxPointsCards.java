package com.ck.arrays.medium;

// LC - 1423 : Maximum Points You Can Obtain from Cards
// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
public class MaxPointsCards {

	public static void main(String[] args) {
		System.out.println(maxScore(new int[] { 2, 2, 2 }, 2));
		//there is another o(k) approach to solve this, check that
	}

	public static int maxScore(int[] cardPoints, int k) {
		// minimized the sum for target, where target is cardPoints.length-k elements
		int min = Integer.MAX_VALUE, start = 0, end = cardPoints.length - k, sum = 0, sumFinal = 0;

		for (int i = 0; i < cardPoints.length; i++) {
			sumFinal += cardPoints[i];
		}
		if (end == 0)
			return sumFinal;
		for (int i = 0; i <= k; i++) {
			for (int j = start; j < end; j++) {
				sum += cardPoints[j];
			}
			min = (int) Math.min(min, sum);
			start++;
			end++;
			sum = 0;
		}

		return sumFinal - min;
	}

}
