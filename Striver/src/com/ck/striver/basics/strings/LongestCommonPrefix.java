package com.ck.striver.basics.strings;

/*
    Time Complexity:O(n*m) where n is the number of strings and m is the length of the longest string
    Space Complexity:O(m) where m is the length of the longest string due to the space used for storing the prefix
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-strings/longest-common-prefix/submissions
public class LongestCommonPrefix {

    public static void main(String[] args){
        String[] str = {"dog" , "cat" , "animal", "monkey"};
        System.out.println(getLongestCommonPrefix(str));
    }

    private static String getLongestCommonPrefix(String[] str) {

        int n = str.length;
        if(n==1) return str[0];

        String start=str[0];

        for(int i=1; i<n ; i++){
            int j=0, k=0;
            String crntLongestPrefix = "";
            StringBuilder crntPrefix= new StringBuilder();
            String end = str[i];
            while(j<start.length() && k<end.length()){
                if(start.charAt(j)==end.charAt(k)){
                    crntPrefix.append(start.charAt(j));
                    j++;
                    k++;
                }
                else{
                    j++;
                    if(crntLongestPrefix.length()<=crntPrefix.toString().length()){
                        crntLongestPrefix = crntPrefix.toString();
                    }
                    if(!crntPrefix.isEmpty()) crntPrefix = new StringBuilder();
                }
            }
            if(crntLongestPrefix.length()<=crntPrefix.toString().length()){
                crntLongestPrefix = crntPrefix.toString();
            }
            start = crntLongestPrefix;
        }
        return start;
    }
}
