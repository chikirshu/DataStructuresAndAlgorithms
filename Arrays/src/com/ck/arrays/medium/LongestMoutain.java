package com.ck.arrays.medium;

// 845 : Longest Mountain in an Array
public class LongestMoutain {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 1, 4, 7, 3, 2, 5 };
		System.out.println(longestMountain(arr));
	}

	public static int longestMountain(int[] arr) {
		int max = 0, len = 0;
		for (int i = 0; i < arr.length; i++) {
			len = findMountainLength(arr, i);
			// System.out.println("i=" + i + " len=" + len);
			if (max < len) {
				max = len;
			}
		}
		return max;
	}

	public static int findMountainLength(int[] arr, int i) {

		int N = arr.length;
		int len = 0, oldI = i, oldLen=0;

		while (i < N - 1 && arr[i] < arr[i + 1]) {
			len++;
			i++;
		}
        oldLen = len;
		if (len == 0 || len == N - 1 - oldI) {
			return 0;
		}
		while (i < N - 1 && arr[i] > arr[i + 1]) {
			len++;
			i++;
		}
        if(oldLen == len){
            return 0;
        }
		return len+1;
	}

}
