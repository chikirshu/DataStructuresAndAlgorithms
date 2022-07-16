package com.ck.strings.medium;

import java.util.HashMap;
import java.util.Map;

// LC - 205 : Isomorphic Strings
// https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphicI("badc","baba"));
	}
	
	public static boolean isIsomorphicI(String s, String t) {
        if(s.length()!=t.length())
            return false;
        
        Map<Character,Character> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))!=null){
                if((map.get(s.charAt(i))!=null && !map.get(s.charAt(i)).equals(t.charAt(i)))){
                    return false;
                }
            }
            else{
            	// instead of doing this we can also use set and store values in it. If values are already there then return false
                if(!map.containsValue(t.charAt(i)))
                    map.put(s.charAt(i),t.charAt(i));
                else
                    return false;
                
            }
        }
        return true;
    }

}
