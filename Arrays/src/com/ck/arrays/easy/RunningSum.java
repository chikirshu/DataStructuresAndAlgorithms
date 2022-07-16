package com.ck.arrays.easy;

import java.util.Arrays;

// last update - 12/06/2022 - Nice catch there
// LC - 1480 : Running Sum of 1d Array
// https://leetcode.com/problems/running-sum-of-1d-array/
public class RunningSum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(runningSum(new int[] { 3, 1, 2, 10, 1 })));
	}

	public static int[] runningSum(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
		return nums;
	}

}
