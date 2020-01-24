package com.sample.tricky;

import java.util.HashMap;

/*
 * 1) Parse from last
 * 2) if lastButPreviousNumber is greater than or equal to lastNumber. add it to result. else subtract from result.
 */
public class RomanToInteger {

  HashMap<Character, Integer> map = new HashMap<>();

  private void initMap() {
    map.put('I', 1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
  }

  public int romanToInt(String s) {
    initMap();
    Integer result = map.get(s.charAt(s.length() - 1));
    for (int i = s.length() - 1; i > 0; i--) {
      Integer lastNumber = map.get(s.charAt(i));
      Integer lastButPreviousNumber = map.get(s.charAt(i - 1));
      if (lastButPreviousNumber >= lastNumber) result += lastButPreviousNumber;
      else result -= lastButPreviousNumber;
    }
    return result;
  }
}
