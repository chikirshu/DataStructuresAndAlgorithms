package com.ck.arrays.easy;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// LC - 1. Two Sum
// https://leetcode.com/problems/two-sum/
public class TwoSum {

	public static void main(String[] args) throws IOException {
		int[] result = twoSum(new int[] { 3,4,5,3 }, 6);
		System.out.println("Output is: " + result[0] + ", " + result[1]);
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			}
			map.put(nums[i], i);
		}

		return new int[] { 0, 0 };
	}
	
	public int[] twoSumII(int[] nums, int target) {
        
        int[] arr = new int[nums.length];
        //shallow copy
        // int[] arr = nums;
        
        // deep copy
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        
        int[] res = new int[2];
        int start=0, end=nums.length-1, k=0;
        Arrays.sort(nums);
        
        while(start<end){
            if(nums[start]+nums[end]==target){
                break;
            }
            else if(nums[start]+nums[end]<target){
                start++;
            }
            else{
                end--;
            }
        }
        // System.out.println(start+" "+end + " arr " + Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            if(arr[i]==nums[start] || arr[i]==nums[end]){
                res[k++]=i;
            }
        }
            
        return res;
    }

}
