package com.ck.strings.medium;

import java.util.Arrays;
import java.util.List;

// LC - 139. Word Break
// https://leetcode.com/problems/word-break/
public class WordBreak {
	static int loopCnt=0;

	public static void main(String[] args) {
		System.out.println(wordBreakI("leetcodef", Arrays.asList(new String[] {"leet", "code"})));
		System.out.println(loopCnt);
	}
	
	// will give TLE
	public static boolean wordBreakI(String s, List<String> wordDict) {
        
        return isWordBreak(0,s,wordDict);
        
    }
    
    public static boolean isWordBreak(int start, String s, List<String> wordDict){
        if(start==s.length()){
            return true;
        }
        for(int i=start;i<s.length();i++){
        	loopCnt++;
            if(wordDict.contains(s.substring(start, i+1))){
                boolean res = isWordBreak(i+1,s,wordDict);
                if(res){
                    return true;
                }
            }
        }
      return false;
    }
    
    public static boolean wordBreakII(String s, List<String> wordDict) {
        
        return isWordBreak(0,s,wordDict);
        
    }

}
