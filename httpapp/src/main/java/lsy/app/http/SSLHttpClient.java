package lsy.app.http;

import lsy.app.main.AppClient;
import lsy.app.http.pack.Pack;
import lsy.util.UtilConsole;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ssl.*;
import org.apache.http.cookie.*;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/9/11.
 */
public class SSLHttpClient
{

	CloseableHttpClient sslHttpclient = null;

	HashMap<String, String> fixedHeaders;

	protected SSLHttpClient() {
		createSslHttpclient();
	}

	public SSLHttpClient(HashMap<String, String> fixedHeaders) {
		this();
		this.fixedHeaders = fixedHeaders;
	}

	private void createSslHttpclient()
	{
		try {
			/*
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			FileInputStream instream = new FileInputStream(new File("d:\\tomcat.keystore"));
			try {
				// ����keyStore d:\\tomcat.keystore
				trustStore.load(instream, "123456".toCharArray());
			} catch (CertificateException e) {
				e.printStackTrace();
			} finally {
				try {
					instream.close();
				} catch (Exception ignore) {
				}
			}
			// �����Լ���CA��������ǩ����֤��
			SSLContext sslcontext = SSLContexts.custom().loadTrustMaterial(trustStore, new TrustSelfSignedStrategy()).build();x
			*/

			SSLContext sslcontext = SSLContexts.custom().build();
			sslcontext.init(null, new TrustManager[] { new TrustAllX509TrustManager()}, null);
			X509HostnameVerifier hostnameVerifier = new AllowAllHostnameVerifier();

			/*
			// ֻ����ʹ��TLSv1Э��
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "SSL","TLSv1" }, null,
					SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
					*/

			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" }, null,hostnameVerifier);

///////////////////////////////////////////////////////////////////////////////////////////////////
			BasicCookieStore cookieStore = new BasicCookieStore();
			CookieSpecProvider easySpecProvider = new CookieSpecProvider() {
				public CookieSpec create(HttpContext context) {
					return new BrowserCompatSpec() {
						@Override
						public void validate(Cookie cookie, CookieOrigin origin)
								throws MalformedCookieException {
// Oh, I am easy
						}
					};
				}
			};
			Registry r = RegistryBuilder
					. create()
					.register(CookieSpecs.BEST_MATCH, new BestMatchSpecFactory())
					.register(CookieSpecs.BROWSER_COMPATIBILITY,
							new BrowserCompatSpecFactory())
					.register("easy", easySpecProvider).build();
			RequestConfig requestConfig = RequestConfig.custom()
					.setCookieSpec("easy").setSocketTimeout(10000)
					.setConnectTimeout(10000).build();

			sslHttpclient  = HttpClients.custom()
					.setSSLSocketFactory(sslsf)
					.setDefaultCookieSpecRegistry(r)
					.setDefaultRequestConfig(requestConfig)
					.setDefaultCookieStore(cookieStore)
					.build();


//			sslHttpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void execute(AppClient appClient)
	{
		Pack pack = appClient.getCurPack();
		UtilConsole.info("-------------------------------------------------------------");
		UtilConsole.info("Sending : "+pack);
		if(pack.getInfo() != null)
			UtilConsole.info("Pack-Info : "+pack.getInfo());
		String url = pack.getUrl();
		HttpUriRequest request = null;
		if(pack.isPost())
			request = new HttpPost(url);
		else
			request = new HttpGet(url);
		///////////////////////////////////////////////////////////
		//���� ͨ�ù̶� headers
		if(fixedHeaders != null && fixedHeaders.size() > 0)
		{
			for(String n : fixedHeaders.keySet())
			{
				String value = fixedHeaders.get(n);
				request.addHeader(n,value);
				UtilConsole.info("Add-Fix-Header : "+n+" = "+value);
			}
		}
		///////////////////////////////////////////////////////////
		//���� ������ headers
		if( pack.getHeaders().size() > 0)
		{
			for(String n : pack.getHeaders().keySet())
			{
				String value = pack.getHeaders().get(n);
				request.addHeader(n,value);
				UtilConsole.info("Add-Pack-Header : "+n+" = "+value);
			}
		}
		UtilConsole.info("Executing request " + request.getRequestLine());

		CloseableHttpResponse response = null;
		try {
		response = sslHttpclient.execute(request);
			HttpEntity entity = response.getEntity();
			UtilConsole.info("----------------------------- Response -------------------------");
			UtilConsole.info(String.valueOf(response.getStatusLine()));
			if (entity != null)
			{
				String responseString = EntityUtils.toString(entity);
				UtilConsole.info("Response content length: " + entity.getContentLength());
				UtilConsole.info(responseString);
				pack.handleResult(appClient, response.getStatusLine(),responseString);
				UtilConsole.info("Consume Entity");
				EntityUtils.consume(entity);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void addFixHeader(String name, String value) {
		fixedHeaders.put(name,value);
	}
}
