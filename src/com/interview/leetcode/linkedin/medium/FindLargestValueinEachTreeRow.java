package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.TreeNode;

public class FindLargestValueinEachTreeRow {

	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		helper(root, res, 0);
		return res;
	}

	private void helper(TreeNode root, List<Integer> result, int level) {
		if (root == null) {
			return;
		}
		//expand list size
		if (level == result.size()) {// First time on that level, add root value
			result.add(root.val);
		} else {
			int max = Math.max(result.get(level), root.val);
			result.set(level, max ); // set value
		}
		helper(root.left, result, level + 1);
		helper(root.right, result, level + 1);
	}
}
