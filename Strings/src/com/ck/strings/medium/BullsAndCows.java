package com.ck.strings.medium;

public class BullsAndCows {

	public static void main(String[] args) {
		System.out.println(getHint("7801","1870"));
	}
	
	public static String getHint(String secret, String guess) {
		int b=0, c=0;
        int[] arr = new int[10];
        
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                b++;
            }
            else{
                int s = secret.charAt(i)-'0';
                int g = guess.charAt(i)-'0';
                if(arr[s]<0)c++;
                if(arr[g]>0)c++;
                arr[s]++;
                arr[g]--;
            }
        }
        return b+"A"+c+"B";
	}

}
