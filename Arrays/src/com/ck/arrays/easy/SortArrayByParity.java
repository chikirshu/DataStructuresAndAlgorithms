package com.ck.arrays.easy;

import java.util.Arrays;

// should actually be a part of searching and sorting series
// LC - 905 : Sort Array By Parity
// https://leetcode.com/problems/sort-array-by-parity/
public class SortArrayByParity {

	public static void main(String[] args) {
		int[] arr = new int[] {3,1,2,4};
		System.out.println(Arrays.toString(sortArrayByParity(arr)));
		System.out.println(Arrays.toString(sortArrayByParityII(arr)));
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
	
	//dated - 14/06/2022
	//same approach but different way to do it
	public static int[] sortArrayByParityII(int[] nums) {
		int l=0,h=nums.length-1,temp=0;
		while(l<=h) {
			if(nums[l]%2==0)l++;
			else {
				if(nums[h]%2!=0)h--;
				else {
					temp=nums[l];
					nums[l]=nums[h];
					nums[h]=temp;
					l++;
					h--;
				}
			}	
		}
		return nums;
	}
}
