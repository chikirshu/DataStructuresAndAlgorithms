package com.ck.strings.easy;

// LC - 1108 : Defanging an IP address
public class DefangeIPAddress {

	public static void main(String[] args) {
		System.out.println(defangIPaddr("255.100.50.0"));
	}
	public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

}
