package com.ck.striver.basics.array;

/*
    Time Complexity:O(n), where n is the length of the array; we iterate over the entire array once.
    Space Complexity:O(1), only a constant amount of space is used for the counter variable.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-arrays/count-of-odd-numbers-in-array/submissions
public class CountOfOddNumbers {

    public static void main(String[] args){
        int[] nums = {1,2,3,4,5};
        int n = nums.length;
        System.out.println(getOddCount(nums, n));
    }

    private static int getOddCount(int[] nums, int n) {
        int cnt=0;
        for(int i=0;i<n;i++){
            if(nums[i]%2!=0)cnt++;
        }
        return cnt;
    }
}
