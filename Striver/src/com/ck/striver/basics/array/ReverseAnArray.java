package com.ck.striver.basics.array;

/*
    Time Complexity:O(n) because the loop runs n/2 times, where n is the length of the array
    Space Complexity:O(1) as only a constant amount of extra space is used for variables
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-arrays/reverse-an-array/submissions
public class ReverseAnArray {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        int n = nums.length;
        reverseAnArray(nums, n);
        for(int i=0;i<n;i++){
            System.out.print(nums[i]+" ");
        }
    }

    // Note this technique will not work if you have to reverse a sub arrray. Its better to traverse from start to end
    // Can also use two pointer approach start and end; do start++ and end--.
    // Two pointer approach is better because if asked to reverse a part of string then below approach will not give correct solution
    private static void reverseAnArray(int[] nums, int n){
        for(int i=0;i<n/2;i++){
            int temp = nums[i];
            nums[i]=nums[n-1-i];
            nums[n-1-i]=temp;
        }
    }
}
