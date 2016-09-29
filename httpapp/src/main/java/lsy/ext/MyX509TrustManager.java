package lsy.ext;

/**
 * Created by Administrator on 2016/9/11.
 */
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.*;

public class MyX509TrustManager implements X509TrustManager {
	/*
	 * The default X509TrustManager returned by SunX509.  We'll delegate
	 * decisions to it, and fall back to the logic in this class if the
	 * default X509TrustManager doesn't trust it.
	 */
	X509TrustManager sunJSSEX509TrustManager;
	MyX509TrustManager() throws Exception {
		// create a "default" JSSE X509TrustManager.
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(new FileInputStream("trustedCerts"),
				"passphrase".toCharArray());
		TrustManagerFactory tmf =
				TrustManagerFactory.getInstance("SunX509", "SunJSSE");
		tmf.init(ks);
		TrustManager tms [] = tmf.getTrustManagers();
        /*
         * Iterate over the returned trustmanagers, look
         * for an instance of X509TrustManager.  If found,
         * use that as our "default" trust manager.
         */
		for (int i = 0; i < tms.length; i++) {
			if (tms[i] instanceof X509TrustManager) {
				sunJSSEX509TrustManager = (X509TrustManager) tms[i];
				return;
			}
		}
        /*
         * Find some other way to initialize, or else we have to fail the
         * constructor.
         */
		throw new Exception("Couldn't initialize");
	}
	/*
	 * Delegate to the default trust manager.
	 */
	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		try {
			sunJSSEX509TrustManager.checkClientTrusted(chain, authType);
		} catch (CertificateException excep) {
			// do any special handling here, or rethrow exception.
		}
	}
	/*
	 * Delegate to the default trust manager.
	 */
	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		try {
			sunJSSEX509TrustManager.checkServerTrusted(chain, authType);
		} catch (CertificateException excep) {
            /*
             * Possibly pop up a dialog box asking whether to trust the
             * cert chain.
             */
		}
	}
	/*
	 * Merely pass this through.
	 */
	public X509Certificate[] getAcceptedIssuers() {
		return sunJSSEX509TrustManager.getAcceptedIssuers();
	}

	public static void main(String[] args) throws Exception {

// ����SSLContext���󣬲�ʹ������ָ�������ι�������ʼ��
		TrustManager[] tm = { new MyX509TrustManager() };
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		sslContext.init(null, tm, new java.security.SecureRandom());
		// ������SSLContext�����еõ�SSLSocketFactory����
		SSLSocketFactory ssf = sslContext.getSocketFactory();
		// ����URL����
		URL myURL = new URL("https://ebanks.gdb.com.cn/sperbank/perbankLogin.jsp");
		// ����HttpsURLConnection���󣬲�������SSLSocketFactory����
		HttpsURLConnection httpsConn = (HttpsURLConnection) myURL.openConnection();
		httpsConn.setSSLSocketFactory(ssf);
		// ȡ�ø����ӵ����������Զ�ȡ��Ӧ����
		InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream());
		// ��ȡ����������Ӧ���ݲ���ʾ
		int respInt = insr.read();
		while (respInt != -1) {
			System.out.print((char) respInt);
			respInt = insr.read();
		}

	}
}