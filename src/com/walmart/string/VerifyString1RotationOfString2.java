package com.walmart.string;

/**
 * Any strings that differ in size -> False.
 * 
 * Add s1 = s1+s1;
 * Loop will go for s2 size. Check for substring operation.
 *  
 */
public class VerifyString1RotationOfString2 {

	public static void main(String[] args) {
		String s1 = "barbazfoo";
		String s2 = "foobarbaz";

		System.out.println(verifyString1RotationOfString2(s1, s2));
	}

	public static boolean verifyString1RotationOfString2(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		s1 = s1 + s1;
		for (int i = 0, j = 0; i < s2.length(); i++) {
			if (s1.charAt(i) == s2.charAt(j)) {
				if (s2.equals(s1.substring(i, i + s2.length()))) {
					return true;
				}
			}
		}
		return false;
	}
}
