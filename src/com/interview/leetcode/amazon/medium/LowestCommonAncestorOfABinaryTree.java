package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.TreeNode;

/*
				           1
				      2        3
				    4   5    6   7
Approach1: (Using 2 Traversal. By Storing root to n1 and root to n2 paths):
==========
Ex: LCA of 5 and 7 is 1. Following is simple O(n) algorithm to find LCA of n1 and n2.
1) Find path from root to n1(5) and store it in a list1. Ex: 1 2 (Don't store actual node itself)
2) Find path from root to n2 and store it in another list2. 1 3
3) Traverse from bottom of list2 whether it exists in list1. (list search is nSquare operation. so put it in set)
		So look for 3 in list1, not found
		look for 1 in list1, found and it is the answer.


Time Complexity: Time complexity of the above solution is O(n). The tree is traversed twice, and then path arrays are compared.

Approach2: (Using Single Traversal)
==========
The method 1 finds LCA in O(n) time, but requires three tree traversals plus extra spaces for path arrays.
If we assume that the keys n1 and n2 are always present in Binary Tree, we can find LCA using single traversal of
Binary Tree and without extra storage for path arrays.
1) Traverse the tree starting from root.
2) If any of the given keys (n1 and n2) matches with root, then root is LCA (assuming that both keys are present).
3) If root doesn’t match with any of the keys, we recur for left and right subtree.
4) The node which has one key present in its left subtree and the other key present in right subtree is the LCA.
If both keys lie in left subtree, then left subtree has LCA also, otherwise LCA lies in right subtree.

		Ex1:	1		    Ex2:	1
				  2               2
				    3           3
				      4       4
		For above example. to find LCA of 2 and 4.
		recursion stops at 2. Because left is null and since is 2 is found, 4 must be below (assuming 4 present all time)

 */

public class LowestCommonAncestorOfABinaryTree {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    // Base case
    // If either n1 or n2 matches with root's key, report the presence by returning root (Note that
    // if a key is ancestor of other, then the ancestor key becomes LCA
    if (root == null || root == p || root == q) return root;

    // Look for keys in left and right subtrees
    TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
    TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

    // If both of the above calls return Non-NULL, then one key
    // is present in one subtree and other is present in other,
    // So root node is the LCA
    if (leftLCA != null && rightLCA != null) {
      return root;
    }
    // Otherwise check if left subtree or right subtree is LCA
    return (leftLCA != null) ? leftLCA : rightLCA;
  }
}
