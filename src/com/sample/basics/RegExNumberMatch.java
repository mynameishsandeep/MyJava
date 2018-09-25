package com.sample.basics;

public class RegExNumberMatch {
	public static void main(String[] args) {
		System.out.println(numberMatches("123A"));
		System.out.println(numberMatches("123"));
		
		System.out.println(numberMatchesWith3Number("1234"));
		System.out.println(numberMatchesWith3Number("123"));
		
		System.out.println(hexaDecimalNumberMatches("123A"));
		System.out.println(hexaDecimalNumberMatches("123AF"));
		System.out.println(hexaDecimalNumberMatches("123AG"));
		
	}
	
	public static boolean numberMatches(String input) {
		String regex = "[0-9]+";
		return input.matches(regex);
	}
	
	public static boolean numberMatchesWith3Number(String input) {
		String regex = "[0-9]{1,3}";
		return input.matches(regex);
	}
	public static boolean hexaDecimalNumberMatches(String input) {
		String regex = "[0-9A-F]+";
		return input.matches(regex);
	}

}
