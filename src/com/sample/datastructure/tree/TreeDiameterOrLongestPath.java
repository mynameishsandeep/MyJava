package com.sample.datastructure.tree;

/*
 *  Diameter of a tree can be calculated by only using the height function, 
 *  Because the diameter of a tree is nothing but maximum value of (left_height + right_height + 1) for each node. 
 *  So we need to calculate this value (left_height + right_height + 1) for each node and update the result. 
 *  Time complexity – O(n)
 *  
 *  Note: result is not the number of nodes. result is number of edges(connecting line)
 *  https://www.geeksforgeeks.org/diameter-of-a-binary-tree-in-on-a-new-method/
 *  
 *  Note: Using array since it is immutable. Integer or int will not work
 */
public class TreeDiameterOrLongestPath {

	public int diameterOfBinaryTree(TreeNode root) {
		int[] dia = new int[] { 0 };
		diameterOfBinaryTree(root, dia);
		return dia[0];
	}

	public int diameterOfBinaryTree(TreeNode root, int[] dia) {
		System.out.println("Called");
		if (null == root) {
			return -1;
		}
		int left = 1 + diameterOfBinaryTree(root.left, dia);
		int right = 1 + diameterOfBinaryTree(root.right, dia);
		dia[0] = Math.max(dia[0], left + right);
		return Math.max(left, right);
	}

	class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
	}

	TreeNode root;

	public void add(int data) {
		TreeNode tempRoot = root;
		TreeNode currNode = new TreeNode();
		currNode.data = data;
		if (tempRoot == null) {
			root = currNode;
		} else {
			while (true) {
				if (data < tempRoot.data) {
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

	public static void main(String[] args) {
		TreeDiameterOrLongestPath p = new TreeDiameterOrLongestPath();
		p.add(10);
		p.add(5);
		p.add(4);
		p.add(6);
		p.add(20);
		p.add(30);
		p.add(15);
		p.add(21);
		p.add(22);

		System.out.println();
		System.out.println("Diameter of the Tree is " + p.diameterOfBinaryTree(p.root));

	}
}
