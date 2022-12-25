package com.ck.strings.easy;

import java.util.ArrayList;
import java.util.List;

// 412. Fizz Buzz
// https://leetcode.com/problems/fizz-buzz/
// https://www.youtube.com/watch?v=UYMP-cMy_zg
public class FizzBuzz {

	public static void main(String[] args) {
		System.out.println(fizzBuzzI(15));
		System.out.println(fizzBuzzII(15));
	}
	
	// with modulo
    public static List<String> fizzBuzzII(int n) {
        
        List<String> res = new ArrayList<>();
        String d="";
        for(int i=1;i<=n;i++){
            d="";
            if(i%3==0){
                d+="Fizz";
            }
            if(i%5==0){
                d+="Buzz";
            }
            if(d.equals("")){
                d=String.valueOf(i);
            }
            res.add(d);
        }
        return res;
    }
	
	// without modulo (%)
    public static List<String> fizzBuzzI(int n) {
        
        boolean flg=false;
        int cnt3 = 0, cnt5=0;
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb = new StringBuilder();
            cnt3++;
            cnt5++;
            if(cnt3==3){
                sb.append("Fizz");
                cnt3=0;
            }
            if(cnt5==5){
                sb.append("Buzz");
                cnt5=0;
            }
            if(sb.toString().length()==0){
                sb.append(String.valueOf(i));
            }
            res.add(sb.toString());
        }
        return res;
    }

}
