package com.ck.arrays.easy;

import java.util.ArrayList;
import java.util.List;

// LC - 1431 : Kids With the Greatest Number of Candies
// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class KidsWithGreatestCandies {

	public static void main(String[] args) {
		System.out.println(kidsWithCandies(new int[] { 4, 2, 1, 2 }, 1));
	}

	public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int max = 0;
		List<Boolean> res = new ArrayList<>();
		for (int i = 0; i < candies.length; i++) {
			max = Math.max(max, candies[i]);
		}
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] + extraCandies >= max)
				res.add(true);
			else
				res.add(false);
		}
		return res;
	}

}
