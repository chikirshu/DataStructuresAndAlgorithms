package com.ck.arrays.easy;

import java.util.Arrays;

// LC - 922 : Sort Array By Parity II
// https://leetcode.com/problems/sort-array-by-parity-ii/
public class SortArrayByParityII {

	public static void main(String[] args) {
		int[] arr = new int[] {3,1,2,4};
		System.out.println(Arrays.toString(sortArrayByParityII(arr)));
	}

	public static int[] sortArrayByParityII(int[] nums) {

		int j = 1;
		// traverse only even positions
		for (int i = 0; i < nums.length; i += 2)
			// if odd no. on even position
			if (nums[i] % 2 == 1) {
				// find the nearest even no. on odd position - while you keep getting odd no. on odd position
				while (nums[j] % 2 == 1)
					j += 2;

				// Swap nums[i] and nums[j]
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}

		return nums;

	}

}
