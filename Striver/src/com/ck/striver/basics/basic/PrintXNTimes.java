package com.ck.striver.basics.basic;

/*
    Time Complexity:O(N) due to the for loop iterating N times
    Space Complexity:O(N) for the StringBuilder storing N characters
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/language-basics/print-x-n-numbers-of-times/submissions
public class PrintXNTimes {

    public static void main(String[] args){
        int X = 5, N=7;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(X+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
