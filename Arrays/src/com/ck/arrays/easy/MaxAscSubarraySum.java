package com.ck.arrays.easy;

// LC - 1800 : Maximum Ascending Subarray Sum
// https://leetcode.com/problems/maximum-ascending-subarray-sum/
public class MaxAscSubarraySum {

	public static void main(String[] args) {
		System.out.println(maxAscendingSum(new int[] { 10, 20, 30, 5, 10, 50 }));
	}

	public static int maxAscendingSum(int[] nums) {
		int sum = nums[0], max = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1])
				sum += nums[i];
			else {
				max = (int) Math.max(max, sum);
				sum = nums[i];
			}
		}
		return (int) Math.max(max, sum);
	}

}
