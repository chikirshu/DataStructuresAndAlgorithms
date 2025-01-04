package com.ck.striver.basics.strings;

import java.util.Vector;

/*
    Time Complexity:O(n) where n is the size of the input vector due to the single loop through half of the vector
    Space Complexity:O(1) since no additional space is used that scales with input size
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-strings/reverse-a-string/submissions
public class ReverseAString {

    public static void main(String[] args){
        Vector<Character> s=new Vector<>();
        s.add('h');
        s.add('e');
        s.add('l');
        s.add('l');
        s.add('o');

        System.out.println(reverseAString(s));
    }

    // Can also use two pointer approach start and end; do start++ and end--.
    // Two pointer approach is better because if asked to reverse a part of string then below approach will not give correct solution
    private static Vector<Character> reverseAString(Vector<Character> s) {
        int n=s.size();
        for(int i=0;i<n/2;i++){
            Character temp = s.get(i);
            s.set(i, s.get(n-1-i));
            s.set(n-1-i, temp);
        }
        return s;
    }
}
