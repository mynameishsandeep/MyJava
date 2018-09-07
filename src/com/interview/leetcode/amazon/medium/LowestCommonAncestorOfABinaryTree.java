package com.interview.leetcode.amazon.medium;

/*
 * 
Approach1: (Using 2 Traversal. By Storing root to n1 and root to n2 paths):
==========
Following is simple O(n) algorithm to find LCA of n1 and n2.
1) Find path from root to n1 and store it in a list.
2) Find path from root to n2 and store it in another list.
3) Traverse both paths till the values in arrays are same. Return the common element just before the mismatch.

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
 */

public class LowestCommonAncestorOfABinaryTree {
	public TreeNode lowestCommonAncestor_Approach2(TreeNode root, TreeNode p, TreeNode q) {
		// Base case
		if (root == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (root == p || root == q)
			return root;

		// Look for keys in left and right subtrees
		TreeNode leftLCA = lowestCommonAncestor_Approach2(root.left, p, q);
		TreeNode rightLCA = lowestCommonAncestor_Approach2(root.right, p, q);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this node is the LCA
		if (leftLCA != null && rightLCA != null) {
			return root;
		} else {
			// Otherwise check if left subtree or right subtree is LCA
			return (leftLCA != null) ? leftLCA : rightLCA;
		}
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
	}
}
