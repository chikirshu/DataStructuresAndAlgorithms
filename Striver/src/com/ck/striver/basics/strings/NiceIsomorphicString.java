package com.ck.striver.basics.strings;

import java.util.HashMap;
import java.util.Map;

/*
    Time Complexity:O(n) where n is the length of the input strings; linear traversal with constant time map operations
    Space Complexity:O(min(n, m)) where n and m are the lengths of the input strings; space used for the hashmap storing character mappings
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-strings/isomorphic-string/submissions
public class NiceIsomorphicString {

    public static void main(String[] args){
        String s="add", t="egg";
        System.out.println(areIsomorphicStrings(s, t));
    }

    private static boolean areIsomorphicStrings(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char chS = s.charAt(i);
            char chT = t.charAt(i);
            if(map.get(chS)!=null){
                if(!map.get(chS).equals(chT)) return false;
            }
            else{
                if(map.containsValue(chT)) return false;
                else{
                    map.put(chS, chT);
                }
            }
        }
        return true;
    }
}
