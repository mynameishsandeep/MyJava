package com.interview.leetcode.linkedin.hard;

import java.util.StringTokenizer;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * 
 * Per-Order for serialize and de-serialize 
 * 		
 */
public class SerializeAndDeserializeBinaryTree2 {

	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	private static void serialize(TreeNode x, StringBuilder sb) {
		if (x == null) {
			sb.append("# ");
		} else {
			sb.append(x.val + " ");
			serialize(x.left, sb);
			serialize(x.right, sb);
		}
	}

	public static TreeNode deserialize(String s) {
		if (s == null || s.length() == 0)
			return null;
		StringTokenizer st = new StringTokenizer(s, " ");
		return deserialize(st);
	}

	private static TreeNode deserialize(StringTokenizer st) {
		if (!st.hasMoreTokens())
			return null;
		String val = st.nextToken();
		if (val.equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left = deserialize(st);
		root.right = deserialize(st);
		return root;
	}
}
