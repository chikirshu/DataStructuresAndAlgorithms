package com.ck.arrays.medium;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(mergeSortAlgo(new int[] { 7, 4, 1, 3, 6, 8, 2, 5 }, 0, 7)));
	}

	public static int[] mergeSortAlgo(int[] arr, int l, int h) {
		if (l == h) {
			return new int[] { arr[l] };
		}
		int mid = (l + h) / 2;
		int[] firstSortedHalf = mergeSortAlgo(arr, l, mid);
		int[] secondSortedHalf = mergeSortAlgo(arr, mid + 1, h);
		return MergeTwoSortedArrays.mergeTwoSortedCollection(firstSortedHalf, secondSortedHalf);
	}

}
