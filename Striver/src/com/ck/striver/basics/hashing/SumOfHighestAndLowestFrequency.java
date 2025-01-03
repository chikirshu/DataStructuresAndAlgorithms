package com.ck.striver.basics.hashing;

import java.util.HashMap;
import java.util.Map;

/*
    Time Complexity:O(n + m) where n is the length of nums and m is the number of unique elements
    Space Complexity:O(m) where m is the number of unique elements in nums due to the HashMap storage.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-hashing/sum-of-highest-and-lowest-frequency/submissions
public class SumOfHighestAndLowestFrequency {

    public static void main(String[] args){
        int[] nums = {10, 9, 7, 7, 8, 8, 8};
        System.out.println(getSumofHighestAndLowestFrequency(nums));
    }

    private static int getSumofHighestAndLowestFrequency(int[] nums) {
        Map<Integer, Integer> intFreq = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            Integer freq = intFreq.getOrDefault(nums[i], 0);
            intFreq.put(nums[i], freq+1);
        }

        int minFreq = Integer.MAX_VALUE, maxFreq=Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> entry : intFreq.entrySet()){
            if(minFreq>=entry.getValue()){
                minFreq = entry.getValue();
            }
            if(maxFreq<=entry.getValue()){
                maxFreq = entry.getValue();
            }
        }
        return minFreq+maxFreq;
    }
}
