package com.ck.arrays.easy;

import java.util.Arrays;

// 977 : Squares of a Sorted Array
// https://leetcode.com/problems/squares-of-a-sorted-array/
public class SortedSquares {

	public static void main(String[] args) {
		
		int[] arr = new int[] {-4,-1,0,3,10};
		System.out.println(Arrays.toString(sortedSquares(arr)));
	}

	public static int[] sortedSquares(int[] nums) {

		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = nums[i] * nums[i];
		}

		Arrays.sort(result);

		return result;

	}

}
