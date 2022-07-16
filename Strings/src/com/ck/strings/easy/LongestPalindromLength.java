package com.ck.strings.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromLength {

	public static void main(String[] args) {
		System.out.println(longestPalindromeLengthI("aabbccdddeeefffff"));
	}
	
	public static int longestPalindromeLengthI(String s) {
        int len=0, isOdd=0;
        Map<Character, Integer> map= new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue()%2==0)
                len+=entry.getValue();
            else{
                len+=entry.getValue()-1;
                isOdd=1;
            }
        }
        return isOdd==0?len:len+1;
        
    }

}
