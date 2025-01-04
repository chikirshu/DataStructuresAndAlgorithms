package com.ck.striver.array.easy;

import java.util.Arrays;

// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/logic-building/find-missing-number/submissions
public class InterviewNiceFindMissingNumber {

    public static void main(String[] args){
        int[] nums = {0, 2, 3, 1, 4};
        System.out.println(findMissingNumberI(nums));
        System.out.println(findMissingNumberII(nums));
        System.out.println(findMissingNumberIII(nums));
        System.out.println(findMissingNumberIV(nums));
        System.out.println();
    }

    /*
        Time Complexity:O(n) due to the single loop iterating through the array
        Space Complexity:O(1) as only a constant amount of space is used for variables
    */
    // optimized xor
    private static int findMissingNumberIV(int[] nums){
        int n=nums.length;
        int xor1=0, xor2=0;
        for(int i=0;i<n;i++){
            xor1=xor1^(i+1);
            xor2=xor2^nums[i];
        }

        return xor1^xor2;
    }

    // xor approach is better than sum of n natural numbers because for n=10^5 we need to store it in a bigger data structure
    // whereas xor till N natural numbers will never be that big
    // but below approach uses 2 loops
    private static int findMissingNumberIII(int[] nums){
        int n = nums.length;
        int xor1=0, xor2=0;
        for(int i=0;i<=n;i++){
            xor1=xor1^i;
        }

        for(int i=0;i<n;i++){
            xor2=xor2^nums[i];
        }
        return xor1^xor2;
    }

    // Optimized
    /*
        Time Complexity:The time complexity is O(n) due to the for loop iterating through the array once.
        Space Complexity:The space complexity is O(1) since only a fixed number of variables are used regardless of the input size.
    */
    private static int findMissingNumberII(int[] nums) {
        int n = nums.length, crntSum=0;
        int actualSum = n*(n+1)/2;
        for(int i=0;i<n;i++){
            crntSum+=nums[i];
        }
        return actualSum-crntSum;
    }

    /*
        Time Complexity:O(n log n) due to sorting the array, plus O(n) for the for loop, overall O(n log n)
        Space Complexity:O(1) since no additional space is used that scales with input size
    */
    private static int findMissingNumberI(int[] nums) {
        Arrays.sort(nums);
        if(nums[0]!=0) return 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1]!=1) return nums[i-1]+1;
        }
        return nums.length;
    }
}
