package com.walmart.string;

public class ReverseAStringRecursion {
	public static void main(String[] args) {
		System.out.println(reverse("taste"));
		System.out.println(reverse(""));
		System.out.println(reverse(null));
	}
	
	/*
	 * taste
	 * aste + t = etsat
	 * ste + a = etsa
	 * te + s = ets
	 * e + t = et
	 */
	public static String reverse(String input) {
		if(null==input || input.length()==0) {
			return "";
		}
		return reverse(input.substring(1,input.length())) + input.charAt(0);
		// Below will print the result in same order...
		// input.charAt(0) + return reverse(input.substring(1,input.length()));
	}
}
