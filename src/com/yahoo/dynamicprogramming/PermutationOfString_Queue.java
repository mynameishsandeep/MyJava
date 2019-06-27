package com.yahoo.dynamicprogramming;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * Similar to LetterCombinationOfPhoneNumber_Permutation
 * 
 */
public class PermutationOfString_Queue {

  public void permuteStringDp(String input) {
    Queue<String> q = new LinkedList<>();
    q.add(input.charAt(0) + "");
    for (int i = 1; i < input.length(); i++) {
      System.out.println(q);
      int size = q.size();
      for (int j = 0; j < size; j++) {
        String data = q.poll();
        for (int k = 0; k < data.length() + 1; k++) {
          q.offer(addCharAtPostion(data, input.charAt(i), k));
        }
      }
    }
    System.out.println(q);
  }

  private String addCharAtPostion(String x, Character c, Integer pos) {
    StringBuilder s = new StringBuilder(x);
    s.insert(pos, c + "");
    return s.toString();
  }
}
