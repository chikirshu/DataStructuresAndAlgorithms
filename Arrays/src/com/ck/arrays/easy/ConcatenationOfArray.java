package com.ck.arrays.easy;

import java.util.Arrays;

// LC - 1929 : Concatenation of Array
// https://leetcode.com/problems/concatenation-of-array/
public class ConcatenationOfArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getConcatenation(new int[] { 1, 2, 1 })));
	}

	public static int[] getConcatenation(int[] nums) {
		int n = nums.length;
		int[] res = new int[2 * n];
		for (int i = 0; i < n; i++) {
			res[i] = nums[i];
			res[i + n] = nums[i];
		}
		return res;
	}

}
