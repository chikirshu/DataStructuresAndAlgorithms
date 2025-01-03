package com.ck.striver.basics.strings;

/*
    Time Complexity:O(n + m) where n is the length of s and m is the length of t
    Space Complexity:O(1) as the frequency array size is constant (26 characters)
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-strings/valid-anagram/submissions
public class ValidAnagram {

    public static void main(String[] args){
        String s = "dog", t = "cat";
        System.out.println(isValidAnagram(s, t));
    }

    private static boolean isValidAnagram(String s, String t) {
        int[] freq = new int[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)-'a']--;
        }

        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0) return false;
        }
        return true;
    }
}
