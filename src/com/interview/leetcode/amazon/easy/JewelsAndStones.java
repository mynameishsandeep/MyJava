package com.interview.leetcode.amazon.easy;

import java.util.HashMap;
import java.util.Map;
/** https://leetcode.com/problems/jewels-and-stones/description/ */
public class JewelsAndStones {
  public static int numJewelsInStones(String J, String S) {
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : S.toCharArray()) {
      Integer prevValue = null;
      if (null != (prevValue = map.put(c, 1))) {
        map.put(c, prevValue + 1);
      }
    }
    Integer result = 0;
    for (Character c : J.toCharArray()) {
      Integer value = map.get(c);
      if (null != value) {
        result += value;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(numJewelsInStones("z", "ZZ"));
  }
}
