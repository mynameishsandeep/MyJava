package com.sample.basics;

public class ReverseAString2 {

	/**
	 * Swap 1st and n th character, then
	 * 2nd and n-1 character... So half traversal is enough
	 */
	public static String reverse(String s) {
        char[] array =  s.toCharArray();
        for(int i=0; i<array.length/2; i++) {
            char tmp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = tmp;
        }
        return charArrayToString(array);
    }

    public static String charArrayToString(char[] array) {
        StringBuffer sb = new StringBuffer();
        sb.append(array);
        return sb.toString();
    }
    
	public static void main(String[] args) {
		System.out.println(reverse("Test"));

	}

}
