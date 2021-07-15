package com.ck.strings.medium;

import java.util.ArrayList;
import java.util.List;

// LC - 46 : Permutations
public class AllPermutationsOfArray {

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 2, 3 }));
	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		getPermutations(nums, new ArrayList<>(), res);
		return res;
	}

	private static void getPermutations(int[] nums, List<Integer> tempList, List<List<Integer>> finalList) {

		if (tempList.size() == nums.length) {
			finalList.add(new ArrayList<>(tempList));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (tempList.contains(nums[i]))
				continue;
			tempList.add(nums[i]);
			getPermutations(nums, tempList, finalList);
			tempList.remove(tempList.size() - 1);
		}
	}

}
