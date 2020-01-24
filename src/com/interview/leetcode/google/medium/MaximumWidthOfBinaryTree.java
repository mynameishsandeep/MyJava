package com.interview.leetcode.google.medium;

import java.util.ArrayDeque;
import java.util.Deque;

import com.interview.leetcode.TreeNode;
/*
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
=============================Theory Note=================================
1) See "TreeIndexingNodes.jpeg"
2) Index node at each level and calculate maxWidth at each level by taking "levelLastNodeIndexValue-levelFirstNodeIndexValue+1"
3) Formula to index the node is for "left"-> node.val*2.... for "right"->node.val*2+1
 		    	================Sample Node Indexing for 4 level===============
 		    				1          level1==>1
 		    			2		3      level2==>(3-2)+1 = 2
 		    		  4   5   6   7    level3==>(7-4)+1 = 4
 		    		 8 9           15  level4==>(15-7)+1= 8
============================Solution Note================================
0) We are not considering the TreeNode actual data itself. We change TreeNode data to index value. So Tree is corrupted.
1) Do simple level order traversal.
2) Identify the maxWidth at each level by picking "levelLastNodeIndexValue-levelFirstNodeIndexValue+1"
2) Index the node value at each level, starting from root. Initially root index set as 1.
3) Index value is set from "root to left and right" then subsequently based on formula.
===========================================================================
Ex Input:
						      1
					         / \
					        3   2
					       /     \
					      5       9
					     /         \
					    6           7
	Ouput: 8
	======================Indexing the data==============
 		    				1          level1==>1          ==>MaxWidth=1
 		    			2		3      level2==>(3-2)+1 = 2==>MaxWidth=2
 		    		  4           7    level3==>(7-4)+1 = 4==>MaxWidth=4
 		    		 8             15  level4==>(15-7)+1= 8==>MaxWidth=8

===========================================================================
Ex Input:
								  1
						         /
						        3
						       / \
						      5   3
   Output: 2
		======================Indexing the data==============
 		    			  1            level1==>1          ==>MaxWidth=1
 		    			2		       level2==>(2-2)+1 = 1==>MaxWidth=1
 		    		  4   5            level3==>(5-4)+1 = 2==>MaxWidth=2

===========================================================================
 */
public class MaximumWidthOfBinaryTree {
  public int widthOfBinaryTree(TreeNode root) {
    Deque<TreeNode> q = new ArrayDeque<>();
    root.val = 1;
    q.offer(root);
    int maxWidth = 1;
    while (!q.isEmpty()) {
      int size = q.size();
      int levelFirstNodeIndexValue = q.peekFirst().val;
      int levelLastNodeIndexValue = q.peekLast().val;
      maxWidth = Math.max(maxWidth, levelLastNodeIndexValue - levelFirstNodeIndexValue + 1);
      for (int i = 0; i < size; i++) {
        root = q.poll();
        if (root.left != null) {
          root.left.val = root.val * 2;
          q.offer(root.left);
        }
        if (root.right != null) {
          root.right.val = root.val * 2 + 1;
          q.offer(root.right);
        }
      }
    }
    return maxWidth;
  }
}
