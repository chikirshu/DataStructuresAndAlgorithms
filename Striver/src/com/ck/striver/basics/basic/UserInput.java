package com.ck.striver.basics.basic;

import java.util.Scanner;

/*
    Time Complexity:The time complexity is O(1) since it performs a constant number of operations regardless of input size.
    Space Complexity:The space complexity is O(1) as it uses a fixed amount of space for variables.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/language-basics/input-output/submissions
public class UserInput {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(n);
    }
}
