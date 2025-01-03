package com.ck.striver.basics.strings;

public class RotateString {

    public static void main(String[] args){
        String s = "abcde";
        String goal = "cdeab";
        System.out.println(rotateString(s, goal));
    }

    /*
        Time Complexity:O(n^2) due to the substring and comparison in a loop
        Space Complexity:O(n) for storing the temporary string during substring operations
    */
    private static boolean rotateString(String s, String goal) {
        for(int i=0;i<s.length();i++){
            String temp = s.substring(i) + s.substring(0,i);
            if(temp.equalsIgnoreCase(goal)) return true;
        }
        return false;
    }

    /*
        Time Complexity O(N) , because checking for a substring in s + s is linear in time.
        Space Complexity O(N) for the space needed to store the concatenated string s + s.
    */
    public boolean optimalRotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        String doubledS = s + s;  // Concatenate s with itself
        return doubledS.contains(goal);  // Check if goal is a substring of s + s
    }
}
