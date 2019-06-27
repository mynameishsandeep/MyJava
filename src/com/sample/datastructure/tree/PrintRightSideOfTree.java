package com.sample.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/description/
 * 1) Traverse the Tree by Level Order. 
 * 2) Add a for loop inside level order traversal. That runs till the size of queue.
 * 3) The queue size determines 1 level. 
 * 4) When the for loop ends add the node value to result, which would be right end side value.
 * 
 */
public class PrintRightSideOfTree {
	static class TreeNode {
		Integer val;
		TreeNode right;
		TreeNode left;

		TreeNode(Integer data) {
			this.val = data;
		}
	}

	TreeNode root;

	public void add(int data) {
		TreeNode tempRoot = root;
		TreeNode currNode = new TreeNode(data);

		if (tempRoot == null) {
			root = currNode;
		} else {
			while (true) {
				if (data < tempRoot.val) {
					if (tempRoot.left != null) {
						tempRoot = tempRoot.left;
					} else {
						tempRoot.left = currNode;
						break;
					}
				} else {
					if (tempRoot.right != null) {
						tempRoot = tempRoot.right;
					} else {
						tempRoot.right = currNode;
						break;
					}
				}
			}
		}
	}

	public List<Integer> rightSideView() {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		if (root != null) {
			queue.offer(root);
			while (queue.size() > 0) {
				// Do not get queue.size() inside for loop. Because queue size varies. So keep it statically
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					root = queue.poll();
					if (root.left != null) {
						queue.offer(root.left);
					}
					if (root.right != null) {
						queue.offer(root.right);
					}
				}
				result.add(root.val);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		PrintRightSideOfTree p = new PrintRightSideOfTree();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(20);
		System.out.println(p.rightSideView());

	}

}
