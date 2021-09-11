package com.ck.arrays.easy;

import java.util.Arrays;

// LC - 561 : Array Partition I
// https://leetcode.com/problems/array-partition-i/
public class ArrayPartitionI {

	public static void main(String[] args) {
		System.out.println(arrayPairSum(new int[] { 6, 2, 6, 5, 1, 2 }));
	}

	public static int arrayPairSum(int[] nums) {
		int res = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i = i + 2) {
			res += nums[i];
		}
		return res;
	}

}
