package com.interview.leetcode.linkedin.medium;

/*
 * https://leetcode.com/problems/repeated-dna-sequences/description/
 * 
 * Solution:
 * 1) It is based on sliding window of size 10.
 * 2) Save each window of size 10 in Set. Compare from window 11. 
 * 3) If a match found put in set to avoid duplicate result.   
 * 
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {
		Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
		for (int i = 0; i + 9 < s.length(); i++) {
			String ten = s.substring(i, i + 10);
			if (!seen.add(ten))
				repeated.add(ten);
		}
		return new ArrayList<>(repeated);
	}

	public static void main(String[] args) {
		RepeatedDNASequences r = new RepeatedDNASequences();
		System.out.println(r.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}
}
