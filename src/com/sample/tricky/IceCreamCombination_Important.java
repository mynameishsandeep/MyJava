package com.sample.tricky;

/**
 * 
 * For the given input, how many ways output can be formed. Ex: I have 5 flavors
 * of IceCream and 3 flavors can be served at a time. Print all the possible
 * combinations
 * 
 */
public class IceCreamCombination_Important {

	public static void main(String[] args) {
		permute("", "1234", 3);
	}

	public static void permute(String combo, String input, int n) {
		if (input.equals("")) { // or chosen.length() == n
			System.out.println(combo);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			permute(combo + input.charAt(i),
					input.substring(0, i) + input.substring(i + 1, input.length()), n);
		}

	}
}
