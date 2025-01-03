package com.ck.striver.basics.array;

/*
    Time Complexity:O(n) where n is the length of the array, due to the linear traversal in the for loop.
    Space Complexity:O(1) as the algorithm uses a constant amount of space regardless of the input size.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-arrays/check-if-the-array-is-sorted/submissions
public class IsSortedArray {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        System.out.println(isSortedArray(nums));
    }

    private static boolean isSortedArray(int[] nums){
        if(nums.length==1) return true;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]) return false;
        }
        return true;
    }
}
