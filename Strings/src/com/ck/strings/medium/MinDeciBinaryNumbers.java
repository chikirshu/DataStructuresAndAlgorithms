package com.ck.strings.medium;

// LC - 1689 : Partitioning Into Minimum Number Of Deci-Binary Numbers
// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
public class MinDeciBinaryNumbers {

	public static void main(String[] args) {
		System.out.println(minPartitions("27346209830709182346"));
		System.out.println(minPartitions("32"));
	}

	public static int minPartitions(String n) {
		int max = 0;
		for (int i = 0; i < n.length(); i++) {
			if (n.charAt(i) == '9')
				return 9;
			max = Math.max(max, Integer.parseInt(String.valueOf(n.charAt(i))));
		}
		return max;
	}

}
