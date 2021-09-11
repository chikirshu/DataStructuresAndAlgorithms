package com.ck.arrays.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

// G2G - Winner of an election 
// https://practice.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1#
public class WinnerOfAnElection {

	public static void main(String[] args) {
		String[] s = new String[] { "john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie", "john",
				"johnny", "jamie", "johnny", "john" };
		System.out.println(Arrays.toString(winnerI(s, 13)));
		System.out.println(Arrays.toString(winnerII(Arrays.asList(s), 13)));
	}

	public static String[] winnerI(String arr[], int n) {
		// add your code
		int max = 0;
		String[] res = new String[2];
		Map<String, Integer> map = new HashMap<>();
		for (String s : arr) {
			map.put(s, map.getOrDefault(s, 0) + 1);
			if (map.get(s) > max) {
				max = map.get(s);
				res[0] = s;
				res[1] = String.valueOf(max);
			} else if (map.get(s) == max && s.compareTo(res[0]) < 0) { // you can also define treemap and skip this compareto condition
				res[0] = s;
				res[1] = String.valueOf(max);
			}
		}
		return res;
	}

	// using java 8 streams
	public static String[] winnerII(List<String> list, int n) {
		String res[] = new String[2];
		Optional<Entry<String, Long>> max = list.stream()
				.collect(Collectors.groupingBy(s -> s, Collectors.counting()))
				.entrySet()
				.stream()
				.sorted((s1, s2) -> s1.getKey().compareTo(s2.getKey()))
				.max(Comparator.comparing(Entry::getValue));
		if(max.isPresent()) {
			res[0]=max.get().getKey();
			res[1]=String.valueOf(max.get().getValue());
		}
		return res;
	}

}
