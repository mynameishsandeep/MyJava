package com.sample.tricky;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Flow image is inside "US Problems" folder "LetterCombinationOfPhoneNumber.png"
 *
 * <p>Note: There will be 3 for loops
 */
public class LetterCombinationOfPhoneNumber_Permutation {

  private Map<Character, String> map = new HashMap<>();

  {
    map.put('2', "abc");
    map.put('3', "def");
    map.put('4', "ghi");
    map.put('5', "jkl");
    map.put('6', "mno");
    map.put('7', "pqrs");
    map.put('8', "tuv");
    map.put('9', "wxyz");
  }

  public List<String> letterCombinations(String digits) {
    LinkedList<String> q = new LinkedList<>();
    if (digits.length() == 0) return q;

    q.offer("");

    for (Character digit : digits.toCharArray()) {
      String word = map.get(digit);
      int size = q.size();
      for (int i = 0; i < size; i++) {
        String currentCombo = q.poll();
        for (int j = 0; j < word.length(); j++) {
          q.offer(currentCombo + word.charAt(j));
        }
      }
    }
    return q;
  }

  public static void main(String[] args) {
    LetterCombinationOfPhoneNumber_Permutation l = new LetterCombinationOfPhoneNumber_Permutation();
    System.out.println(l.letterCombinations("23"));
  }
}
