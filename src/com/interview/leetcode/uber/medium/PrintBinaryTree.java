package com.interview.leetcode.uber.medium;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/print-binary-tree/description/
 * 
 * 1) Calculate Height
 * 2) Calculate Wide
 * 3) FillEmpty in the array
 * 4) Fill result in the array
 */
public class PrintBinaryTree {
	public List<List<String>> printTree(TreeNode root) {
		int height = height(root);
		int wide = (int) Math.pow(2, height) - 1;
		List<List<String>> result = new ArrayList<>();
		fillEmpty(result, height, wide);
		fillResult(result, root, 0, 0, wide - 1);
		return result;
	}

	private void fillEmpty(List<List<String>> result, int height, int wide) {
		for (int i = 0; i < height; i++) {
			List<String> list = new ArrayList<>();
			for (int j = 0; j < wide; j++) {
				list.add("");
			}
			result.add(list);
		}
	}

	private void fillResult(List<List<String>> result, TreeNode root, int row, int left, int right) {
		if (root == null)
			return;
		int center = (left + right) / 2;
		result.get(row).set(center, String.valueOf(root.val));
		fillResult(result, root.left, row + 1, left, center);
		fillResult(result, root.right, row + 1, center + 1, right);
	}

	private int height(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}
}
