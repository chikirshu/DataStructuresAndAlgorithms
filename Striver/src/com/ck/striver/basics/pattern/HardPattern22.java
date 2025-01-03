package com.ck.striver.basics.pattern;

/*
    Time Complexity:O(n^2) - Two nested loops each running 2n-1 times
    Space Complexity:O(1) - Only a fixed amount of extra space used for variables
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-22/submissions
public class HardPattern22 {
    public static void main(String[] args){
        int n=5;
        for(int i=0;i<2*n-1;i++){
            for(int j=0;j<2*n-1;j++){
                int top = i;
                int left = j;
                int down = 2*n-2-i;
                int right = 2*n-2-j;
                int val = n-Math.min(Math.min(Math.min(top, left), down), right);
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
