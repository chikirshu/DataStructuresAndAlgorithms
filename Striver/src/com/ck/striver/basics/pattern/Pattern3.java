package com.ck.striver.basics.pattern;

/*
    Time Complexity:The time complexity is O(n^2) because the inner loop runs i times for each of the n iterations of the outer loop.
    Space Complexity:The space complexity is O(1) as no additional space proportional to input size is used.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/patterns/pattern-3/submissions
public class Pattern3 {

    public static void main(String[] args){
        int n=4;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
