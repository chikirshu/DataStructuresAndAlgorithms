package com.ck.arrays.medium;

// LC - 1343 : Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/
public class SubArraysAvgGreaterThanThreshold {

	public static void main(String[] args) {
		System.out.println(numOfSubarrays(new int[] { 2, 2, 2, 2, 5, 5, 5, 8 }, 3, 4));
	}

	public static int numOfSubarrays(int[] arr, int k, int threshold) {
		int sum = 0, start = 0, res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i - start > k - 1) {
				if (sum / k >= threshold)
					res++;
				sum = sum - arr[start++];
			}
			sum += arr[i];
		}
		return sum / k >= threshold ? res + 1 : res;
	}

}
