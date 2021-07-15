package com.ck.arrays.easy;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) throws IOException {
		int[] result = twoSum(new int[] { 3,4,5,3 }, 6);
		System.out.println("Output is: " + result[0] + ", " + result[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			}
			map.put(nums[i], i);
		}

		return new int[] { 0, 0 };
	}

}
