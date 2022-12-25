package com.ck.ss.easy;

// LC - 704 : Binary Search
// https://leetcode.com/problems/binary-search/
// LC - 278 : First Bad Version
// https://leetcode.com/problems/first-bad-version/
public class BinarySearch {
	public static void main(String[] args) {
		System.out.println(searchInSorted(new int[] { 1, 2, 3, 4, 6 }, 5, 2));
	}

	public static int searchInSorted(int arr[], int N, int K) {
		// Your code here
		int low = 0, mid = 0, high = N - 1;
		// <= rakho humesha for simplicity ; if taking just < then return either low or high (index) and not mid. 
		// Refer the LC 278(Solution below for reference)
		while (low <= high) {
			// it is done like this to cover the case where low + high is greater
			// than 2^31-1
			mid = low + (high - low) / 2;
			if (K == arr[mid])
				return 1;
			else if (K > arr[mid]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
	
	public int firstBadVersion(int n) {
        int low=1, high=n, mid=1;
        
        while(low<high){
            mid=low+(high-low)/2;
            if(isBadVersion(mid)){
                high=mid;
            }
            else{
                low=mid+1;
            }
        }
        // Cannot return mid as mid may have old value, we are moving out of the above loop only when  low==high. 
        // Therefore return low or high and not mid.
        return low;
    }
	
	public boolean isBadVersion(int i) {
		if(i >= 3) {
			return true; 
		}
		return false;
	}
}
