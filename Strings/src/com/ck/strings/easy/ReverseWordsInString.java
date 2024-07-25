package com.ck.strings.easy;

import java.util.Arrays;
import java.util.List;

// GFG - Reverse words in a given string
// https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1#

// LC - 151. Reverse Words in a String
// https://leetcode.com/problems/reverse-words-in-a-string/description%
public class ReverseWordsInString {

	public static void main(String[] args) {
		System.out.println(reverseWords("i.like.this.program.very.much"));
	}
	public static String reverseWords(String S)
    {
        // code here 
        String[] s1 = S.split("\\.");
        String res="";
        for(int i=0;i<s1.length/2;i++){
            String temp = s1[i];
            s1[i]=s1[s1.length-1-i];
            s1[s1.length-1-i]=temp;
        }
        res=String.join(".", s1);
        return res;
    }

    public static String reverseWordsII(String s) {
        List<String> wordsList = Arrays.asList(s.split("\\s+"));
        StringBuilder sb = new StringBuilder();
        for(int i=wordsList.size()-1; i>=0 ; i--){
            if(!wordsList.get(i).trim().isEmpty()){
                sb.append(wordsList.get(i));
                sb.append(" ");
            }
        }
        String res = sb.toString();
        return res.substring(0,res.length()-1);
    }

}
