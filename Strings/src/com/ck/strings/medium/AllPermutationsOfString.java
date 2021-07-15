package com.ck.strings.medium;

//
public class AllPermutationsOfString {

	public static void main(String[] args) {
		getPermutations("abc", "");
	}

	private static void getPermutations(String currStr, String currAns) {
		if (currStr.length() == 0) {
			System.out.println(currAns);
		}
		for (int i = 0; i < currStr.length(); i++) {
			String rightPart = currStr.substring(0, i);
			String leftPart = currStr.substring(i + 1);
			getPermutations(rightPart + leftPart, currAns + String.valueOf(currStr.charAt(i)));
		}
	}

}
