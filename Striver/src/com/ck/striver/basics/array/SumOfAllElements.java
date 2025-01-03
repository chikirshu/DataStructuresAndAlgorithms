package com.ck.striver.basics.array;

/*
    Time Complexity:O(n) - single loop iterates through all elements in the array
    Space Complexity:O(1) - only a constant amount of space used for the sum variable
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-arrays/sum-of-array-elements/submissions
public class SumOfAllElements {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        int n= nums.length;
        System.out.println(getSumOfAllElements(nums, n));
    }

    private static int getSumOfAllElements(int[] nums, int n) {
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        return sum;
    }
}
