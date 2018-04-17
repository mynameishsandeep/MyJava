package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {

	public List<Integer> getRow(int rowIndex) {
		Integer[] result = new Integer[rowIndex + 1];
		Arrays.fill(result, 0);
		result[0] = 1;
		for (int i = 1; i < rowIndex + 1; i++)
			for (int j = i; j >= 1; j--)
				result[j] += result[j - 1];
		return Arrays.asList(result);
	}

	  public List<Integer> getRowWithSingleForLoopAndFormula(int rowIndex) {
          Integer[] rowList = new Integer[rowIndex+1];
          rowList[0] = 1;
          for(int i=1; i<rowList.length;i++) {
              rowList[i] = (int)((long)rowList[i-1]*(rowIndex-(i-1))/(i));
          }
          return Arrays.asList(rowList);
      }
	  
	public static void main(String[] args) {
		PascalsTriangle p = new PascalsTriangle();
		System.out.println(p.getRow(3));
	}
}
