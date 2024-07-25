package com.ck.strings.easy;

import java.util.Arrays;

// LC - 14. Longest Common Prefix
// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {

    public static void main(String[] args){
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefixII(strs));
    }

    // Time complexity - O(NM) ; Space Complexity - O(K) -> confirm
    public static String longestCommonPrefixI(String[] strs) {

        if(strs.length==1) return strs[0];
        int end=0;
        String currentCommonPrefix = strs[end];
        end++;
        while(end<strs.length){
            currentCommonPrefix = findLongestCommonPrefix(currentCommonPrefix, strs[end]);
            if(currentCommonPrefix.isEmpty()) return "";
            end++;
        }

        return currentCommonPrefix;
    }

    private static String findLongestCommonPrefix(String a, String b){
        int start_a=0, start_b=0, end_a=a.length(), end_b=b.length();
        StringBuilder commonPrefix = new StringBuilder();
        while(start_a<end_a && start_b<end_b){
            if(a.charAt(start_a)!=b.charAt(start_b)) return commonPrefix.toString();
            commonPrefix.append(a.charAt(start_a));
            start_a++;
            start_b++;
        }
        return commonPrefix.toString();
    }

    // Time complexity - O(NlogN + M) ; Space Complexity - O(K) -> confirm
    public static String longestCommonPrefixII(String[] strs) {
        //Sort and compare first and last element in the array
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}
