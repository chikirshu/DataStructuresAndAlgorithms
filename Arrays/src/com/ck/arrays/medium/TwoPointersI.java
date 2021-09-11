package com.ck.arrays.medium;

import java.util.HashMap;
import java.util.Map;

// Mobikwik
public class TwoPointersI {

	public static void main(String[] args) {
		findUnique(new int[] { 1, 2, 3, 2, 2, 1, 4, 2, 1, 3, 5, 1, 6 }, 3);
	}

	public static void findUnique(int[] arr, int k) {
		int start = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			if (i - start == k - 1) {
				System.out.print(map.size() + " ");
				if (map.get(arr[start]) >= 1) {
					map.put(arr[start], map.get(arr[start]) - 1);
				}
				if (map.get(arr[start]) == 0) {
					map.remove(arr[start]);
				}
				start++;
			}
		}
	}

}
