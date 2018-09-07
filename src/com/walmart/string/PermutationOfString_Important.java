package com.walmart.string;

/**
 * Tree Flow image is inside "US Problems" folder "Permutations_Important.JPEG"
 * 
 * 1) prefix(empty), suffix(input)
 * 2) formula = prefix+suffixCharAt(i) , suffix(0,i)+suffix(i+1,suffixLength);
 * 3) Run the above formula breath-wise(for loop) and depth-wise(Recursion)
 */
public class PermutationOfString_Important {

	public static void main(String[] args) {
		String permute = "123";
		permutation("", permute);
	}

	private static void permutation(String prefix, String suffix) {
		if (1 == suffix.length()) {
			System.out.println(prefix + suffix);
			return;
		}
		// for loop is about breath wise, based on the size of input string. 
		for (int i = 0; i < suffix.length(); i++) {
			// recursion is about depth wise, based on size of input string -1.
			permutation(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()));
		}
	}

}
