package com.interview.leetcode.facebook.medium;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/construct-binary-tree-from-string/
 *
 * 1) Read the current number by currentIndex.
 * 2) Create the TreeNode for the current number.
 * 3) if currentIndex not reached max && current value is "(".
 *  increase currentIndex and build left.
 * 4) Once the left ends, build right, if currentIndex not reached max && current value is "("
 * 5) increase current index for ")"  
 *
 * 1(2(22))(3(33))
 * 					1
 * 				2		3
 * 			22		  33
 *
 *
 */
public class ConstructBinaryTreeFromString {
  int currentIndex;
  int currentNumber;

  public TreeNode str2tree(String s) {
    if (s == null || s.isEmpty()) return null;
    currentIndex = 0;
    return build(s);
  }

  private TreeNode build(String input) {
    setCurrentNumber(input);
    TreeNode root = new TreeNode(currentNumber);
    if (currentIndex < input.length() && input.charAt(currentIndex) == '(') {
      currentIndex++;
      root.left = build(input);
      if (currentIndex < input.length() && input.charAt(currentIndex) == '(') {
        currentIndex++;
        root.right = build(input);
      }
    }
    currentIndex++; // For the ")" just increase index
    return root;
  }

  private void setCurrentNumber(String input) {
    int nextIndex = currentIndex + 1;
    while (nextIndex < input.length() && Character.isDigit(input.charAt(nextIndex))) nextIndex++;
    currentNumber = Integer.valueOf(input.substring(currentIndex, nextIndex));
    currentIndex = nextIndex;
  }
}
