package com.ck.strings.easy;

// GFG - Number to words
// https://practice.geeksforgeeks.org/problems/number-to-words0335/1#
public class NumberToWords {

	static String[] ones = new String[] { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	static String[] tens = new String[] { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
			"Ninety" };

	public static void main(String[] args) {
		System.out.println(convertToWords(17));
	}

	static String convertToWords(long n) {
		// code here
		String res = "";
		res += numToWords((n / 10000000), "crore") + " ";
		res = res.trim()+" "+ numToWords((n / 100000) % 100, "lakh") + " ";
		res = res.trim()+" "+  numToWords((n / 1000) % 100, "thousand") + " ";
		res = res.trim()+" "+  numToWords((n / 100) % 10, "hundred") + " ";

		if (n > 100 && n % 100 > 0)
			res = res.trim() + " and " + numToWords((n % 100), "");
		else
			res = res.trim()+" "+ numToWords((n % 100), "");

		return res.trim().toLowerCase();

	}

	private static String numToWords(long n, String s) {
		String str = "";
		if (n > 19)
			str += tens[(int) n / 10] + " " + ones[(int) n % 10];
		else
			str += ones[(int) n];

		if (n > 0)
			str = str.trim() + " " + s;

		return str;
	}

}
