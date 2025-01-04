package com.ck.striver.array.easy;

import java.util.Arrays;

/*
    Time Complexity:The time complexity is O(n) because we iterate through the entire array once to perform the rotation.
    Space Complexity:The space complexity is O(1) as we use a constant amount of extra space for variables.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/fundamentals/left-rotate-array-by-one/submissions
public class LeftRotateArrayByOne {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        leftRotateArrayByOne(nums);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }

    private static void leftRotateArrayByOne(int[] nums) {
        int n=nums.length;
        if(n==1) return;

        int temp = nums[0];
        for(int i=1;i<n;i++){
            nums[i-1]=nums[i];
        }
        nums[n-1]=temp;
    }
}
