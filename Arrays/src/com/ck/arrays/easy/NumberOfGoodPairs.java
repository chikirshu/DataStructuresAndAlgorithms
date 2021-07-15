package com.ck.arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {

	public static void main(String[] args) {
		System.out.println(numIdenticalPairsI(new int[] { 1, 2, 3, 1, 1, 3 }));
		System.out.println(numIdenticalPairsII(new int[] { 1, 2, 3, 1, 1, 3 }));
	}

	// smaller and easier code
	public static int numIdenticalPairsII(int[] A) {
		int res = 0, count[] = new int[101];
		for (int a : A) {
			res += count[a]++;
		}
		return res;
	}

	// Dynamic Programming, DP, O(1.5*N) I guess?
	public static int numIdenticalPairsI(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int[] dp = new int[nums.length + 1];
		dp[0] = 0;
		dp[1] = 0;
		int cnt = 0;

		for (int i = 0; i < nums.length; i++) {
			cnt++;
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			cnt++;
			sum += getGoodPairs(entry.getValue(), dp, cnt);
		}
		System.out.println("II will run for around : " + cnt + " times");
		return sum;
	}

	public static int getGoodPairs(int val, int[] dp, int cnt) {

		if (val == 0 || val == 1)
			return 0;
		if (dp[val] != 0)
			return dp[val];

		int ans = val - 1 + getGoodPairs(val - 1, dp, cnt);
		cnt++;
		dp[val] = ans;
		return ans;
	}

}
