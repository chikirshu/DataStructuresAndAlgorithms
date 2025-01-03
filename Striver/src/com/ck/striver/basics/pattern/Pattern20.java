package com.ck.striver.basics.pattern;

// Almost an inversion of Pattern 19. In Pattern19 the middle layer is duplicated but in this it is not
/*
    Time Complexity:The time complexity is O(n^2) due to nested loops each iterating up to n.
    Space Complexity:The space complexity is O(1) as it uses a constant amount of space for variables.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-20/submissions
public class Pattern20 {

    public static void main(String[] args){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            for(int j=0;j<2*(n-1-i);j++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            for(int j=0;j<2*i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<n-i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
