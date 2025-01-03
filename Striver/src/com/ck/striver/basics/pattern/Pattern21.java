package com.ck.striver.basics.pattern;

/*
    Time Complexity:O(n^2) because there are two nested loops, one running n times and the other in the else branch running n-2 times for each iteration of the outer loop.
    Space Complexity:O(1) as no additional data structures are used that scale with input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-21/submissions
public class Pattern21 {

    public static void main(String[] args){
        int n=5;
        for(int i=0;i<n;i++){
            if(i==0||i==n-1){
                for(int j=0;j<n;j++){
                    System.out.print("*");
                }
            }
            else{
                System.out.print("*");
                for(int j=0;j<n-2;j++){
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
