package com.interview.leetcode.amazon.easy;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/next-greater-element-i/
 * 

1) search the number(not index) in nums2
2) determine if any greater number exists?. i.e parse all number till end to see if greater number exists.
3) else return -1

e.g.
nums1 = [4, 1, 2] nums2 = [1, 3, 4, 2]

-for '4'

find the number '4' in nums2, that is the 3rd number,
determine the next number '2' is greater? (False)
output -1
-for '1'

find the number '1' in nums2, that is the 1st number,
determine the next number '3' is greater? (True)
output 3
-for '2'

find the number '2' in nums2, that is the 4th number,
There is nothing behind 2 (False)
output -1

=========
Input
[1,3,5,2,4]
[6,5,4,3,2,1,7]
Expected
[7,7,7,7,7]

=====Solution1=======
Find the number by binary search. Verify if next number is greater or not.


 */
public class NextGreaterElementI {
	
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        if(nums.length<2) {
            return findNums;
        }
        for(int left=0, right=1; left<nums.length-1; ) {
            if(nums[left]<nums[right]) {
                map.put(nums[left], nums[right]);
                left++;
                right = left+1;
            } else if(right==nums.length-1) {
                map.put(nums[left], -1);
                left++;
                right = left+1;
            } else {
                right++;
            }
        }
        map.put(nums[nums.length-1], -1);
        
        for(int i=0; i<findNums.length; i++) {
            findNums[i] = map.get(findNums[i]);
        }
        return findNums;
    }
	
}
