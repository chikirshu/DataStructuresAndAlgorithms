package com.ck.striver.basics.pattern;

/*
    Time Complexity:The time complexity is O(n^2) due to the nested loops, with the inner loop's iterations summing up from 1 to n.
    Space Complexity:The space complexity is O(1) as no additional data structures are used, only a fixed amount of space for variables.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-2/submissions
public class Pattern2 {

    public static void main(String[] args){
        int n=4;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
