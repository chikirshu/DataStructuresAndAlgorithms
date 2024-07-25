package com.ck.arrays.easy;

import java.util.Arrays;
import java.util.List;

public class ArrayFromPermutation {

    public static void main(String[] args){
        int[] nums = new int[]{0,2,1,5,3,4};
        System.out.println(Arrays.toString(buildArrayII(nums)));
    }

    //O(n) time; O(n) space
    public static int[] buildArrayI(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length; i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

    //O(n) time; O(1) space
    /*
        let a = nums[i] and b= nums[nums[i]]
        let nums=[0,2,1,5,3,4]
        if a = nums[3] = 5 then b = nums[nums[3]] = nums[5] = 4
        a+nb = 5 + 64 = 29
        29%n = 29 % 6 = 5 = a; so formula for a = (a+nb)%n
        29/n = 29/6 = 4 = b ; so formula for b = (a+nb)/n
        n=6
        i=0; a = nums[0] = 0; b = nums[nums[0]] = nums[0] = 0; a+nb = 0; a = 0%6 = 0; b = 0/6=0
        i=1; a = nums[1] = 2; b = nums[nums[1]] = nums[2] = 1; a+nb = 8; b = 8%6 = 2; b = 8/6=1
        i=2; a = nums[2] = 1; b = nums[nums[2]] = nums[1] = 2; a+nb = 13; a = 13%6 = 1; b = 13/6=2
        i=3; a = nums[3] = 5; b = nums[nums[3]] = nums[5] = 4; a+nb = 29; a = 29%6 = 5; b = 29/6=4
        i=4; a = nums[4] = 3; b = nums[nums[4]] = nums[3] = 5; a+nb = 33; a = 33%6 = 3; b = 33/6=5
        i=5; a = nums[5] = 4; b = nums[nums[5]] = nums[4] = 3; a+nb = 22; a = 22%6 = 4; b = 22/6=3

        [0,2,1,5,3,4]
        [0, 8, 13, 29, 33, 22]
        [0, 1, 2, 4, 5, 3]
    */
    public static int[] buildArrayII(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n; i++){
            nums[i] = nums[i]+n*(nums[nums[i]]%n);
        }

        for(int i=0;i<n;i++){
            nums[i] = nums[i]/n;
        }
        return nums;
    }
}
