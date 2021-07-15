package com.ck.strings.hard;

import java.util.ArrayList;
import java.util.List;

// LC - 76 :  Minimum Window Substring - Open
public class MinimumWindowSubstring {

	public static void main(String[] args) {
		String s = "ADOBECODEBANC";
		String t = "ABC";
		System.out.println(minWindowWrongApproach(s, t));
	}

	public static String minWindow(String s, String t) {

		String res = "", resFinal = "";
		return resFinal;
	}

	// This approach will fail because of the use of list instead of map for storing
	// characters of String T. And removing them later from the list.
	// s = "bba" and t = "ba" will fail
	public static String minWindowWrongApproach(String s, String t) {

		if (s.equals(t))
			return t;

		int minWindowLen = 1000001, start = 0, end = 0, nextCheck = 0;
		String res = "", resFinal = "";

		List<Character> list = new ArrayList<>();
		List<Character> tempList;

		for (char c : t.toCharArray()) {
			list.add(c);
		}

		tempList = new ArrayList<>(list);

		for (int i = 0; i < s.length(); i++) {
			if (list.contains(s.charAt(i))) {

				if (start == nextCheck && list.size() == t.length())
					start++;
				else if (list.size() == t.length() - 1)
					nextCheck = i;

				list.remove(new Character(s.charAt(i)));
				if (list.size() == 0 && i <= s.length() - 1) {
					if (minWindowLen > end - start + 2) {
						minWindowLen = end - start + 2;
						resFinal = res + s.charAt(i);
					}
					if (nextCheck != 0) {
						res = "";
						start = nextCheck;
						end = nextCheck;
						i = nextCheck - 1;
						list = new ArrayList<>(tempList);
					} else {
						break;
					}
				}
			}
			if (start != nextCheck || (start == nextCheck && list.size() < t.length())) {
				end++;
				res += s.charAt(i);
			}
		}

		return resFinal;

	}

}
