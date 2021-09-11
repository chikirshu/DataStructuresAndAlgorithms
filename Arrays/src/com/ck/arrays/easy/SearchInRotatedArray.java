package com.ck.arrays.easy;

// GFG - Search in Rotated Array
// https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1#
public class SearchInRotatedArray {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 5, 6, 7, 8, 9, 10, 1, 2, 3 }, 0, 8, 10));
	}

	static int search(int A[], int l, int h, int key) {
		// Complete this function
		int pivot = -1, res = 0;

		pivot = findPivot(A, l, h);
		res = binarySearch(A, 0, pivot - 1, key);
		if (res == -1) {
			res = binarySearch(A, pivot, A.length - 1, key);
		}
		return res;
	}

	private static int findPivot(int[] arr, int low, int high) {
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < arr[high]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		// at this point low and high will be same
		return low;
	}

	private static int binarySearch(int[] arr, int low, int high, int key) {
		int mid = 0;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (key == arr[mid])
				return mid;
			else if (key > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

}
