package com.ck.striver.basics.basic;

/*
    Time Complexity:O(1) as it performs a constant number of operations regardless of input size
    Space Complexity:O(1) as it uses a fixed amount of space for variables only
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/language-basics/sum-of-first-last-element-in-array/submissions
public class SumOfFirstAndLastNum {

    public static void main(String[] args){
        int[] nums = {-1, 2, 4, 1};
        int n=nums.length;
        System.out.println(getFirstAndLastNumsSum(nums, n));
    }

    private static int getFirstAndLastNumsSum(int[] nums, int n) {
        return nums[0]+nums[n-1];
    }
}
