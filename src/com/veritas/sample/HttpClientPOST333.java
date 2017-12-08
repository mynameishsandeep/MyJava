package com.veritas.sample;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;

public class HttpClientPOST333 {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);

		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		cm.setMaxTotal(20);
		cm.setDefaultMaxPerRoute(5);
		
		HttpHost localhost = new HttpHost("localhost", 8080);
		cm.setMaxPerRoute(new HttpRoute(localhost), 5);
		
		HttpHost rhelhost = new HttpHost("192.168.50.4", 8080);
		cm.setMaxPerRoute(new HttpRoute(rhelhost), 5);

		ConnectionKeepAliveStrategy c = new ConnectionKeepAliveStrategy() {
			public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
				return -1;
			}
		};

		CloseableHttpClient client = HttpClients.custom().setConnectionManager(cm).setKeepAliveStrategy(c).build();



		Callable<Object> c1 = () -> {
			HttpPost httpPostRequest = new HttpPost("http://localhost:8080/YSBServlet/Sample");
			final HttpContext context = HttpClientContext.create();
			CloseableHttpResponse response = client.execute(httpPostRequest, context);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(Arrays.toString(response.getAllHeaders()));
			httpPostRequest.reset();// release the connection to pool	
			return null;
		};

		Callable<Object> c2 = () -> {
			HttpPost httpPostRequest2 = new HttpPost("http://localhost:8080/YSBServlet/Sample2");
			final HttpContext context = HttpClientContext.create();
			CloseableHttpResponse response = client.execute(httpPostRequest2, context);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(Arrays.toString(response.getAllHeaders()));
			httpPostRequest2.reset();// release the connection to pool
			return null;
		};

		Callable<Object> c3 = () -> {
			HttpPost httpPostRequest3 = new HttpPost("http://localhost:8080/YSBServlet/Sample3");
			final HttpContext context = HttpClientContext.create();
			CloseableHttpResponse response = client.execute(httpPostRequest3, context);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(Arrays.toString(response.getAllHeaders()));
			httpPostRequest3.reset();// release the connection to pool
			return null;
		};

		Callable<Object> c4 = () -> {
			HttpPost httpPostRequest4 = new HttpPost("http://localhost:8080/YSBServlet/Sample4");
			final HttpContext context = HttpClientContext.create();
			CloseableHttpResponse response = client.execute(httpPostRequest4, context);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(Arrays.toString(response.getAllHeaders()));
			Thread.currentThread().sleep(10000);
			httpPostRequest4.reset();// release the connection to pool
			return null;
		};

		Callable<Object> c5 = () -> {
			HttpPost httpPostRequestRedHat2 = new HttpPost("http://192.168.50.4:8080/YSBServlet/Sample2");
			final HttpContext context = HttpClientContext.create();
			CloseableHttpResponse response = client.execute(httpPostRequestRedHat2, context);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(Arrays.toString(response.getAllHeaders()));
			httpPostRequestRedHat2.reset();// release the connection to pool	
			return null;
		};

		Callable<Object> c6 = () -> {
			HttpPost httpPostRequestRedHat3 = new HttpPost("http://192.168.50.4:8080/YSBServlet/Sample3");
			final HttpContext context = HttpClientContext.create();
			CloseableHttpResponse response = client.execute(httpPostRequestRedHat3, context);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(Arrays.toString(response.getAllHeaders()));
			httpPostRequestRedHat3.reset();// release the connection to pool
			return null;
		};

		Callable<Object> c7 = () -> {
			HttpPost httpPostRequestRedHat4 = new HttpPost("http://192.168.50.4:8080/YSBServlet/Sample4");
			final HttpContext context = HttpClientContext.create();
			CloseableHttpResponse response = client.execute(httpPostRequestRedHat4, context);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(Arrays.toString(response.getAllHeaders()));
			httpPostRequestRedHat4.reset();// release the connection to pool
			return null;
		};

		Callable<Object> c8 = () -> {
			HttpPost httpPostRequestRedHat = new HttpPost("http://192.168.50.4:8080/YSBServlet/Sample");
			final HttpContext context = HttpClientContext.create();
			CloseableHttpResponse response = client.execute(httpPostRequestRedHat, context);
			System.out.println(response.getStatusLine().getStatusCode());
			System.out.println(Arrays.toString(response.getAllHeaders()));
			Thread.currentThread().sleep(10000);
			httpPostRequestRedHat.reset();// release the connection to pool
			return null;
		};

		ExecutorService exec = Executors.newFixedThreadPool(20);

		while (true) {
			String s = scan.nextLine();
			if ("end".equals(s)) {
				break;
			} else if ("1".equals(s)) {
				exec.submit(c1);
			} else if ("2".equals(s)) {
				exec.submit(c2);
			} else if ("3".equals(s)) {
				exec.submit(c3);
			} else if ("4".equals(s)) {
				exec.submit(c4);
			} else if ("5".equals(s)) {
				exec.submit(c5);
			} else if ("6".equals(s)) {
				exec.submit(c6);
			} else if ("7".equals(s)) {
				exec.submit(c7);
			} else {
				exec.submit(c8);
			}
		}
		client.close();
		exec.shutdown();
	}
}
