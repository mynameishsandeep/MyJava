package com.sample.basics;

/*
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
 * Read: "Why negative numbers are stored in 2’s compliment?" in the interview document
 * https://www.rapidtables.com/convert/number/decimal-to-hex.html --> this calculator has 2 answer for -11 for decimal to hexadecimal
 * Question is to convert number to hexNumber. 
 * Ex: 10 -> a
 * 	   -1 -> ffffffff. Because -1 internally saved as all 1 for 32 bit number.
 * 
 * So don't think about negative number in hexadecimal, like interviewer 
 * might ask why can't -1 in decimal number is -1 in hexadecimal.
 * If the interviewer asks to -1 to be -1 then logic is different.    
 * Check program DecimalToHexaDecimal2.java
 * 
 * 1) Java stores Numbers in binary format always. 
 * For the negative number it will be stored in 2's complement format.
 * EX: -1 will be stored as (Taking short as example)
 * 1000 0000 0000 0001 
 * 1111 1111 1111 1110 (Invert) (Excluding MSB bit or sign)
 * 					 1 (Add 1)
 * ===================
 * 1111 1111 1111 1111 (This is how it look internally)
 * Signed numbers are stored in 2’s compliment form. Because if make arithmetic operations correct.. EX: To add 5 and -5 
 * 
 * 2) If I print a number it always print in Decimal Format. 
 * 3) So I can extract the last 4 digit number by right shift operator. 
 * 4) Left Shift operator will not work, because data will be filled from last.
 * 5) For the Right Shift operation use >>>(right shift and fill MSB bit with zero). 
 * If I use >> then if it is a negative number, (then MSB bit will be keep filled with 1). Which will go infinite loop and wrong    
 */
public class DecimalToHexaDecimal {

	public String toHex(int num) {
		if (num == 0) {
			return "0";
		}
		StringBuilder result = new StringBuilder();
		while (num != 0) {
			int current = num & 15;
			result.append(toHexString(current));// Integer.toHexString(current);
			num = num >>> 4;
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		DecimalToHexaDecimal d = new DecimalToHexaDecimal();
		System.out.println(d.toHex(-1));
		System.out.println(d.toHex(-11));
		System.out.println(d.toHex(11));
	}

	private String toHexString(int data) {
		if (data < 10) {
			return data + "";
		}
		switch (data) {
		case 10:
			return "a";
		case 11:
			return "b";
		case 12:
			return "c";
		case 13:
			return "d";
		case 14:
			return "e";
		case 15:
			return "f";
		default:
			return "";
		}
	}
}
