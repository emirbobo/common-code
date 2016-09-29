package lsy.ext;


import org.apache.http.HttpHost;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.BasicClientConnectionManager;
import org.apache.http.impl.conn.DefaultSchemePortResolver;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

/**
 * Created by Administrator on 2014/9/10.
 */
public class HttpSSLClient
{
    static HttpSSLClient instance;

    DefaultHttpClient httpClient;
    private HttpSSLClient() {
        super();
    }

    public static HttpSSLClient getInstance()
    {
        synchronized (HttpSSLClient.class)
        {
            if(instance == null)
            {
                try {
                    instance = new HttpSSLClient();
                    instance.initInstance();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return instance;
        }
    }

    private void initInstance() throws Exception
    {
        SSLContext sslContext = SSLContext.getInstance("SSL");
        sslContext.init(null, new TrustManager[] { new X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {
                System.out.println("checkClientTrusted =============");
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {
                System.out.println("checkServerTrusted =============");
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                System.out.println("getAcceptedIssuers =============");
                return null;
            }
        }
        }, new SecureRandom());

        SSLSocketFactory sf = new SSLSocketFactory(sslContext);
        Scheme httpsScheme = new Scheme("https", 443, sf);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(httpsScheme);

// apache HttpClient version >4.2 should use BasicClientConnectionManager
        BasicClientConnectionManager cm = new BasicClientConnectionManager(schemeRegistry);
        this.httpClient = new DefaultHttpClient(cm);
    }

    public DefaultHttpClient getHttpClient() {
        return httpClient;
    }
}