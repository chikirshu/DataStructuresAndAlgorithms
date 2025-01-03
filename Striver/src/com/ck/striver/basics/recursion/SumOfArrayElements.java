package com.ck.striver.basics.recursion;

/*
    Time Complexity:The time complexity is O(n) because the function recursively processes each element of the array once.
    Space Complexity:The space complexity is O(n) due to the recursive call stack used for n recursive calls.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-recursion/sum-of-array-elements
public class SumOfArrayElements {

    public static void main(String[] args){
        int[] nums = {1,2,3};

        System.out.println(findSum(nums, 0, 0));
    }

    private static int findSum(int[] nums, int crntIdx, int crntSum) {
        if(crntIdx==nums.length-1) return crntSum+nums[crntIdx];
        return findSum(nums, crntIdx+1, crntSum+nums[crntIdx]);
    }
}
