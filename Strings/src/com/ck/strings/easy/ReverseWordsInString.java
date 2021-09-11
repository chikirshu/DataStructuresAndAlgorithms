package com.ck.strings.easy;

// GFG - Reverse words in a given string 
// https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1#
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

}
