package com.walmart.string;

public class StringFormatTest {
	public static void main(String[] args) {
		System.out.println(callRemoteService("10", "DummyProduct"));
		System.out.println(String.format("/api/v1/myAPI/product/%s_error","testFile"));
	}

	public static String callRemoteService(String productId, String name) {
		final String url = String.format("/api/v1/myAPI/product/%s/test/%s/value", productId, name);
		return url;
	}
}
