package com.walmart.string;

import java.util.Collections;
import java.util.List;

/*
 * Swap using Character array
 * 
 * Based on Book... Elements of Programming Interviews Tree Flow image is inside "US Problems"
 * folder "Permutations.JPG"
 */
public class PermutationOfString_Recursion {

  public void permutationNew(List<Character> input, List<String> result, Integer currentIndex) {
    if (currentIndex == input.size() - 1) {
      StringBuilder builder = new StringBuilder(input.size());
      for (Character ch : input) {
        builder.append(ch);
      }
      result.add(builder.toString());
      return;
    }
    for (int i = currentIndex; i < input.size(); i++) {
      Collections.swap(input, currentIndex, i);
      permutationNew(input, result, currentIndex + 1);
      Collections.swap(input, currentIndex, i);
    }
  }
}
