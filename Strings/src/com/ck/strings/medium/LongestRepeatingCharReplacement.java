package com.ck.strings.medium;

// LC - 424 : Longest Repeating Character Replacement
// https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharReplacement {

	public static void main(String[] args) {
		// System.out.println(characterReplacementI("ABBB",1));//wrong
		System.out.println(characterReplacementII("AABABBA", 1));// right
		System.out.println(characterReplacementIII("AABABBA", 1)); // also right but takes lot of time
	}

	public static int characterReplacementII(String s, int k) {
		int start = 0, end = 0, maxCharCnt = 0, maxLen = 0;
		int[] charArr = new int[26];
		for (end = 0; end < s.length(); end++) {
			maxCharCnt = (int) Math.max(maxCharCnt, ++charArr[s.charAt(end) - 'A']);
			// length of the window - maxCharCnt > k -> meaning you will exhaust all your k,
			// therefore slide your window and decrement the entry.
			// entries in your char array should represent only the chars in your window
			if (end - start + 1 - maxCharCnt > k) {
				charArr[s.charAt(start) - 'A']--;
				start++;
			}
			maxLen = (int) Math.max(maxLen, end - start + 1);
		}
		return maxLen;
	}

	// This approach will fail for cases like [{"ABBB", 1}, {"ABCB", 2}]
	// as we are comparing next right element to the previous ones, but what if the
	// max count is achieved comparing left element with the next element. Though
	// this method will pass for [{"BBBA", 1}, {"BCBA", 2}]
	public static int characterReplacementI(String s, int k) {
		int tempK = k, start = 0, max = 0, i = 0;

		for (i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(start))
				k--;
			if (k < 0) {
				max = (int) Math.max(max, i - start);
				start++;
				int t = start + 1;
				k = tempK;
				while (t <= i) {
					if (s.charAt(t) != s.charAt(start)) {
						k--;
					}
					t++;
				}
			}
		}
		return k >= 0 ? (int) Math.max(max, i - start) : max;
	}

	// doing extra steps which is not needed it seems
	public static int characterReplacementIII(String s, int k) {
		int start = 0, end = 0, oMax = 1, maxRepeatChar = 0;
		int[] arr = new int[26];
		arr[s.charAt(start) - 'A']++;

		for (int i = 1; i < s.length(); i++) {
			arr[s.charAt(i) - 'A']++;
			maxRepeatChar = findMaxRepeatChar(arr); // According to approach 2nd there is no need to check for max in
													// whole array, just compare the current entry with max entry
			if (i - start + 1 - maxRepeatChar <= k) {

			} else {
				oMax = Math.max(oMax, end - start + 1);

				while (i - start + 1 - maxRepeatChar > k) {
					arr[s.charAt(start) - 'A']--;
					start++;
					maxRepeatChar = findMaxRepeatChar(arr);
				}
			}
			end = i;
		}
		return Math.max(oMax, end - start + 1);
	}

	public static int findMaxRepeatChar(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}
		return max;
	}

}
