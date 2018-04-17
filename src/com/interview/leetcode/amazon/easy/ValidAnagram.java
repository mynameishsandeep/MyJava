package com.interview.leetcode.amazon.easy;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
        Integer a[] = new Integer[26];
        
        for(Character c : s.toCharArray()) {
            if(a[c-'a'] == null) {
                a[c-'a'] = 1;
            } else {
                a[c-'a'] = a[c-'a']+1;
            }
        }
        for(Character c : t.toCharArray()) {
            if(a[c-'a'] == null) {
                return false;
            } else {
                a[c-'a'] = a[c-'a']-1;
            }
        }
        for(Integer i : a) {
            if(i!= null && i!=0) {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		ValidAnagram v =  new ValidAnagram();
		System.out.println(v.isAnagram("a", "a"));
	}
}
