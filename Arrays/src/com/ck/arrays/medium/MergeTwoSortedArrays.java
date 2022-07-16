package com.ck.arrays.medium;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {

		int[] numberSetA = { 10, 15, 20, 40, 100 }; // 1st is ascending sorted
		// int[] numberSetD = { 100, 80, 40, 30, 10, 5, 2, 1 }; // 2nd is descending
		// sorted
		int[] numberSetD = { 1, 2, 5, 10, 30, 40, 80, 100 };

		int[] mergedNumbers = mergeTwoSortedCollection(numberSetA, numberSetD);
		System.out.println(Arrays.toString(mergedNumbers));
		// mergeTwoSortedCollectionII(numberSetA, numberSetD, numberSetA.length,
		// numberSetD.length);
		mergeTwoSortedCollectionIV(numberSetA, numberSetD, numberSetA.length, numberSetD.length);
		for (int i = 0; i < numberSetA.length; i++) {
			System.out.print(numberSetA[i] + " ");
		}
		for (int i = 0; i < numberSetD.length; i++) {
			System.out.print(numberSetD[i] + " ");
		}

	}

	public static void mergeTwoSortedCollectionIV(int arrA[], int arrB[], int n, int m) {
		// code here
		int gap = (int) Math.ceil((n + m) / 2.0);
		int slow = 0, fast = gap, temp = 0;
		while (gap >= 1) {
			if (n < fast) {
				fast = fast - n;
			}
			while (fast < m) {

				if (slow < n) {
					temp = arrA[slow];
					arrA[slow] = arrB[fast];
					arrB[fast] = temp;
				} else {
					slow = slow - n;
					temp = arrB[slow];
					arrB[slow] = arrB[fast];
					arrB[fast] = temp;
				}
				slow++;
				fast++;
			}
			gap = (int) Math.ceil(gap / 2.0);
			slow = 0;
			fast = gap;
		}
	}

	// was giving TLE in GFG - O(1) space and O(n*m) time complexity
	public static void mergeTwoSortedCollectionIII(int arrA[], int arrB[], int n, int m) {
		// code here
		int last = 0, i = 0, j = 0;
		for (i = m - 1; i >= 0; i--) {
			last = arrA[n - 1];
			for (j = n - 2; j >= 0 && arrA[j] > arrB[i]; j--) {
				arrA[j + 1] = arrA[j];
			}
			if (j != n - 2 || last > arrB[i]) {
				arrA[j + 1] = arrB[i];
				arrB[i] = last;
			}
		}
	}

	// was giving TLE in GFG - O(1) space and O(n*mlogm)
	public static void mergeTwoSortedCollectionII(int arrA[], int arrB[], int n, int m) {
		// code here
		for (int i = 0; i < n; i++) {
			if (arrA[i] > arrB[0]) {
				int t = arrA[i];
				arrA[i] = arrB[0];
				arrB[0] = t;
			}
			Arrays.sort(arrB);
		}
	}

	// O(max(n,m) time complexity; O(m+n) space
	public static int[] mergeTwoSortedCollection(int[] arrA, int[] arrB) {
		int n = arrA.length;
		int m = arrB.length;
		int startA = 0, startB = 0;
		int[] res = new int[m + n];
		int k = 0;
		while (startA < n && startB < m) {
			if (arrA[startA] < arrB[startB]) {
				res[k++] = arrA[startA];
				startA++;
			} else if (arrA[startA] > arrB[startB]) {
				res[k++] = arrB[startB];
				startB++;
			} else {
				res[k++] = arrA[startA];
				startA++;
				startB++;
			}
		}
		if (startA == n) {
			while (startB < m) {
				res[k++] = arrB[startB++];
			}
		} else {
			while (startA < n) {
				res[k++] = arrA[startA++];
			}
		}
		return res;
	}

}
