package com.ck.striver.basics.basic;

/*
    Time Complexity:The time complexity is O(1) since it involves a constant number of operations irrespective of input size.
    Space Complexity:The space complexity is O(1) as it uses a fixed amount of space for the variables.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/language-basics/if-else-adult-teen-problem/submissions
public class AdultOrNot {

    public static void main(String[] args){
        int age = 19;
        System.out.print(getAdultOrTeen(age));
    }

    private static String getAdultOrTeen(int age) {
        if(age>=18) return "Adult";
        else return "Teen";
    }
}
