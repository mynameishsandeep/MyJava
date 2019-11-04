package com.interview.leetcode.uber.medium;

import java.util.Random;
import java.util.TreeMap;

/*
 * https://leetcode.com/problems/random-pick-with-weight/description/
 *
======Understanding Problem==========
1) For the given input "one time", multiple time a method pick is called.
2) In pick method generate random number between count(sum) of all numbers.
3) Get the value equal or greater than the random generated number.
======Understanding Input============
From leetcodeInput : [[[1]],[]]
0
1 time 0

From leetcodeInput : [[[1,3]],[],[],[],[],[]]
0 1 1 1
1 time 0, three times 1

[2,5,3 4] --> this input represented as below
0 0 1 1 1 1 1 2 2 2 3 3 3 3
2 times 0, 5 times 1, 3 times 2, 4 times 3
=================Solution============================
1) I can save data in de-normalized way and return random value directly.
Ex: input [[[1,3]],[],[],[],[],[]]
de-normalized input: 0 1 1 1
map(TreeMap not required) will save like ->{1:0, 2:1, 3:1, 4:1}
2) So if random generates 3 i can directly take value of key 3.
3) But it takes lot of space, that is why we are going saving normalized/compressed
    ========Data Save Part Normalized========
Ex: if input is [1,2,3]

count = 1,
count = 1+2 = 3
count = 3+3 = 6

map will save like ->{1:0, 3:1, 6:2}
	=======Pick Index========
Generate random number between 1 and 6...
Say if random=4, it should return 2, because ceiling(4)=6 in our map, whose corresponding value is 2.
Random Number Generated is 1 ceiling key is 1 and result is 0
Random Number Generated is 2 ceiling key is 3 and result is 1
Random Number Generated is 5 ceiling key is 6 and result is 2
====================================
 */
public class RandomPickWithWeight {
  int count = 0;
  TreeMap<Integer, Integer> map = new TreeMap<>();
  Random rnd = new Random();

  public RandomPickWithWeight(int[] w) {
    for (int i = 0; i < w.length; i++) {
      count += w[i];
      map.put(count, i);
    }
  }

  public int pickIndex() {
    int random = rnd.nextInt(count) + 1; // if count=6 number will between 1 and 6
    return map.ceilingEntry(random).getValue();
  }

  // Check MapCeilFloorHigherLower to see ceilingEntry vs higherEntry difference
  public int pickIndexAlternate() { // if count=6 number will between 0 and 5
    int random = rnd.nextInt(count);
    return map.higherEntry(random).getValue();
  }
}
