package com.walmart.string;

import java.util.List;

/**
 * " Picture is in US Problems folder "Permutations.jpg"
 *
 * <p>Swap using StringBuilder
 */
public class PermutationOfString_Recursion1 {

  public void permutation(String input, List<String> result, Integer currentIndex) {
    if (currentIndex == input.length() - 1) {
      result.add(input);
      return;
    }
    for (int i = currentIndex; i < input.length(); i++) {
      System.out.println(input);
      input = swap(input, currentIndex, i);
      permutation(input, result, currentIndex + 1);
      input = swap(input, currentIndex, i);
    }
  }

  private String swap(final String input, final int index1, final int index2) {
    if (index1 == index2) return input;
    StringBuilder s = new StringBuilder(input);
    s.setCharAt(index1, input.charAt(index2));
    s.setCharAt(index2, input.charAt(index1));
    return s.toString();
  }
}
