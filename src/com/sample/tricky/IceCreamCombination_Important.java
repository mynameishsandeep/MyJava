package com.sample.tricky;

/**
 * 
 * For the given input, how many ways output can be formed. Ex: I have 5 flavors
 * of IceCream and 3 flavors can be served at a time. Print all the possible
 * combinations
 * 
 * Similar to the problem "PermutationOfString_Important". But permutation happens for a limited size.
 */
public class IceCreamCombination_Important {

	public static void main(String[] args) {
		permute("", "1234", 3);
	}

	public static void permute(String prefix, String remainingString, int n) {
		if (prefix.length() == n) { 
			System.out.println(prefix);
			return;
		}
		for (int i = 0; i < remainingString.length(); i++) {
			permute(prefix + remainingString.charAt(i),
					remainingString.substring(0, i) + remainingString.substring(i + 1, remainingString.length()), n);
		}

	}
}
