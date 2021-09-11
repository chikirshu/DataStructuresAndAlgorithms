package com.ck.arrays.easy;

import java.util.Arrays;

// LC - 1460 : Make Two Arrays Equal by Reversing Sub-arrays
// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
public class MakeTwoArraysEqual {

	public static void main(String[] args) {
		System.out.println(canBeEqual(new int[] { 1, 2, 3, 4 }, new int[] { 2, 4, 1, 3 }));
	}

	public static boolean canBeEqual(int[] target, int[] arr) {
		Arrays.sort(target);
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != target[i])
				return false;
		}
		return true;
	}

}
