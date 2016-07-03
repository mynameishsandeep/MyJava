package com.sample.basics;

import java.util.Scanner;

public class ReverseAString {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			String input = scan.next();

			if (isPali(input)) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}

	public static boolean isPalindrome(String str) {
		return str.equals(new StringBuilder(str).reverse().toString());
	}
	
	public static boolean isPali(String str) {
		String reverseString = "";
		for(int i=str.length(); i>0; i--) {
			reverseString = reverseString + str.substring(i-1, i);
		}
		return reverseString.compareTo(str)==0?true:false;
	}

}
