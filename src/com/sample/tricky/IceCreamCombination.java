package com.sample.tricky;

/**
 * 
 * @author chandrasekhar
 *
 */
public class IceCreamCombination {

	public static void main(String[] args) {
		permute("","1234",3);
	}

	public static void permute(String chosen, String available, int n) {
		if (chosen.length() == n) {
			System.out.println(chosen);
			return;
		}
		for (int i = 0; i < available.length(); i++) {
			permute(chosen + available.charAt(i),
					available.substring(0, i) + available.substring(i + 1, available.length()), n);
		}

	}
}
