package com.interview.leetcode.facebook.easy;

/*
* https://leetcode.com/problems/verifying-an-alien-dictionary/
*===========Note======================================
*1) If there are 2 word in input. Compare word1 and word
*2) for 3 words. compare 1 &2, then 2&3....
*=====================================
*  1) On comparing 2 word, word1 first character should be lower than word2 first character.
*  If it is satisfied. We can move on compare 2nd and 3rd word.
   2) If word1 first character equals word2 first character. Then comparism continues for
   2nd character in word1 and word2.
   3) If word1 first character greater than word2 first character return false
   =========Corner Case============
   1) If wor1 and word2 are equal to certain index and word2 is finished then return false.
   Note: this doesn't mean word2 size should be greater than or equal to word1.
   Ex: (Consider a-z dictionary)
   "apple" "app" ==> false... because till app both same, then nothing to match in word2
   "apple" "apq" ==> true
   "apple" "aq" ==> true
   "a" "" ==> false

*/
public class VerifyingAnAlienDictionary {

  public boolean isAlienSortedAvoidMap(String[] words, String order) {
    for (int i = 1; i < words.length; i++) {
      String first = words[i - 1];
      String second = words[i];
      for (int j = 0; j < first.length(); j++) {
        int firstCharPosition = order.indexOf(first.charAt(j));
        if (j == second.length()) return false;
        int secondCharPosition = order.indexOf(second.charAt(j));
        if (firstCharPosition > secondCharPosition) return false;
        if (firstCharPosition < secondCharPosition) break;
      }
    }
    return true;
  }
}
