package com.walmart.string;

public class ReverseAStringUsingRecursion {

	static char output[];
	public static void main(String[] args) {
		String s = "hello";
		System.out.println(reverse(s));
	}
	
	public static String reverse(String str) {
		
		if ((null == str) || (str.length() <= 1)) {
	        return str;
	    }
	    str = reverse(str.substring(1)) + str.charAt(0);
	    return str;
	}

}
