package com.sample.basics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * https://stackoverflow.com/questions/7822577/java-regex-validating-special-chars
 * 
 * A Matcher is created on on a precompiled regexp, 
 * while String.matches must recompile the regexp every time it executes, 
 * so it becomes more wasteful the more often you run that line of code.
 */
public class StringMatchesVSPatternMatches {

	// Faster
	public static boolean testPatternMatcherMethod(String input) {
		// Special Character Match
		String REGEX = "^[^&%$#@!~]*";
		Pattern pattern = Pattern.compile(REGEX);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

	public static void main(String[] args) {
		print(testStringMatchesMethod("jhgjhgjh.#"));
		print(testStringMatchesMethod("jhgjhgjh"));
		print(testPatternMatcherMethod("jhgjhgjh.#"));
		print(testPatternMatcherMethod("jhgjhgjh"));

	}

	public static void print(boolean good) {
		if (good) {
			System.out.println("Good String without Special Character");
		} else {
			System.out.println("Bad String. It has Special Character");
		}
	}

	// Slower
	public static boolean testStringMatchesMethod(String input) {
		// Special Character Match
		String REGEX = "^[^&%$#@!~]*";
		return input.matches(REGEX);
	}
}
