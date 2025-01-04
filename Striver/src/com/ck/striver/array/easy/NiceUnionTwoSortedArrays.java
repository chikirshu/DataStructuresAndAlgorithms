package com.ck.striver.array.easy;

import java.util.ArrayList;
import java.util.List;

// Struggled in if else condition. Could have use set. But on changing it to arraylist created dilemma of where to increment pointers
/*
    Time Complexity:O(n + m), where n and m are the lengths of nums1 and nums2 due to the two main while loops and the final for loop
    Space Complexity:O(n + m) for storing the unique elements in the set and the resulting array
*/
// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/logic-building/union-of-two-sorted-arrays/submissions
public class NiceUnionTwoSortedArrays {

    public static void main(String[] args){
        int[] nums1 = {3,4,4,4};
        int[] nums2 = {6,7,7};
        int[] ans = getUnionArray(nums1, nums2);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }

    private static int[] getUnionArray(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        List<Integer> ans = new ArrayList<>();
        int i=0, j=0, k=0;
        while(i<n && j<m){
            if(nums1[i]<nums2[j]){
                if(ans.size()==0 || ans.get(ans.size()-1)!=nums1[i]) ans.add(nums1[i]);
                i++;
            }
            else if(nums2[j]<nums1[i]){
                if(ans.size()==0||ans.get(ans.size()-1)!=nums2[j]) ans.add(nums2[j]);
                j++;
            }
            else{
                if(ans.size()==0 || ans.get(ans.size()-1)!=nums1[i]) ans.add(nums1[i]);
                i++;
                j++;
            }
        }
        while(i<n){
            if(ans.size()==0 || ans.get(ans.size()-1)!=nums1[i]) ans.add(nums1[i]);
            i++;// Nice NOTE moved increment from nums1[i++] to here as it was inside a if condition and failing that program ended in infinite loop
        }
        while(j<m){
            if(ans.size()==0 || ans.get(ans.size()-1)!=nums2[j]) ans.add(nums2[j]);
            j++;
        }
        int[] ansArr = new int[ans.size()];
        for(Integer val : ans){
            ansArr[k++]=val;
        }
        return ansArr;
    }
}
