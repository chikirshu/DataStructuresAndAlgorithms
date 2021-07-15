package com.ck.strings.easy;

// LC - 1880 : Check if word equals summation of two words
public class SumofWords {

	public static void main(String[] args) {
		System.out.println(isSumEqual("acb", "cba", "cdb"));
	}

	public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

		String firstNum = "", secondNum = "", targetNum = "";
		int x = 0;

		for (int i = 0; i < firstWord.length(); i++) {
			x = firstWord.charAt(i) - 'a';
			firstNum += String.valueOf(x);
		}
		for (int i = 0; i < secondWord.length(); i++) {
			x = secondWord.charAt(i) - 'a';
			secondNum += String.valueOf(x);
		}
		for (int i = 0; i < targetWord.length(); i++) {
			x = targetWord.charAt(i) - 'a';
			targetNum += String.valueOf(x);
		}

		return (Integer.parseInt(firstNum) + Integer.parseInt(secondNum) == Integer.parseInt(targetNum));
	}
}
