package com.sample.basics;

public class PalindromeNumbers {

	public static void main(String[] args) {

		int data = 121;
		int pali = data;
		int remainder = 0;
		int result = 0;
		while(pali != 0) {
			remainder = pali % 10; 					// 1  2
			result = result * 10 + remainder;		// 1  12
			pali = pali / 10;						// 12
		}

		System.out.println(result);
		System.out.println(data);
		System.out.println(result==data);
		System.out.println(reverse(data));
	}
	
	public static boolean reverse(int number) {
		int reverseNumber = Integer.reverse(number);
		return number == reverseNumber;
	}

}
