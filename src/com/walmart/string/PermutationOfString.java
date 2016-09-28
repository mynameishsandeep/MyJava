package com.walmart.string;

public class PermutationOfString {

	public static void main(String args[]) {
		String permute = "abc";
		System.out.println("Total Combination is " + factorial(permute.length()));
		permuteString("", permute);
	}

	public static long factorial(long number) {
		if (number <= 1)
			return 1;
		else
			return number * factorial(number - 1);
	}

	public static void permuteString(String beginningString, String endingString) {
		if (endingString.length() <= 1)
			System.out.println(beginningString + endingString);
		else
			for (int i = 0; i < endingString.length(); i++) {
				String newString = endingString.substring(0, i) + endingString.substring(i + 1);
				permuteString(beginningString + endingString.charAt(i), newString);
			}
	}

}