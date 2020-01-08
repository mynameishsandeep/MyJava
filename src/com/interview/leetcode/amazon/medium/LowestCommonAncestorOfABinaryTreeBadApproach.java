package com.interview.leetcode.amazon.medium;

import java.util.Iterator;
import java.util.LinkedList;

import com.interview.leetcode.TreeNode;

/*
				           1
				      2        3
				    4   5    6   7
Approach1: (Using 2 Traversal. By Storing root to n1 and root to n2 paths):
==========
Ex: LCA of 5 and 7 is 1. Following is simple O(n) algorithm to find LCA of n1 and n2.
1) Find path from root to n1(5) and store it in a list1. Ex: 1 2 5
2) Find path from root to n2(7) and store it in another list2. 1 3 7
3) Iterate from top to bottom of both list, keep update result from top to bottom.
	Ex: For above input p1=4 and p2=5
		list1 = [1,2,4]
		list2 = [1,2,5]
		Initially result is 1 then result is 2 after 2 loop breaks. So 2 is returned.


Time Complexity: Time complexity of the above solution is O(n). The tree is traversed twice, and then path arrays are compared.

 */

public class LowestCommonAncestorOfABinaryTreeBadApproach {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    LinkedList<TreeNode> pPath = new LinkedList<>();
    LinkedList<TreeNode> qPath = new LinkedList<>();
    findPath(root, p, pPath);
    findPath(root, q, qPath);
    Iterator<TreeNode> itrP = pPath.iterator();
    Iterator<TreeNode> itrQ = qPath.iterator();
    TreeNode res = null;
    while (itrP.hasNext() && itrQ.hasNext()) {
      p = itrP.next();
      q = itrQ.next();
      if (p == q) res = p;
      else break;
    }
    return res;
  }

  private boolean findPath(TreeNode root, TreeNode target, LinkedList<TreeNode> path) {
    if (root == null) return false;
    path.add(root);
    if (root == target) return true;
    boolean left = findPath(root.left, target, path);
    boolean right = findPath(root.right, target, path);
    if (!left && !right) {
      path.removeLast();
      return false;
    }
    return true;
  }
}
