package com.ck.arrays.medium;

public class ReverseWordsInString {

	public static void main(String[] args) {
		System.out.println(reverseWords("  Bob    Loves  Alice   "));
	}

	public static String reverseWords(String s) {

		String[] s1 = s.trim().split(" ");
		String temp = "", res = "";
		int n = s1.length;
		for (int i = 0; i < s1.length / 2; i++) {
			temp = s1[i];
			s1[i] = s1[n - 1 - i];
			s1[n - 1 - i] = temp;
		}
		for (String s2 : s1) {
			if (s2.equals("")) {
				continue;
			}
			res += s2 + " ";
		}
		return res.trim();
	}

}
