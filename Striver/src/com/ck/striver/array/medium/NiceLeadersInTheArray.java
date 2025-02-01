package com.ck.striver.array.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    Time Complexity:O(n) because of the two loops that iterate through the array; one for finding leaders and one for reversing the result.
    Space Complexity:O(n) for storing the leaders in the ans array and the ArrayList.
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/faqs-medium/leaders-in-an-array/submissions
public class NiceLeadersInTheArray {

    public static void main(String[] args){
        int[] nums = {1,2,5,3,1,2};
        System.out.println(getLeadersInArray(nums));
    }

    private static List<Integer> getLeadersInArrayII(int[] nums) {
        int n=nums.length, previousMax=Integer.MIN_VALUE, k=0;
        int max = nums[n-1];
        List<Integer> ans = new ArrayList<>();
        ans.add(max);

        for(int i=n-1;i>=0;i--){
            if(nums[i]>max){
                max=nums[i];
                ans.add(max);
            }
        }

        Collections.reverse(ans);
        return ans;
    }

    private static List<Integer> getLeadersInArray(int[] nums) {
        int n=nums.length, previousMax=Integer.MIN_VALUE, k=0;
        int max = nums[n-1];
        int[] ans = new int[n];
        ans[k++]=max;

        for(int i=n-1;i>=0;i--){
            if(max==nums[i])continue;
            max=Math.max(max, nums[i]);
            if(nums[i]==max){
                ans[k++]=max;
            }
        }

        return reverseList(ans,k-1);
    }

    private static List<Integer> reverseList(int[] ans, int k) {
        List<Integer> list = new ArrayList<>();

        for(int i=k;i>=0;i--){
            list.add(ans[i]);
        }
        return list;
    }
}
