package com.ck.strings.medium;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// Invasion of Iron Islands
// Yara Greyjoy, the ruler of Iron Islands after Balon Greyjoy has adopted marvellous strategies to protect the Islands from invaders. She has barricaded the Islands using great walls. Anyone who tries to invade the islands cannot enter. However, she has a mechanism that allows her and the people of the iron island to leave.
// They are given t strings of lower case alphabets. The gates only open if they give all the anagrams of each string in alphabetical order. For a wrong answer, the guards kill the person who is trying to open the gate.
// A spy in Iron Islands delivers this news to Stannis Baratheon, and now he is planning to attack the Iron Islands. He gives the t strings he receives from the spy to Sir Davos. However, Sir Davos needs your help as he is still learning how to read and write. Help him get all the anagrams of the strings given to him.
// Note: All characters in the string are unique.
// Constraints
// 1. 1<=t<=2000
// 2. 2<=len<=7, where len is the length of the string

// Sample Input
// 2
// abc
// dog
// Sample Output
// abc acb bac bca cab cba
// dgo dog gdo god odg ogd
public class SkillenzaEzeTapII {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int k = 0;
		String[] s = new String[t];
		for (int i = 0; i < t; i++) {
			s[k++] = sc.next();
		}
		for (int i = 0; i < t; i++) {
			Set<String> set = new TreeSet<>();
			// finadAllAnagramsI(s[i], "", set);
			finadAllAnagramsII(s[i], set);
			for (String str : set) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
		sc.close();
	}

	// TLE for len 7
	private static void finadAllAnagramsI(String residual, String crnt, Set<String> finalSet) {
		if (residual.length() == 0) {
			finalSet.add(crnt);
			return;
		}

		for (int i = 0; i < residual.length(); i++) {
			String front = residual.substring(0, i);
			String rear = residual.substring(i + 1);
			finadAllAnagramsI(front + rear, crnt + String.valueOf(residual.charAt(i)), finalSet);
		}
	}

	// help - youtube.com/watch?v=39SKIuA-ieY
	private static void finadAllAnagramsII(String s, Set<String> finalSet) {
		int n = s.length();
		int f = factorial(n);
		for (int i = 0; i < f; i++) {
			int temp = i;
			StringBuilder crnt = new StringBuilder();
			StringBuilder sb = new StringBuilder(s);
			for (int j = n; j >= 1; j--) {
				int q = temp / j;
				int r = temp % j;
				crnt.append(sb.charAt(r));
				sb.deleteCharAt(r);
				temp = q;
			}

			finalSet.add(crnt.toString());
		}
	}

	private static int factorial(int n) {
		if (n == 0 || n == 1)
			return n;
		int res = 1;
		for (int i = 2; i <= n; i++) {
			res *= i;
		}
		return res;
	}

}
