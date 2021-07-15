package com.ck.strings.medium;

// LC - 567 : Permutation in String - Find if one of s1's permutation is in s2
public class PermutationInString {

	public static void main(String[] args) {
		//System.out.println(checkInclusionI("adc", "dcda"));
		System.out.println(checkInclusionII("adc", "dcda"));
	}

	// complex code I was trying which was failing because of poor implementation of moving start and end pointer
	public static boolean checkInclusionI(String s1, String s2) {

		if (s1.length() > s2.length())
			return false;

		int start = 0, end = 0;
		boolean res = false;
		int[] charArr = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			charArr[s1.charAt(i) - 'a']++;
		}

		end = s1.length() - 1;

		for (int i = 0; i < s2.length(); i++) {
			if (charArr[s2.charAt(i) - 'a'] > 0)
				charArr[s2.charAt(i) - 'a']--;
			else {
				if (s1.contains(String.valueOf(s2.charAt(start)))) {
					for (int k = 0; k < s1.length(); k++) {
						charArr[s1.charAt(k) - 'a']=0;
					}
					for (int k = 0; k < s1.length(); k++) {
						charArr[s1.charAt(k) - 'a']++;
					}
					start = Math.min(end+1, s2.length() - 1);
					end = Math.min(start+s1.length()-1, s2.length() - 1);
				}
				else {
					start = Math.min(start + 1, s2.length() - 1);
					end = Math.min(end + 1, s2.length() - 1);
				}
				
				res = false;
			}
			if (i == end) {
				for (int j = 0; j < s1.length(); j++) {
					if (charArr[j] != 0) {
						res = false;
						break;
					}
					if (j == s1.length() - 1 && charArr[j] == 0)
						res = true;
				}
			}
			if (res)
				break;
		}
		return res;
	}

	public static boolean checkInclusionII(String s1, String s2) {
		if(s1.length()>s2.length()) return false;

		int[] charArr = new int[26];
		for(int i=0;i<s1.length();i++) {
			charArr[s1.charAt(i)-'a']++;
		}
		for(int i=0;i<s2.length();i++) {
			charArr[s2.charAt(i)-'a']--;
			if(i-s1.length()>=0)charArr[s2.charAt(i-s1.length())-'a']++;
			if(allZeros(charArr)) return true;
		}
		return false;
	}
	
	private static boolean allZeros(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=0) return false;
		}
		return true;
	}
}
