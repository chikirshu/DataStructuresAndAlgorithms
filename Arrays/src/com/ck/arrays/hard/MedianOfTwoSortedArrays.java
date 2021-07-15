package com.ck.arrays.hard;

//LC - 4 : Median of Two Sorted Arrays
// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		//System.out.println(findMedianSortedArraysI(new int[] { 3, 5, 7, 10, 15 }, new int[] { 2, 4, 12 }));
		System.out.println(findMedianSortedArraysII(new int[] { 1,2,3 }, new int[] { 4,5,6 }));
	}

	// O(m+n) time + O(m+n) space
	public static double findMedianSortedArraysI(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length, l = 0, r = 0, k = 0, cnt = 0;
		int[] res = new int[m + n];
		if (m < n) {
			int[] temp = nums1;
			nums2=nums1;
			nums1=temp;
		}
		for (int i = 0; i < m; i++) {
			cnt++;
			while (r < n && nums2[r] <= nums1[i]) {
				cnt++;
				res[k++] = nums2[r++];
			}
			res[k++] = nums1[i];
		}
		if (n != 0 && r != n) {
			while (r != n) {
				cnt++;
				res[k++] = nums2[r++];
			}
		}
		System.out.println("It ran for " + cnt + " loops");
		return (m + n) % 2 == 0 ? (res[(m + n - 1) / 2] + res[(m + n + 1) / 2]) / 2.0 : res[(m + n) / 2];

	}
	
	// O(log(m+n)) time and O(1) space
	public static double findMedianSortedArraysII(int[] nums1, int[] nums2) {
        //E for element; M1 for minus 1th
        int m=0, n=0, totalE=0, aLeft=0, bLeft=0, aLow=0, aHigh=0, cnt=0;
        int aLeftE=0, bLeftE=0, aLeftM1E=0, bLeftM1E=0;
        
        m=nums1.length;
        n=nums2.length;
        totalE = m+n;
        
        if(m>n){
            int[] temp = nums2;
            nums2=nums1;
            nums1=temp;
        }
        
        m=nums1.length;
        n=nums2.length;
        aHigh = m; 
        
        while(aLow<=aHigh){
        	cnt++;
            aLeft = (aLow+aHigh)/2;
            bLeft = (totalE+1)/2 - aLeft;
            
            aLeftM1E = (aLeft==0) ? Integer.MIN_VALUE : nums1[aLeft-1];
            aLeftE = (aLeft==m)?Integer.MAX_VALUE : nums1[aLeft];
            bLeftM1E = (bLeft==0)? Integer.MIN_VALUE : nums2[bLeft-1];
            bLeftE = (bLeft==n)?Integer.MAX_VALUE : nums2[bLeft];
            
            //Valid segregation
            if(aLeftM1E<=bLeftE && bLeftM1E<=aLeftE){
                if(totalE%2==0){
                	System.out.println("It ran for " + cnt + " loops");
                    return (Math.max(aLeftM1E,bLeftM1E) + Math.min(aLeftE,bLeftE))/2.0;
                }
                else{
                	System.out.println("It ran for " + cnt + " loops");
                    return Math.max(aLeftM1E,bLeftM1E);
                }
            }
            else if(aLeftM1E>bLeftE){
                aHigh = aLeft-1;
            }
            else if(bLeftM1E>aLeftE){
                aLow = aLeft+1;
            } 
        }
         return -1.0;       
    }

}
