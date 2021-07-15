package com.ck.arrays.easy;

import java.util.Stack;

// 941 : Valid Mountain Array 
public class ValidMountainArray {

	public static void main(String[] args) {
		int[] arr = new int[] {-0,3,2,1};
		System.out.println(validMountainArrayONSpace(arr));
		System.out.println(validMountainArrayOOneSpace(arr));
	}
	
	public static boolean validMountainArrayONSpace(int[] arr) {
        boolean flgInc = false;
        boolean flgDec = false;
        
        if(arr.length<3) return false;
        
        Stack<Integer> stk = new Stack<>();
        stk.push(arr[0]);
        
        for(int i=1;i<arr.length;i++){
            if(stk.peek()<arr[i] && !flgDec){
                flgInc = true;
                stk.pop();
            }
            else if(stk.peek()>arr[i] && !flgDec && flgInc){
                flgDec=true;
                stk.pop();
            }
            else if(stk.peek()>arr[i] && flgDec){
                stk.pop();
            }
            stk.push(arr[i]);
        }
        
        return stk.size()==1 && flgDec?true:false;
    }
	
	public static boolean validMountainArrayOOneSpace(int[] arr) {
        int i=0;
        int N = arr.length;
        while(i<N-1 && arr[i]<arr[i+1]){
            i++;
        }
        if(i==0 || i==N-1){
            return false;
        }
        while(i<N-1 && arr[i]>arr[i+1]){
            i++;
        }
        
        return i==N-1;
    }

}
