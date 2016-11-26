package lsy.test;

import lsy.ext.HttpSSLClientV1;
import lsy.util.UtilConsole;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import java.io.IOException;

/**
 * Created by Administrator on 2016/9/11.
 */
public class TestTickteSSLHttpClient
{
	public static void main(String[] args) {
		TestTickteSSLHttpClient o = new TestTickteSSLHttpClient();
		o.execute();
	}

	private void execute() {
		HttpHost httpHost = new HttpHost("kyfw.12306.cn", 443, "https");
		HttpSSLClientV1 client = HttpSSLClientV1.createInstance(httpHost);

		HttpUriRequest uriRequest = new HttpGet("https://kyfw.12306.cn/otn/login/init");

		UtilConsole.log("Access "+httpHost+" "+uriRequest);
		try {
			CloseableHttpResponse response = client.getHttpClient().execute(uriRequest);
			Header[]  headers = response.getAllHeaders();
			if(headers != null)
			{
				for(Header header : headers)
				{
					UtilConsole.log(header.getName()+" = "+header.getValue());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
