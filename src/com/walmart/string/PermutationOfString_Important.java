package com.walmart.string;

/**
 * Tree Flow image is inside "US Problems" folder "Permutations_Important.JPEG"
 */
public class PermutationOfString_Important {

	public static void main(String[] args) {
		String permute = "123";
		permutation("", permute);
	}

	private static void permutation(String prefix, String str) {
		if (0 == str.length()) {
			System.out.println(prefix);
			return;
		}

		for (int i = 0; i < str.length(); i++) {
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length()));
		}

	}

}
