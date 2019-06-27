package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/majority-element/
 * 
 * 1) Problem states x number will appear more than n/2 times.
 * 2) So x will occupy more than half of array.
 */
public class MajorityElement {
	
	
	
	public int majorityElementBest(int[] num) {

        int major=num[0], count = 1;
        for(int i=1; i<num.length;i++){
            if(count==0){
                count++;
                major=num[i];
            }else if(major==num[i]){
                count++;
            }else count--;
            
        }
        return major;
    }
	
	public int majorityElementApproach2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
	
	public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxNumber = 0;
        for(Integer num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if(count>maxCount) {
                maxCount = count;
                maxNumber = num;
            }
            map.put(num, count);
        }
        return maxNumber;
        
    }
	
	
	
}
