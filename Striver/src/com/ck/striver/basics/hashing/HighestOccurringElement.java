package com.ck.striver.basics.hashing;

import java.util.HashMap;
import java.util.Map;

/*
    Time Complexity:O(n) where n is the length of the input array due to the single loop iterating through it
    Space Complexity:O(n) for the hashmap to store the frequency of each element in the array
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-hashing/highest-occurring-element-in-an-array/submissions
public class HighestOccurringElement {

    public static  void main(String[] args){
        int[] nums={4};
        System.out.println(calculateHighestOccurringElement(nums));
    }

    private static int calculateHighestOccurringElement(int[] nums) {
        Map<Integer, Integer> intFreq = new HashMap<>();
        int n=nums.length, maxFreq=-1, maxFreqElement=-1;
        for(int i=0;i<n;i++){
            int freq = intFreq.getOrDefault(nums[i], 0)+1;
            if(maxFreq<freq){
                maxFreq=freq;
                maxFreqElement=nums[i];
            }
            else if(maxFreq==freq){
                maxFreqElement=Math.min(maxFreqElement, nums[i]);
            }
            intFreq.put(nums[i], freq);
        }
        return maxFreqElement;
    }
}
