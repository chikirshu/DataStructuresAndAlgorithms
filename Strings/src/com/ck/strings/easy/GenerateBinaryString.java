package com.ck.strings.easy;

import java.util.ArrayList;
import java.util.List;

// GFG - Generate Binary String
public class GenerateBinaryString {

	public static void main(String[] args) {
		String s = "1??0?101";
		System.out.println(generate_binary_string(s));
		
	}
	private static List<String>generate_binary_string(String s)
    {
        List<String> list = new ArrayList<>();
        char[] c = s.toCharArray();
        generateString(c,0, list);
        return list;
    }
    private static void generateString(char[] c, int idx, List<String> list){
        if(idx == c.length){
            list.add(new String(c));
            return;
        }
        
        if(c[idx]=='?'){
            c[idx] = '0';
            generateString(c,idx+1,list);
            
            c[idx] = '1';
            generateString(c,idx+1,list);
            
            //backtracking - coz of string will be pass by reference
            c[idx] = '?';
        }
        else{
            generateString(c,idx+1,list);
        }
    }

}
