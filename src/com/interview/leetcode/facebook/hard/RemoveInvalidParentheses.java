package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/remove-invalid-parentheses/
*
*  1) Permute all the combinations of the parantheses.
*  Count the number of open-parentheses and close-parentheses
*  2) At any point if close-parentheses is more than open-parentheses we can skip that.
*  Ex: "()())" or "(()))" Here 5th character can be ignored
*  Ex: "))))". Here all can by ignored.
*  Ex: "())))(((". Here 3,4,5 can be ignored.
*
*  2) If the end is reached and number of open and closed parentheses is equal. A result is found.
*
*  Hints :
*  1) Since we don't know which of the brackets can possibly be removed, we try out all the options!
*  2) We can use recursion to try out all possibilities for the given expression. For each of the brackets, we have 2 options:
		a) We keep the bracket and add it to the expression that we are building on the fly during recursion.
		b) we can discard the bracket and move on.

================Note==============
Time Complexity : 2^N. As it tries all combination.
The solution is not efficient and it contains duplicate. Duplicate will be removed by list.contains.


*
*/
public class RemoveInvalidParentheses {

  ArrayList<String> result = new ArrayList<>();
  int maxResultSize = 0;

  public List<String> removeInvalidParentheses(String s) {
    if (s == null) return result;
    dfs(s, "", 0, 0);
    if (result.size() == 0) {
      result.add("");
    }

    return result;
  }

  public void dfs(
      String prefix, String suffix, int countOpenParentheses, int countCloseParentheses) {
    // System.out.println(prefix + suffix);
    if (prefix.length() == 0) { // Reached end of string
      if (countOpenParentheses == countCloseParentheses) {
        if (countOpenParentheses + countCloseParentheses
            >= maxResultSize) { // we want multiple result with same size. So >=
          // System.out.println("Found A Result");
          maxResultSize = countOpenParentheses + countCloseParentheses;
          if (!result.contains(suffix)) result.add(suffix);
        }
      }
      return;
    }
    // System.out.println(prefix + suffix);
    if (prefix.charAt(0) == '(') {
      dfs(
          prefix.substring(1),
          suffix + "(",
          countOpenParentheses + 1,
          countCloseParentheses); // keep (
      dfs(prefix.substring(1), suffix, countOpenParentheses, countCloseParentheses); // drop (
    } else if (prefix.charAt(0) == ')') {
      if (countOpenParentheses > countCloseParentheses) { //  "()())" --> skip for this case.
        dfs(prefix.substring(1), suffix + ")", countOpenParentheses, countCloseParentheses + 1);
      }
      dfs(prefix.substring(1), suffix, countOpenParentheses, countCloseParentheses);
    } else { // if(Character.isAlphabetic(prefix.charAt(0))){
      dfs(
          prefix.substring(1),
          suffix + String.valueOf(prefix.charAt(0)),
          countOpenParentheses,
          countCloseParentheses);
    }
  }
}
