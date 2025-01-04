package com.ck.strings.easy;

import java.util.Arrays;

// LC - 344 : Reverse String
// https://leetcode.com/problems/reverse-string/
public class ReverseString {

	public static void main(String[] args) {
		char[] s = new char[] { 'H', 'a', 't', 'n', 'a', 'h' };
		reverseString(s);
		System.out.println(Arrays.toString(s));
	}

	// Can also use two pointer approach start and end; do start++ and end--.
	// Two pointer approach is better because if asked to reverse a part of string then below approach will not give correct solution
	public static void reverseString(char[] s) {

		for (int i = 0; i < s.length / 2; i++) {
			char temp = s[i];
			s[i] = s[s.length - 1 - i];
			s[s.length - 1 - i] = temp;
		}
	}

}
