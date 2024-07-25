package com.ck.arrays.easy;

// LC - 28. Find the Index of the First Occurrence in a String
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/
public class NeedleInHaystack {

    public static void main(String[] args){
        System.out.println(strStr("hello","ll"));
    }

    public static int strStr(String haystack, String needle) {
        int h_start=0, h_end=0, n_start=0, n_end=0, n=haystack.length(), m=needle.length();
        boolean needleFound=false;
        while((h_start<n && h_end<n) && (n_start<m && n_end<m)){

            if(haystack.charAt(h_end)==needle.charAt(n_end)){
                h_end++;
                n_end++;
                if(n_end==m){
                    needleFound=true;
                    break;
                }
            }
            else{
                h_start=h_start+1;
                h_end=h_start;
                n_end=n_start;
            }
        }
        return needleFound?h_start:-1;
    }
}
