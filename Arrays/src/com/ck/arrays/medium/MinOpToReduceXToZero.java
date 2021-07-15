package com.ck.arrays.medium;

import java.util.HashMap;
import java.util.Map;

// LC - 1658 : Minimum Operations to Reduce X to Zero
public class MinOpToReduceXToZero {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 4, 2, 3 };
		System.out.println(minOperations(arr, 5));
	}

	public static int minOperations(int[] nums, int x) {
		int target = -x, res = -1, sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i : nums)
			target += i;

		if (target == 0)
			return nums.length;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - target)) {
				res = Math.max(res, i - map.get(sum - target));
			}
			map.put(sum, i);
		}
		return res == -1 ? res : nums.length - res;
	}

}
