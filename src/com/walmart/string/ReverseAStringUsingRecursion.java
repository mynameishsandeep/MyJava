package com.walmart.string;

/**
 * http://stackoverflow.com/questions/9723912/reversing-a-string-with-recursion-in-java
 */
public class ReverseAStringUsingRecursion {

	static char output[];
	public static void main(String[] args) {
		String s = "hello";
		System.out.println(reverse(s));
	}
	
	public static String reverse(String str) {
		
		if (str.length() == 1) {
	        return str;
	    }
	    return reverse(str.substring(1)) + str.charAt(0);
	}

}
