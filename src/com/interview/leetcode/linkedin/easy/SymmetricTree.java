package com.interview.leetcode.linkedin.easy;

/*
 * https://leetcode.com/problems/symmetric-tree/description/
 * 
 */
public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return dfs(root.left, root.right);
	}

	public boolean dfs(TreeNode left, TreeNode right) {
        if(left==null&&right==null) {
            return true;
        } else if(left==null ||right==null) {
            return false;
        } else if(left.val!=right.val) {
            return false;
        } else {
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
    }

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
