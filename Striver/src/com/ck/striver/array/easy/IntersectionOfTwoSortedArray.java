package com.ck.striver.array.easy;

import java.util.*;

// https://takeuforward.org/plus/data-structures-and-algorithm/arrays/logic-building/intersection-of-two-sorted-arrays/submissions
public class IntersectionOfTwoSortedArray {

    public static void main(String[] args){
        int[] nums1 = {1, 2, 2, 3, 5};
        int[] nums2 = {1, 2, 7};

        int[] ans = getIntersectedElementsI(nums1, nums2);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+ " ");
        }
        System.out.println();
        int[] ans2 = getIntersectedElementsII(nums1, nums2);
        for(int i=0;i<ans2.length;i++){
            System.out.print(ans2[i]+ " ");
        }
    }

    /*
        In reality Time complexity will be O(min(n1,n2))
        Time Complexity:O(n1 + n2) where n1 is the length of nums1 and n2 is the length of nums2 due to the while loop and for loop
        Space Complexity:O(n) for storing the intersection elements in the list
    */
    // Optimized
    public static int[] getIntersectedElementsII(int[] nums1, int[] nums2){
        int n1= nums1.length, n2 = nums2.length, i=0, j=0;
        List<Integer> list = new ArrayList<>();
        while(i<n1 && j<n2){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums2[j]<nums1[i]){
                j++;
            }
            else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] ans = new int[list.size()];
        for(int k=0;k<list.size();k++){
            ans[k]=list.get(k);
        }
        return ans;
    }

    /*
        Time Complexity:O(n1 + n2) where n1 and n2 are the lengths of the input arrays
        Space Complexity:O(n1 + n2) for the hashmap and list used to store the results
    */
    private static int[] getIntersectedElementsI(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int n1=nums1.length, n2=nums2.length;
        for(int i=0;i<n1;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0;i<n2;i++){
            if(map.containsKey(nums2[i]) && map.get(nums2[i])>0){
                map.put(nums2[i],map.get(nums2[i])-1);
                list.add(nums2[i]);
            }
        }

        int[] ans = new int[list.size()];
        int k=0;
        for(int i=0;i<list.size();i++){
            ans[k++]=list.get(i);
        }
        return ans;
    }
}
