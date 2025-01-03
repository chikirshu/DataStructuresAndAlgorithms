package com.ck.striver.basics.basic;

/*
    Time Complexity:O(1) because it accesses the last character directly without any iterations
    Space Complexity:O(1) since no additional data structures are used that scale with input size
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/language-basics/print-last-character-of-string/submissions
public class PrintLastCharacter {

    public static void main(String[] args){
        String s="takeuforward";
        System.out.println(getLastCharacter(s));
    }

    private static char getLastCharacter(String s) {
        return s.charAt(s.length()-1);
    }
}
