package com.walmart.string;

import java.util.ArrayList;
import java.util.List;

/**
 * For example, suppose we go to an ice cream shop that offers 15 flavors. If we
 * want to layer 3 scoops of different flavors on an ice cream cone, how many
 * arrangements are possible?
 * 
 * 15×14×13=2730
 * 
 * https://www.ck12.org/book/CK-12-Algebra-II-with-Trigonometry-Concepts/section/12.4/
 * 
 * @author chandrasekhar
 *
 */
public class PermutationOfStringComplex {

	public static void permuteStringDp(String input, Integer combo) {
		List<String> result = new ArrayList<>();
		result.add(input.charAt(0) + "");
		for (int l = 0; l <= input.length() - combo; l++) {
			for (int i = l + 1; i <= combo; i++) {
				List<String> temp = new ArrayList<>();
				for (int j = 0; j < result.size(); j++) {
					String data = result.get(j);
					for (int k = 0; k < data.length() + 1; k++) {
						temp.add(addCharAtPostion(data, input.charAt(i), k));
					}
				}
				result = temp;
			}
			System.out.println(result);
		}
	}

	private static String addCharAtPostion(String x, Character c, Integer pos) {
		return x.substring(0, pos) + c + x.substring(pos, x.length());
	}

	public static void main(String args[]) {
		String permute = "abc";
		permuteStringDp(permute, 2);
	}

}
