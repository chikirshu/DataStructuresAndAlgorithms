package com.ck.strings.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// https://leetcode.com/discuss/interview-question/545748/amazon-subsidiary-phone-concatenated-words
public class CopoundedWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<>();
		list.add("rockstar");
		list.add("rock");
		list.add("ocks");
		list.add("star");
		list.add("rocks");
		list.add("tar");
		list.add("star");
		list.add("rockstars");
		list.add("super");
		list.add("highway");
		list.add("high");
		list.add("way");
		list.add("superhighway");
		System.out.println(findCombine(list));

	}
	
	public static List<List<String>> findCombine(List<String> list) {
	    List<List<String>> result = new ArrayList<>();
	    Set<String> set = new HashSet<>(list);
	    for (String word : list) {
	        set.remove(word);
	        List<String> tempList = wordBreak(word, set);
	        if (tempList != null && tempList.size() != 0) {
	            for (String temp : tempList) {
	                result.add(Arrays.stream(temp.split(" ")).collect(Collectors.toList()));
	            }
	        }
	        set.add(word);
	    }
	    return result;
	}

	public static List<String> wordBreak(String s, Set<String> wordDict) {
	    List<String> ans = new ArrayList<>();
	    dfs(s, 0, new HashSet<>(wordDict), ans, "");
	    return ans;
	}

	private static void dfs(String s, int start, Set<String> wordSet, List<String> ans, String tmp) {
	    if (start == s.length()) {
	        ans.add(tmp.trim());
	        return;
	    }
	    for (int i = start; i < s.length(); i++) {
	        if (wordSet.contains(s.substring(start, i + 1))) {
	            dfs(s, i + 1, wordSet, ans, tmp + " " + s.substring(start, i + 1));
	        }
	    }
	}

}
