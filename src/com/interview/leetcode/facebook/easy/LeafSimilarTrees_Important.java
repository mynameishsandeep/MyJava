package com.interview.leetcode.facebook.easy;

import java.util.ArrayList;
import java.util.List;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * Problem: Compare 2 tree from left to right, all leafs are equal.
 *
 * 1) This is an very important problem to understand how recursion goes in depth.
 * 2) Recursion goes from left to right till leaf level.
 * 3) Only recursion can solve this problem
 * 4) Wrote code to solve the problem in level-order traversal. But it failed.
 * Because leaf, which ends in previous level(below example 1) preceeds before long level(6,2) which is ending before.
 * Example:
 *	[3,5,1,6,2,n,n] -->root1

							3
					5				1
				6 		2     	n         n
					  
					  
					  
	[3,5,1,7,n,n,n,6,2]--root2

								3
						5				1
				  7			 n   	n		 n
   			  6      2			             
 			 n  n   n  n
 	
 	For this data: 6,2,1 should be the answer from left to right for root1 and root2.
 	But Level order traversal for root1 prints --> 1,6,2
 			 
 */
public class LeafSimilarTrees_Important {

  public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    List<Integer> root1List = new ArrayList<>();
    List<Integer> root2List = new ArrayList<>();
    updateList(root1, root1List);
    updateList(root2, root2List);
    for (int i = 0; i < root1List.size(); i++) {
      if (root1List.get(i) != root2List.get(i)) {
        return false;
      }
    }
    return true;
  }

  private void updateList(TreeNode root, List<Integer> rootList) {
    if (root.left == null && root.right == null) {
      rootList.add(root.val);
    } else {
      if (root.left != null) updateList(root.left, rootList);
      if (root.right != null) updateList(root.right, rootList);
    }
  }
}
