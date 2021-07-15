package com.ck.strings.easy;

import java.util.ArrayList;
import java.util.List;

// GFG - Given a string, find its first non-repeating character
public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		String str = "geeksforgeeksandgeeksquizfor";
		int res = findFirstNonRepeatingCharI(str);
		if (res == -1)
			System.out.println("No result found");
		else
			System.out.println(str.charAt(res));
		findFirstNonRepeatingCharII(str);
	}

	private static int findFirstNonRepeatingCharI(String str) {
		char[] repeated = new char[256];
		int res = -1;

		for (int i = 0; i < str.length(); i++) {
			repeated[str.charAt(i)]++;
		}
		for (int i = 0; i < str.length(); i++) {
			if (repeated[str.charAt(i)] == 1) {
				return i;
			}
		}
		return res;
	}

	private static void findFirstNonRepeatingCharII(String str) {
		boolean[] repeated = new boolean[256];
		List<Character> listofNonRepeated = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (!repeated[c]) {
				if (!listofNonRepeated.contains(c)) {
					listofNonRepeated.add(c);
				} else {
					listofNonRepeated.remove((Character) c);
					repeated[c] = true;
				}
			}
		}
		System.out.println(listofNonRepeated.size() != 0 ? listofNonRepeated.get(0) : "No result found");
	}

}
