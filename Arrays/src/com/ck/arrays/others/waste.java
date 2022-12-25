package com.ck.arrays.others;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class waste {

	public static void main(String[] args) throws IOException {

		int[] num = new int[1000];
		String[] strNums;
		//Scanner sc = new Scanner(System.in);
		//String[] nums = sc.next().split(" ");

		// Source StackOverflow: BufferedReader is faster then Scanner:
		// Using BufferedReader and then splitting and parsing each integer value is
		// much faster
		// than using nextInt() method of Scanner

		/*BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		strNums = bi.readLine().split("\\s");
		for(int i=0;i<strNums.length;i++) {
			num[i] = Integer.parseInt(strNums[i]);
			System.out.println(num[i]);
		}*/
		
		/*************************/
		
		/*int t=0;
		
		BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(bi.readLine());
		for(int i=0;i<t;i++){
		    String[] str = bi.readLine().split("\\s");
		    int u = Integer.parseInt(str[0]);
		    double v = Double.parseDouble(str[1]);
		    int a = Integer.parseInt(str[2]);
		    int s = Integer.parseInt(str[3]);
		    double res = 0;
		    if(u==v){
		        System.out.println("Yes");
		        continue;
		    }
		    if(u>v){
		        res = Math.sqrt(u*u - 2*a*s);
		    }
		    else{
		        res = Math.sqrt(u*u + 2*a*s);
		    }
		    if(res>v){
		        System.out.println("No");
		    }
		    else{
		        System.out.println("Yes");
		    }
		}
		*/
		/*************************/
		
		int[] arr = new int[3];
		arr[0] = 12;
		arr[1] = 10;
		arr[2] = 15;
		
		//this code inside your method
		int[] res = new int[arr.length];
		int k=0;
		int sum=0;
		
		for(int i=0;i<arr.length;i++) {
			for(int j = 1; j<=arr[i]; j++) {
				if(arr[i]%j == 0) {
					//res[k] = j;
					//k++;
					sum+=j;
				}
			}
			res[k] = sum;
			sum=0;
			k++;
		}
		//return res;
		//System.out.println(res);
		for(int i=0;i<res.length;i++) {
			System.out.print(res[i]+ " ");
		}
		
		
	}

}
