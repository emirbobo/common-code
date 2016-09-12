import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public final class cj
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private static KeyManagerFactory jdField_a_of_type_JavaxNetSslKeyManagerFactory;
  private static TrustManagerFactory jdField_a_of_type_JavaxNetSslTrustManagerFactory;
  private SSLContext jdField_a_of_type_JavaxNetSslSSLContext = SSLContext.getInstance("TLSv1");
  
  public cj(KeyStore paramKeyStore)
    throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException
  {
    super(paramKeyStore);
    new ck();
    this.jdField_a_of_type_JavaxNetSslSSLContext.init(jdField_a_of_type_JavaxNetSslKeyManagerFactory.getKeyManagers(), jdField_a_of_type_JavaxNetSslTrustManagerFactory.getTrustManagers(), null);
  }
  
  public static KeyStore a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws IOException, KeyStoreException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException, KeyManagementException
  {
    paramString1 = new ByteArrayInputStream(at.a(paramString1));
    paramString2 = new ByteArrayInputStream(at.a(paramString2));
    paramString3 = new ByteArrayInputStream(at.a(paramString3));
    Security.addProvider(new il());
    Object localObject = new iq(new InputStreamReader(paramString1));
    paramString1 = (X509Certificate)((iq)localObject).a();
    ((iq)localObject).close();
    localObject = new iq(new InputStreamReader(paramString2));
    paramString2 = (X509Certificate)((iq)localObject).a();
    ((iq)localObject).close();
    localObject = new iq(new InputStreamReader(paramString3), new cl(paramString4));
    paramString3 = (KeyPair)((iq)localObject).a();
    ((iq)localObject).close();
    localObject = KeyStore.getInstance(paramString5);
    ((KeyStore)localObject).load(null, null);
    ((KeyStore)localObject).setCertificateEntry("ca-certificate", paramString1);
    paramString1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    jdField_a_of_type_JavaxNetSslTrustManagerFactory = paramString1;
    paramString1.init((KeyStore)localObject);
    paramString1 = KeyStore.getInstance(paramString5);
    paramString1.load(null, null);
    paramString1.setCertificateEntry("certificate", paramString2);
    paramString1.setKeyEntry("private-key", paramString3.getPrivate(), paramString4.toCharArray(), new Certificate[] { paramString2 });
    paramString2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    jdField_a_of_type_JavaxNetSslKeyManagerFactory = paramString2;
    paramString2.init(paramString1, paramString4.toCharArray());
    return paramString1;
  }
  
  public final Socket createSocket()
    throws IOException
  {
    return this.jdField_a_of_type_JavaxNetSslSSLContext.getSocketFactory().createSocket();
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
    throws IOException, UnknownHostException
  {
    return this.jdField_a_of_type_JavaxNetSslSSLContext.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */