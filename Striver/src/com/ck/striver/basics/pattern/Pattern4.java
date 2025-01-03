package com.ck.striver.basics.pattern;

/*
    Time Complexity:The time complexity is O(n^2) due to the nested loops where the inner loop runs i times for each iteration of the outer loop.
    Space Complexity:The space complexity is O(1) since it uses a constant amount of space regardless of the input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-4/submissions
public class Pattern4 {

    public static void main(String[] args){
        int n=4;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
