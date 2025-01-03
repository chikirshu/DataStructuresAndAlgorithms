package com.ck.striver.basics.hashing;

import java.util.HashMap;
import java.util.Map;

/*
    Time Complexity:O(n + k), where n is the number of elements in nums and k is the number of unique elements
    Space Complexity:O(k), where k is the number of unique elements stored in the hashmap
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/beginner-problems/basic-hashing/second-highest-occurring-element/submissions
public class NiceSecondHighestOccurringElement {

    public static void main(String[] args){
        int nums[] = {4,4,3,5,6,7};
        System.out.println(calculateSecondHighestOccurringElement(nums));
    }

    private static int calculateSecondHighestOccurringElement(int[] nums) {
        Map<Integer, Integer> intFreq = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            Integer freq = intFreq.getOrDefault(nums[i], 0);
            intFreq.put(nums[i], freq+1);
        }

        int maxFreq=-1, secondMaxFreq = -1, maxFreqElement = -1, secondMaxFreqElement = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry: intFreq.entrySet()){
            if(maxFreq< entry.getValue()){

                if(maxFreq==secondMaxFreq){
                    secondMaxFreqElement=Math.min(secondMaxFreqElement, maxFreqElement);
                }
                else{
                    secondMaxFreqElement=maxFreqElement;
                }
                secondMaxFreq=maxFreq;

                maxFreq=entry.getValue();
                maxFreqElement=entry.getKey();

            }
            // below is nice part to handle cases when you've got max in the first iteration itself
            // and your secondmax was at intialized(-1) state. as could be the case in {10, 9 ,7, 7}
            else if(secondMaxFreq<=entry.getValue() && entry.getValue()!=maxFreq){
                if(secondMaxFreq==entry.getValue()){
                    secondMaxFreqElement=Math.min(secondMaxFreqElement, entry.getKey());
                }
                else{
                    secondMaxFreqElement= entry.getKey();
                }
                secondMaxFreq=entry.getValue();
            }
        }
        return secondMaxFreqElement == Integer.MAX_VALUE?-1:secondMaxFreqElement;
    }
}
