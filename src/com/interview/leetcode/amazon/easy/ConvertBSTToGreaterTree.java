package com.interview.leetcode.amazon.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/*
 * https://leetcode.com/problems/convert-bst-to-greater-tree/description/
 */
public class ConvertBSTToGreaterTree {

	static class TreeNode {
		TreeNode left;
		TreeNode right;
		int val;
	}

	Set<Integer> data = new TreeSet<>(Collections.reverseOrder());

	public TreeNode convertBST(TreeNode root) {
		preOrderTraverseSort(root);
		Map<Integer, Integer> map = new HashMap<>();
		int total = 0;
		for (Integer current : data) {
			total += current;
			map.put(current, total);
			System.out.println(total);
		}

		preOrderTraverseUpdateData(map, root);
		return root;

	}

	public void preOrderTraverseUpdateData(Map<Integer, Integer> map, TreeNode root) {
		if (root == null) {
			return;
		}
		root.val = map.get(root.val);
		preOrderTraverseUpdateData(map, root.left);
		preOrderTraverseUpdateData(map, root.right);
	}

	public void preOrderTraverseSort(TreeNode root) {
		if (root == null) {
			return;
		}
		data.add(root.val);
		preOrderTraverseSort(root.left);
		preOrderTraverseSort(root.right);
	}
}
