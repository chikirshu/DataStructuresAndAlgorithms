package com.ck.striver.basics.recursion;

/*
    Time Complexity:O(n) where n is the length of the array due to the single loop iterating half the array
    Space Complexity:O(1) since no additional data structures are used, only a constant amount of space for the temp variable
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-recursion/reverse-an-array/submissions
public class ReverseAnArray {

    public static void main(String[] args){
        int nums[] = {1,2,3,4,5};
        reverseAnArray(nums);
        for(int i=0; i<nums.length;i++){
            System.out.print(nums[i]+ " ");
        }
    }

    private static void reverseAnArray(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n/2;i++){
            int temp = nums[i];
            nums[i] = nums[n-1-i];
            nums[n-1-i] = temp;
        }
    }
}
