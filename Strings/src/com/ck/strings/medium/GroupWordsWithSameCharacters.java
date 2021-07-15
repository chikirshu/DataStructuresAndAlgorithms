package com.ck.strings.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// GFG - Group words with same set of characters
public class GroupWordsWithSameCharacters {

	public static void main(String[] args) {
		String[] words = { "may", "student", "students", "dog", "studentssess", "god", "cat", "act", "tab", "bat",
				"flow", "wolf", "lambs", "amy", "yam", "balms", "looped", "poodle" };
		Map<String, List<Integer>> map = new HashMap<>();
		map = groupWords(words);
		for (Map.Entry<String, List<Integer>> m : map.entrySet()) {
			List<Integer> list = m.getValue();
			for (Integer i : list) {
				System.out.print(words[i] + " ");
			}
			System.out.println();
		}
	}
	
	private static Map<String, List<Integer>>groupWords(String[] words) {
		
		Map<String, List<Integer>> map = new HashMap<>();
		for(int i=0;i<words.length;i++) {
			String key = getKey(words[i]);
			if(map.containsKey(key)) {
				map.get(key).add(i);
			}
			else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(key, list);
			}
		}
		return map;
	}
	
	private static String getKey(String s) {
		// check how can you sort the string
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return Arrays.toString(c);
	}

}
