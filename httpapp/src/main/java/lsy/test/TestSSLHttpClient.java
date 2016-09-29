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
public class TestSSLHttpClient
{
	public static void main(String[] args) {
		TestSSLHttpClient o = new TestSSLHttpClient();
		o.execute();
	}

	private void execute() {
		HttpHost httpHost = new HttpHost("www.chaosfund.com", 443, "https");
		HttpSSLClientV1 client = HttpSSLClientV1.createInstance(httpHost);

		HttpUriRequest uriRequest = new HttpGet("https://www.chaosfund.com");

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
