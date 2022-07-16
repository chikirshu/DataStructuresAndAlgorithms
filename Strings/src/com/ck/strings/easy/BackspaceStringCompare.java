package com.ck.strings.easy;

// LC - 844 : Backspace String Compare
// https://leetcode.com/problems/backspace-string-compare/
public class BackspaceStringCompare {

	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c","ad#c"));
	}
	
	public static boolean backspaceCompare(String s, String t) {
        int i=0, j=0;
        
        StringBuilder sb = new StringBuilder();
        StringBuilder tb = new StringBuilder();
        
        while(i<s.length() || j<t.length()){
            if(i<s.length()){
                if(s.charAt(i)=='#'){
                    if(sb.length()>0)
                        sb.setLength(sb.length()-1);
                }
                else{
                    sb.append(s.charAt(i));
                }
                i++;
            }
            if(j<t.length()){
                if(t.charAt(j)=='#'){
                    if(tb.length()>0)
                        tb.setLength(tb.length()-1);
                }
                else{
                    tb.append(t.charAt(j));
                }
                j++;
            }
        }
        
        return sb.toString().equals(tb.toString());
    }

}
