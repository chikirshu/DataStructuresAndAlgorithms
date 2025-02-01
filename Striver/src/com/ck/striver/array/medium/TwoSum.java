package com.ck.striver.array.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/plus/dsa/arrays/faqs-medium/two-sum?tab=submissions
public class TwoSum {


    public static void main(String[] args){
        int[] nums = {1, 6, 2, 10, 3};
        int target = 7;

        int[] ans = getTwoSumIndices(nums, target);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+ " ");
        }

        System.out.println();
        int[] ansII = getTwoSumIndicesII(nums, target);
        for(int i=0;i<ansII.length;i++){
            System.out.print(ansII[i]+ " ");
        }
    }

    /*
        Time Complexity:The time complexity is O(n log n) due to the sorting step, where n is the length of the input array 'nums'.
        Space Complexity:The space complexity is O(n) because of the additional storage used for the 'keyValuePair' array.
    */
    // Not so intutive because of indices.
    // 0->nums[i]; 1->i
    private static int[] getTwoSumIndicesII(int[] nums, int target){
        int[][] keyValuePair = new int[nums.length][2];
        for(int i=0;i<nums.length;i++){
            keyValuePair[i][0]=nums[i];
            keyValuePair[i][1]=i;
        }

        Arrays.sort(keyValuePair, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[0], o2[0]);
            }
        });
        int start = 0, end = nums.length-1;
        while(start<end){
            if(keyValuePair[start][0]+keyValuePair[end][0]==target){
                return new int[]{keyValuePair[start][1], keyValuePair[end][1]};
            }
            else if(keyValuePair[start][0]+keyValuePair[end][0]<target){
                start++;
            }
            else{
                end--;
            }
        }
        return new int[]{-1, -1};
    }

    /*
        Time Complexity:O(n), where n is the length of the input array, due to two separate O(n) loops.
        Space Complexity:O(n), due to the space required to store elements in the HashMap.
    */
    // assuming duplicate numbers will not be present in the array
    private static int[] getTwoSumIndices(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], i);
        }
        for(int i=0;i<nums.length;i++){
            // Added map.get(target-nums[i])!=i to avoid test cases failures where both values should not come from same index
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i){
                Integer valIdx = map.get(target - nums[i]);
                return i<=valIdx?new int[]{i, valIdx}:new int[]{valIdx, i};
            }
        }
        return new int[] {-1, -1};
    }
}
