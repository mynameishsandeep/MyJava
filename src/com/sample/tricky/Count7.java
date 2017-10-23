package com.sample.tricky;

public class Count7 {
	public static void main(String[] args) {
		System.out.println(new Count7().count7(717));
		System.out.println(new Count7().count7Proper(717));
	}

	int reminder = 0;
	int quotient = 0;
	int count = 0;

	public int count7(int n) {
		if (n < 10) {
			if (n == 7) {
				count++;
				return count;
			}
		}
		reminder = n % 10;
		if (reminder == 7) {
			count++;
		}
		quotient = n / 10;
		count7(quotient);
		return count;
	}

	public int count7Proper(int n) {
		if (n < 10) {
			if (n == 7) {
				return 1;
			} else {
				return 0;
			}
		}
		return count7(n / 10) + (n % 10 == 7 ? 1 : 0);
	}

}
