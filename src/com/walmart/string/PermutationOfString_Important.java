package com.walmart.string;

/**
 * Tree Flow image is inside "US Problems" folder "Permutations_Important.JPEG"
 */
public class PermutationOfString_Important {

	public static void main(String[] args) {
		String permute = "AAB";
		permutation("", permute);
	}

	private static void permutation(String prefix, String suffix) {
		if (0 == suffix.length()) {
			System.out.println(prefix);
			return;
		}

		for (int i = 0; i < suffix.length(); i++) {
			permutation(prefix + suffix.charAt(i),
					suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()));
		}

	}

}
