package lsy.ssltest1;

import io.netty.handler.codec.http.HttpMethod;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.security.cert.X509Certificate;

import static org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;

/**
 * Created by Administrator on 2014/9/10.
 */
public class Testor1
{
    public static void main(String[] args) {
        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();
        DefaultHttpClient httpClient = (DefaultHttpClient) requestFactory.getHttpClient();
        TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
            @Override
            public boolean isTrusted(X509Certificate[] certificate, String authType) {
                return true;
            }
        };



//        SSLSocketFactory sf = SSLSocketFactory.getDefault();
        SocketFactory sf = SSLSocketFactory.getDefault();
//        (acceptingTrustStrategy, ALLOW_ALL_HOSTNAME_VERIFIER);
//        SSLSocketFactory sf = new SSLSocketFactory(acceptingTrustStrategy, ALLOW_ALL_HOSTNAME_VERIFIER);
//        DefaultSSLSocketFactory sf ;
//        httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", 8443, sf));

//        String urlHttps = "";
//        ResponseEntity<String> response = new RestTemplate(requestFactory).exchange(urlHttps, HttpMethod.GET, null, String.class);


//        ConsoleUtil.info();

//        assertThat(response.getStatusCode().value(), equalTo(200));
    }
}
