package com.interview.leetcode.google.medium;

/*
* https://leetcode.com/problems/permutation-sequence/
*
1) A naive way of finding the kth permutation will be to find all
permutations and then return the kth permutation.
2) Another way to say this is to maintain a running count of permutations
seen so far and return once the kth permutation is reached.
3)https://www.educative.io/collection/page/5642554087309312/5679846214598656/140001


*/
public class KthPermutationSequence {
  public String getPermutation(int n, int k) {
    StringBuilder s = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      s.append(i);
    }
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int fact = getFactorial(n - i - 1);
      int block = (k - 1) / fact;
      result.append(s.charAt(block));
      s.deleteCharAt(block);
      k = k - (block * fact);
    }
    return result.toString();
  }

  private int getFactorial(int n) {
    if (n == 0) {
      return 1;
    }
    return n * getFactorial(n - 1);
  }

  public static void main(String[] args) {
    KthPermutationSequence k = new KthPermutationSequence();
    System.out.println(k.getPermutation(4, 8));
  }
}
