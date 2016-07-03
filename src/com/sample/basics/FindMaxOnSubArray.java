package com.sample.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class finds the "sum of maximum" on a "subarray". Using kadane's technique which needs
 * only O(n) as compared to brute force approach O(n^2)
 * @author Thangaprabhu
 *
 */
public class FindMaxOnSubArray {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int mainListSize = scan.nextInt();
			List<ArrayList<Integer>> mainList = new ArrayList<>(mainListSize);
			for (int i = 0; i < mainListSize; i++) {
				int subListSize = scan.nextInt();
				ArrayList<Integer> subList = new ArrayList<>(subListSize);
				for (int j = 0; j < subListSize; j++) {
					subList.add(scan.nextInt());
				}
				mainList.add(subList);
			}

			List<ArrayList<Integer>> resultList = new ArrayList<>(mainListSize);
			for (int i = 0; i < mainListSize; i++) {
				ArrayList<Integer> subList = mainList.get(i);
				int subListSize = subList.size();
				ArrayList<Integer> resultSubList = new ArrayList<>();
				int sum = 0;
				int max = 0;
				for (int j = 0; j < subListSize; j++) {
					if (sum + subList.get(j) > 0) {
						sum = sum + subList.get(j);
						if(max>sum) {
							resultSubList.add(max);
						}
						max = sum;
					} else {
						resultSubList.add(max);
						sum = 0;
						max = 0;
					}
				}
				if(sum>0) {
					resultSubList.add(max);
				}
				resultList.add(resultSubList);
			}

			for (int i = 0; i < mainList.size(); i++) {
				ArrayList<Integer> resultSubList = resultList.get(i);
				ArrayList<Integer> mainSubList = mainList.get(i);
				int resultSum = Collections.max(resultSubList);
				if (resultSum == 0) {
					resultSum = Collections.max(mainSubList);
				}
				System.out.print(resultSum + " ");
				
				int sum = mainSubList.stream().filter(j -> j > 0)
						.mapToInt(j -> j).sum();
				if (sum == 0) {
					sum = Collections.max(mainSubList);
				}
				System.out.print(sum);
				System.out.println();
			}

		}
	}
}