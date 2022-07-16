package com.ck.arrays.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// LC - 349 : Intersection of Two Arrays
// https://leetcode.com/problems/intersection-of-two-arrays/
// Facebook - consider cases like O(1) space given arrays can be sorted, handle duplicates etc
public class IntersectionOfArrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(intersectionI(new int[] { 4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
		System.out.println(Arrays.toString(intersectionII(new int[] { 4,44,4,4,4,4, 9, 5 }, new int[] { 9, 4, 9, 8, 4 })));
		// refer the thread for more better solutions
		// https://leetcode.com/problems/intersection-of-two-arrays/discuss/81969/Three-Java-Solutions
	}

	public static int[] intersectionI(int[] nums1, int[] nums2) {

		Set<Integer> set = new HashSet<>();
		Set<Integer> intersect = new HashSet<>();
		for (int i = 0; i < nums1.length; i++) {
			set.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (set.contains(nums2[i]))
				intersect.add(nums2[i]);
		}
		int[] res = new int[intersect.size()];
		int k = 0;
		for (Integer i : intersect) {
			res[k] = i;
			k++;
		}
		return res;
	}

	public static int[] intersectionII(int[] nums1, int[] nums2) {

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		String s = "";
		System.out.println("Length of s is : " + s.length());

		int i = 0, j = 0, len1 = nums1.length, len2 = nums2.length, k = 0;
		while (i < len1 && j < len2) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				 if(s.equals("") || (s.length()>=1 && !String.valueOf(nums1[i]).equals(s.substring(s.length()-1))))
					s += String.valueOf(nums1[i]);
				i++;
				j++;
			}
		}
		int[] res = new int[s.length()];
		for (int m = 0; m < s.length(); m++) {
			res[k] = Integer.parseInt(String.valueOf(s.charAt(m)));
			k++;
		}
		return res;
	}

}
