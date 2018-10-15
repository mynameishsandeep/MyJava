package com.interview.leetcode.linkedin.medium;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/serialize-and-deserialize-bst/discuss/93177/what's-the-difference-between-this-and-297
 * 
 * Main difference between SerializeAndDeserializeBinaryTree and this problem is we don't need additional data to
 * store end of nodes, because of the property of BST.
 */
public class SerializeAndDeserializeBST_PreOrder {
	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	private void serialize(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		sb.append(root.val).append(" ");
		serialize(root.left, sb);
		serialize(root.right, sb);
	}

	public TreeNode deserialize(String data) {
		if (data == null || data.length() == 0) {
			return null;
		}
		String[] nodes = data.split(" ");
		int[] index = new int[] { 0 };
		return deserialize(nodes, index, Integer.MAX_VALUE);
	}

	private TreeNode deserialize(String[] nodes, int[] index, int max) {
		if (index[0] >= nodes.length || Integer.valueOf(nodes[index[0]]) >= max) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.valueOf(nodes[index[0]++]));
		root.left = deserialize(nodes, index, root.val);
		root.right = deserialize(nodes, index, max);
		return root;
	}
}
