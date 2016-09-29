package lsy.app.http;

import java.util.HashMap;

/**
 * Created by Administrator on 2016/9/11.
 */
public class SSLHttpClientBuilder
{
	HashMap<String,String> headers = new HashMap<>();
	public SSLHttpClient build() {
		SSLHttpClient httpClient = new SSLHttpClient(headers);
		return httpClient;
	}

	public static SSLHttpClientBuilder newBuilder() {
		return new SSLHttpClientBuilder();
	}

	public SSLHttpClientBuilder setHeader(String name, String value) {
		headers.put(name,value);
		return this;
	}
}
