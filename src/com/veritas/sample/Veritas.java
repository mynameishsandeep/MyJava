package com.veritas.sample;

public class Veritas {

	public static void main(String[] args) {

	}

	public boolean findWord(final char input[][],final String search) {
		boolean success = true;
		for(int i=0; i<input.length; i++) {// row
			//if(search.length() != input[])
			for (int j=0; j<input[i].length; j++) { // column
				if(input[i][j] != search.charAt(j)) {
					success = false;
					break;
				}
			}
		}
		return success;
		
	}

//	public boolean navigateLeftToRight(final char input[], final String search) {
//
//	}
//
//	public boolean navigateRightToLeft(final char input[], final String search) {
//
//	}
//
//	public boolean navigateTopToBottom(final char input[], final String search) {
//
//	}
//
//	public boolean navigateBottomToTop(final char input[], final String search) {
//
//	}
}
