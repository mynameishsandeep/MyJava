package com.walmart.string;

public class ReverseWord {

	public static void reverseWords(char[] s) {
	    int i=0;
	    for(int j=0; j<s.length; j++){
	        if(s[j]==' '){
	            reverse(s, i, j-1);        
	            i=j+1;
	        }
	    }
	    // for the last word
	    reverse(s, i, s.length-1);
	 
	    reverse(s, 0, s.length-1);
	    System.out.println(s);
	}
	 
	public static void reverse(char[] s, int i, int j){
	    while(i<j){
	        char temp = s[i];
	        s[i]=s[j];
	        s[j]=temp;
	        i++;
	        j--;
	    }
	    //System.out.println(s);
	}
	public static void main(String[] args) {
		String s = "the sky is blue";
		reverseWords(s.toCharArray());

	}

}
