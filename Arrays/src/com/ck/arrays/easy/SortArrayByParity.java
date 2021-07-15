package com.ck.arrays.easy;

import java.util.Arrays;

// LC - 905 : Sort Array By Parity
public class SortArrayByParity {

	public static void main(String[] args) {
		int[] arr = new int[] {3,1,2,4};
		System.out.println(Arrays.toString(sortArrayByParity(arr)));
	}

	public static int[] sortArrayByParity(int[] nums) {

		int[] result = new int[nums.length];
		int kFront = 0, kRev = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				result[kFront] = nums[i];
				kFront++;
			} else {
				result[nums.length - kRev - 1] = nums[i];
				kRev++;
			}
		}

		return result;
	}

}
