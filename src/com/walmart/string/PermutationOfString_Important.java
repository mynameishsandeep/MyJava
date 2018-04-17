package com.walmart.string;

/**
 * Tree Flow image is inside "US Problems" folder "Permutations_Important.JPEG"
 */
public class PermutationOfString_Important {

	public static void main(String[] args) {
		String permute = "123";
		permutation("", permute);
	}

	private static void permutation(String prefix, String remainingString) {
		if (0 == remainingString.length()) {
			System.out.println(prefix);
			return;
		}

		for (int i = 0; i < remainingString.length(); i++) {
			permutation(prefix + remainingString.charAt(i),
					remainingString.substring(0, i) + remainingString.substring(i + 1, remainingString.length()));
		}

	}

}
