package com.ck.striver.basics.maths;

import java.util.ArrayList;
import java.util.List;

/*
    Time Complexity:O(n) due to the for loop in getAllDivisors and additional O(n) to copy to the array
    Space Complexity:O(n) for the list to store divisors up to n/2
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-maths/divisors-of-a-number/submissions
public class AllDivisors {

    public static void main(String[] args){
        int n=5;
        List<Integer> divisors = getAllDivisors(n);
        divisors.add(n);
        System.out.println(divisors);
    }

    private static List<Integer> getAllDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for(int i= 1; i<=n/2;i++){
            if(n%i==0){
                divisors.add(i);
            }
        }
        return divisors;
    }
}
