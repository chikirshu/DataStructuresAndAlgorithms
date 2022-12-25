package com.ck.strings.medium;

import java.util.HashMap;
import java.util.Map;

// LC - 3 : Longest Substring without repeating characters
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		//String s = "abcabcbb";
		String s="abbac";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {

		if (s.length() == 0)
			return 0;

		Map<Character, Integer> map = new HashMap<>();
		int start = 0, max = 0;
		for (int end = 0; end < s.length(); end++) {
			if (map.containsKey(s.charAt(end))) {
				// start++; pwwkew will fail
				// start=map.get(s.charAt(end))+1; abba will fail
				start = Math.max(start, map.get(s.charAt(end)) + 1);
			}
			map.put(s.charAt(end), end);
			max = Math.max(max, end - start + 1);
		}

		return max;
	}

}
