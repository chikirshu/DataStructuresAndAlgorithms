package com.ck.striver.basics.pattern;

/*
    Time Complexity:The time complexity is O(n^2) because there are two nested loops, each iterating n times.
    Space Complexity:The space complexity is O(1) since it uses a constant amount of space regardless of the input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-1/submissions
public class Pattern1 {

    public static void main(String[] args){
        int n=4;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
