package com.interview.leetcode.google.easy;

public class PlusOne {

	public int[] plusOne(int[] digits) {
        Integer sum = 1;
        Integer carry = 0;
        String result = "";
        for(int i=digits.length-1; i>=0; i--) {
            sum = sum + carry + digits[i];
            if(sum==10) {
                result = result+0;
                carry = 1;
            } else {
                result = result +sum;
                carry = 0;
            }
            sum = 0;
        }
        if(carry==1) {
            result = result+1;
        }
        int[] resultArr = new int[result.length()];
        int j = 0;
        for(int i=result.length()-1; i>=0; i--) {
            resultArr[j++] = new Integer(result.charAt(i)-'0');
        }
        return resultArr;
    }
	
	public static void main(String[] args) {
		PlusOne p = new PlusOne();
		p.plusOne(new int[] {1,2,3});
	}
}
