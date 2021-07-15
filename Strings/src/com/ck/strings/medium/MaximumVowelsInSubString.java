package com.ck.strings.medium;

// LC - 1456 : Maximum Number of Vowels in a Substring of Given Length
public class MaximumVowelsInSubString {

	public static void main(String[] args) {
		System.out.println(maxVowels("weallloveyou",7));
	}
public static int maxVowels(String s, int k) {
        
        int start=0, max=0,cnt=0;
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            if(i-k>=0){
                max=(int)Math.max(max,cnt);
                char c1=s.charAt(start++);
                if(c1=='a'||c1=='e'||c1=='i'||c1=='o'||c1=='u') cnt--;
            }
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u')cnt++;
        }
        return (int)Math.max(max,cnt);
    }

}
