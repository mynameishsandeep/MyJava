package com.sample.basics;

public class RegExNumberMatch {
	public static void main(String[] args) {
		System.out.println(numberMatches("123A"));
		System.out.println(numberMatches("123"));
		
		System.out.println(numberMatchesWith3Size("1234"));
		System.out.println(numberMatchesWith3Size("123"));
		
		System.out.println(hexaDecimalNumberMatches("123A"));
		System.out.println(hexaDecimalNumberMatches("123AF"));
		System.out.println(hexaDecimalNumberMatches("123AG"));
		
		System.out.println(numberMatchesOnly1And2("12"));
		
	}
	
	public static boolean numberMatches(String input) {
		String regex = "[0-9]+";
		return input.matches(regex);
	}
	
	public static boolean numberMatchesOnly1And2(String input) {
		String regex = "[1,2]+";
		return input.matches(regex);
	}

	public static boolean numberMatchesWith3Size(String input) {
		String regex = "[0-9]{1,3}";
		return input.matches(regex);
	}
	public static boolean hexaDecimalNumberMatches(String input) {
		String regex = "[0-9A-F]+";
		return input.matches(regex);
	}

}
