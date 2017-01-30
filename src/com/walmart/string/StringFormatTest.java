package com.walmart.string;

public class StringFormatTest {
	public static void main(String[] args) {
		System.out.println(callRemoteService("10"));
	}

	public static String callRemoteService(String productId) {
		final String url = String.format("/api/v1/myAPI/product/%s", productId);
		return url;
	}
}
