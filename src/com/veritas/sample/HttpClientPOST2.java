package com.veritas.sample;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpClientPOST2 {

	public static void main(String[] args) throws IOException {
		while (true) {
			HttpClient client = HttpClientBuilder.create().build();
			HttpPost httpPost = new HttpPost("http://localhost:8080/YSBServlet/Sample");
			HttpResponse response = client.execute(httpPost);
			httpPost.setHeader("Connection", "keep-alive");
			httpPost.setHeader("Keep-Alive", "-1");

			System.out.println(response.getStatusLine().getReasonPhrase());
			System.out.println(response.getStatusLine().getStatusCode());
			Scanner scan = new Scanner(System.in);
			scan.nextLine();
		}
		

	}
}
