package com.interview.leetcode.google.medium;

/*

https://leetcode.com/problems/task-scheduler/description/
=======this question is more about passing number of test cases==============
between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle. 

["A","A","A","B","B","B"], n = 2---> ABi ABi AB
Result = 8

["A","A","A","B","B","B"], n = 3--->ABii ABii AB
Result = 10


["A","B","C","D","E","A","B","C","D","E"], n = 4 --> ABCD EABC CD
Result = 10;

======
1) Round Robin approach will not work...
	Ex: [A,A,A,A,A,B,C,D,E]-->Round-Robin will take 15 intervals. But can be done in 13

========Solution Approach Logic======
1) Create a frame with "most frequent characters" separated by n.
Ex: AAABBB n=2
	AxxAxxA
	ABxABxAB
=====Solution=========
Ex: AAABBB n=3
	AxxxAxxxA
	AxxxAxxxAB ===> Note only last frame B is filled(logically).  
1) Find the mostFrequentCharactersCount and how many similar counts are present.
2) Now the formula is
	a) (mostFrequentCharactersCount - 1) ---> Because we ignore last frame, which does not need interval.
		So considering "AxxxAxxx"
	b) (mostFrequentCharactersCount - 1) * (n + 1) --> 
	Because  (mostFrequentCharactersCount - 1)=2. Then I can get 8 by multiplying with 4. So n=3 (n+1=4)
	c) For the last Frame. add noOfOccurance_MostFrequentCharactersCount
		"AxxxAxxxAB".
=====Solution lined up question===========
This problem is only getting the the count. If the question is about getting the ordered task element also then
this approach will not work. Because, it is simple formula to get count. 
Clue--- for k-1 elements it has be handled differently.
Sample which needs special code on k-1 elements: AAAABBBEEFFGG 3
Frame: "AXXXAXXXAXXXA"
insert 'B': "ABXXABXXABXXA" <--- 'B' has higher frequency than the other characters, insert it first.
insert 'E': "ABEXABEXABXXA"
insert 'F': "ABEFABEXABFXA" <--- each time try to fill the k-1 gaps as full or evenly as possible.
insert 'G': "ABEFABEGABFGA"
 		
 */
public class TaskScheduler_MathsApproach {
	public int leastInterval(char[] tasks, int n) {
		int[] cnt = new int[26];
		for (char c : tasks) {
			cnt[c - 'A']++;
		}
		int mostFrequentCharactersCount = 0;
		int noOfOccurance_MostFrequentCharactersCount = 0;
		for (int i = 0; i < 26; i++) {
			if (cnt[i] == mostFrequentCharactersCount) {
				noOfOccurance_MostFrequentCharactersCount++;
			} else if (cnt[i] > mostFrequentCharactersCount) {
				mostFrequentCharactersCount = cnt[i];
				noOfOccurance_MostFrequentCharactersCount = 1;
			}
		}
		int minimum = (mostFrequentCharactersCount - 1) * (n + 1) + noOfOccurance_MostFrequentCharactersCount;
		// For some of the bigger input, with n=0 and n=1. above logic fails and answer is tasks.length
		if (tasks.length > minimum)
			return tasks.length;
		else
			return minimum;
	}

	public static void main(String[] args) {
		TaskScheduler_MathsApproach t = new TaskScheduler_MathsApproach();
		//char c[] = { 'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E', 'F' };
		//String s = "AAAABBBEEFFGG";
		String s = "AAABBB";
		char c[] = s.toCharArray();
		System.out.println(t.leastInterval(c, 2));
	}
}
