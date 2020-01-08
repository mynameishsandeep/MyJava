package com.sample.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/validate-binary-search-tree/description/

================BST Definition==================
The left subtree of a node contains only nodes with keys less than the node's(all parents) key.
The right subtree of a node contains only nodes with keys greater than the node's(all parents) key.

Below input might look like valid BST. But it is not. Because 6 cannot to right at any-point.

Input:[10,5,15,null,null,12,20,6,13]
Output: false.
					10
				5         15
			  n   n     12  20
			           6  13

low      mid      high
=======================
-∞   ||  10   ||    ∞
-∞   ||  5    ||    10
10   ||  15   ||    ∞
10   ||  12   ||    15
10   ||  6    ||    12   ==============> logic fails here
12   ||  13   ||    15
15   ||  20   ||    ∞
==============================================================
 * Solution 1) BruteForce
 * 		a) Do In-Order Traversal of the given tree and store the result in a temp array.
 * 		b) Check if the temp array is sorted in ascending order, if it is, then the tree is BST.
 * 		Time Complexity: O(n) Space Complexity: O(n)
 *
 * Solution 2)
 * 		1) Consider 3 node.... 2 1 3 --> 2 is root, 1 is left and 3 is right
 * 		2) At any point left is smaller and right is greater.
 * 		3) Set low and high...
 * 		4) Then Validate ---> node lies between ---> low and high...
 * 		5) For root --> low,  root,      high    --> 	-∞, 2, ∞
 * 		6) For left --> low,  root.left, root   --> 	-∞, 1, 2
 * 		7) For right--> root, roo.right, high    -->	  	 2, 3, ∞
 * 		8) At any point if "current value" is "less than or equal to low" or greater than or equal to high" return false.
 * 		9) if reached end, return true.
 * 		10) result = left && right ==note here===
 *
 * 		Time Complexity: O(n) Space Complexity: O(1)
 *
 */
public class ValidBST {

  public boolean isValidBST(TreeNode root) {
    long high = Long.MAX_VALUE;
    long low = Long.MIN_VALUE;
    return isValid(low, root, high);
  }

  private boolean isValid(long low, TreeNode mid, long high) {
    if (mid == null) return true;
    if (low < mid.val && mid.val < high) {
      boolean left = isValid(low, mid.left, mid.val);
      boolean right = isValid(mid.val, mid.right, high);
      return left && right;
    }
    return false;
  }

  public boolean isValidBST1(TreeNode root) {
    Queue<Object[]> q = new LinkedList<>();
    if (root != null) q.offer(new Object[] {Long.MIN_VALUE, root, Long.MAX_VALUE});
    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Object[] objectNode = q.poll();
        Long low = Long.valueOf(objectNode[0] + "");
        TreeNode mid = (TreeNode) objectNode[1];
        Long high = Long.valueOf(objectNode[2] + "");
        if (low >= mid.val || mid.val >= high) return false;
        if (mid.left != null) q.offer(new Object[] {low, mid.left, mid.val});
        if (mid.right != null) q.offer(new Object[] {mid.val, mid.right, high});
      }
    }
    return true;
  }
}
