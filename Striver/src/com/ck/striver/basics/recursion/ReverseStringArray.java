package com.ck.striver.basics.recursion;

import java.util.Vector;

/*
    Time Complexity:O(n) where n is the size of the vector since we iterate through half of the elements to reverse the string
    Space Complexity:O(1) as we are using a constant amount of extra space for a few variables
*/
public class ReverseStringArray {

    public static void main(String[] args){
        Vector<Character> s = new Vector<>();
        s.add('h');
        s.add('e');
        s.add('l');
        s.add('l');
        s.add('o');

        System.out.println(reverseString(s));
    }

    private static Vector<Character> reverseString(Vector<Character> s){
        int n = s.size();
        for(int i=0; i<n/2; i++){
            Character temp = s.get(i);
            s.set(i, s.get(n-1-i));
            s.set(n-1-i, temp);
        }
        return s;
    }
}
