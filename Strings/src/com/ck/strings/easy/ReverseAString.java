package com.ck.strings.easy;

// GFG - Reverse a String
// https://practice.geeksforgeeks.org/problems/reverse-a-string/1
public class ReverseAString {

	public static void main(String[] args) {
		System.out.println(reverseWord("Geeks"));
	}

	// Can also use two pointer approach start and end; do start++ and end--.
	// Two pointer approach is better because if asked to reverse a part of string then below approach will not give correct solution
	public static String reverseWord(String str) {
		// Reverse the string str
		int n = str.length();
		for (int i = 0; i < n / 2; i++) {
			char temp = str.charAt(i);
			str = str.substring(0, i) + String.valueOf(str.charAt(n - 1 - i)) + str.substring(i + 1, n - 1 - i)
					+ String.valueOf(temp) + str.substring(n - i);
		}
		return str;
	}

}
