package com.interview.leetcode.amazon.medium;

import com.interview.leetcode.TreeNode;

/*
				           1
				      2        3
				    4   5    6   7
Best Approach: (Using Single Traversal)
==========
If we assume that the keys n1 and n2 are always present in Binary Tree, we can find LCA using single traversal of
Binary Tree and without extra storage for path arrays.
1) Traverse(post order) the tree starting from root.
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

public class LowestCommonAncestorOfABinaryTreeOrLCA {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    // If either "p" or "q" matches with root's key, report the presence by returning root
    if (root == p || root == q) return root;
    TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
    TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
    // If both of the above calls return Non-NULL, then one key is present in left subtree and other
    // is present in right subtree, So root node is the LCA
    if (leftLCA != null && rightLCA != null) return root;
    // Otherwise check if left subtree or right subtree is LCA
    return (leftLCA != null) ? leftLCA : rightLCA;
  }
}
