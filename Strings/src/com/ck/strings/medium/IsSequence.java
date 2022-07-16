package com.ck.strings.medium;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

// LC - 392 : Is Subsequence
// https://leetcode.com/problems/is-subsequence/
public class IsSequence {

	public static void main(String[] args) {
		System.out.println(isSubsequenceI("abc", "ahbgdc"));
		System.out.println(isSubsequenceII("abc", "ahbgdc"));
	}

	// on leetcode it will give TLE
	public static boolean isSubsequenceI(String s, String t) {

		if (s.length() == 0)
			return true;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < t.length(); i++) {
			set.add(t.charAt(i));
		}
		for (int i = 0; i < s.length(); i++) {
			if (!set.contains(s.charAt(i)))
				return false;
		}
		int totalCombinations = (int) Math.pow(2, t.length());
		for (int i = 0; i < totalCombinations; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < t.length(); j++) {
				if (BigInteger.valueOf(i).testBit(j)) {
					sb.append(t.charAt(j));
					if (sb.toString().equals(s))
						return true;
				}
			}
		}
		return false;

	}

	public static boolean isSubsequenceII(String s, String t) {
		if (s.length() == 0)
			return true;
		int indexS = 0, indexT = 0;
		while (indexT < t.length()) {
			if (t.charAt(indexT) == s.charAt(indexS)) {
				indexS++;
				if (indexS == s.length())
					return true;
			}
			indexT++;
		}
		return false;
	}

}
