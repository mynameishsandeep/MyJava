package com.interview.leetcode.linkedin.hard;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 * 
 * Serialization can be done in any ways, as long as it can be de-serialized. 
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74253/Easy-to-understand-Java-Solution
 * Above link serialize using in-order. Print the data and verify what is passed to de-serialize method
 * 
 * 1) Serialize:
 * 		a) Travel tree by level order traversal. For null insert #
 * 2) De-Serialize:
 * 		a) Split the string by ","
 * 		b) Use level order traversal and append data to result string. 
 * 		
 */
public class SerializeAndDeserializeBinaryTree {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "";
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		StringBuilder result = new StringBuilder();
		while (q.size() > 0) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node == null) {
					result = result.append("#,");
				} else {
					result.append(node.val + ",");
					q.offer(node.left);
					q.offer(node.right);
				}
			}
		}
		return result.substring(0, result.length() - 1);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if ("".equals(data))
			return null;
		String dataArray[] = data.split(",");
		TreeNode root = new TreeNode(new Integer(dataArray[0]));
		Queue<TreeNode> node = new LinkedList<>();
		node.offer(root);
		for (int i = 1; i < dataArray.length;) {
			TreeNode parent = node.poll();
			if (!dataArray[i].equals("#")) {
				TreeNode left = new TreeNode(new Integer(dataArray[i]));
				parent.left = left;
				node.offer(left);
			}
			i++;
			if (!dataArray[i].equals("#")) {
				TreeNode right = new TreeNode(new Integer(dataArray[i]));
				parent.right = right;
				node.offer(right);
			}
			i++;
		}
		return root;
	}
}
