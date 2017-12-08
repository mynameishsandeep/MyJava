package com.sample.datastructure.tree.dfs;

/**
 * This problem is solved by using the DFS with InOrder Traversal. Image is
 * given in "US Problems" folder
 * 
 * http://www.javawithus.com/programs/towers-of-hanoi
 * 
 */
public class TowerOfHanoi {

	public static void main(String[] args) {
		Integer noOfDiscs = 3;
		towerOfHanoi(noOfDiscs, "A", "B", "C");

	}

	public static void towerOfHanoi(final Integer noOfDiscs, final String start, final String aux, final String end) {
		if (noOfDiscs == 1) {
			System.out.println("Move From " + start + " to " + end);
		} else {
			towerOfHanoi(noOfDiscs - 1, start, end, aux);
			System.out.println("Move From " + start + " to " + end);
			towerOfHanoi(noOfDiscs - 1, aux, start, end);
		}
	}

}
