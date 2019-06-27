package com.sample.tricky;

import java.util.HashMap;

/*
 * Ex: If input is "IX"
 * 0) Cache the last number in result i.e(X).
 * 1) Parse from last-1 i.e (I)
 * 2) Get currentNumber and nextNumber
 * 2) if currentNumber is greater than or equal to next number. add it to result. else substrct from result.
 * ========Note============
 * Caching the result at beginning is the trick. Thereafter current number
 * added/substracted based on compare.
 *====================
 */
public class RomanToInteger {
  public static void main(String[] args) {
    System.out.println(romanToInt("III"));
    System.out.println(romanToInt("XIV"));
    System.out.println(romanToInt("IX"));
  }

  public static int romanToInt(String s) {
    if (s == null || s.length() == 0) return -1;
    HashMap<Character, Integer> map = new HashMap<>();
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
    Integer result = map.get(s.charAt(s.length() - 1));
    for (int i = s.length() - 2; i >= 0; i--) {
      Integer currentNumber = map.get(s.charAt(i));
      Integer nextNumber = map.get(s.charAt(i + 1));
      if (currentNumber >= nextNumber) result += currentNumber;
      else result -= currentNumber;
    }
    return result;
  }
}
