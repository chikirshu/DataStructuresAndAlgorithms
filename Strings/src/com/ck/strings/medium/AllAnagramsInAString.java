package com.ck.strings.medium;

import java.util.ArrayList;
import java.util.List;

// LC - 438 : Find all Anagrams in a String
public class AllAnagramsInAString {

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
	}

	public static List<Integer> findAnagrams(String s, String p) {

		int[] charArr = new int[26];
		int len1 = s.length(), len2 = p.length();
		List<Integer> res = new ArrayList<>();

		for (int i = 0; i < len2; i++) {
			charArr[p.charAt(i) - 'a']++;
		}
		for (int i = 0; i < len1; i++) {
			charArr[s.charAt(i) - 'a']--;
			if (i - len2 >= 0)
				charArr[s.charAt(i - len2) - 'a']++;
			if (allZeros(charArr)) {
				res.add(i - len2 + 1);
			}
		}
		return res;
	}

	public static boolean allZeros(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0)
				return false;
		}
		return true;
	}

}
