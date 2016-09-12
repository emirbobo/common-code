import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public final class eq
{
  private static int jdField_a_of_type_Int = 10;
  private static int b = 10000;
  private final Map<String, String> jdField_a_of_type_JavaUtilMap;
  private ThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor;
  private final DefaultHttpClient jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient;
  private final HttpContext jdField_a_of_type_OrgApacheHttpProtocolHttpContext;
  
  public eq()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, b);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(jdField_a_of_type_Int));
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 10);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, b);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, b);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, String.format("android-async-http/%s (http://loopj.com/android-async-http)", new Object[] { "1.4.1" }));
    Object localObject = new SchemeRegistry();
    ((SchemeRegistry)localObject).register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    ((SchemeRegistry)localObject).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    localObject = new ThreadSafeClientConnManager(localBasicHttpParams, (SchemeRegistry)localObject);
    this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext = new SyncBasicHttpContext(new BasicHttpContext());
    this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient = new DefaultHttpClient((ClientConnectionManager)localObject, localBasicHttpParams);
    this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.addRequestInterceptor(new er(this));
    this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.addResponseInterceptor(new es());
    this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.setHttpRequestRetryHandler(new fb());
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor = ((ThreadPoolExecutor)Executors.newCachedThreadPool());
    new WeakHashMap();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void a(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, ev paramev)
  {
    this.jdField_a_of_type_JavaUtilConcurrentThreadPoolExecutor.submit(new eu(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramev));
  }
  
  public final void a(int paramInt)
  {
    HttpParams localHttpParams = this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.getParams();
    ConnManagerParams.setTimeout(localHttpParams, paramInt);
    HttpConnectionParams.setSoTimeout(localHttpParams, paramInt);
    HttpConnectionParams.setConnectionTimeout(localHttpParams, paramInt);
  }
  
  public final void a(String paramString, ez paramez, ev paramev)
  {
    DefaultHttpClient localDefaultHttpClient = this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient;
    HttpContext localHttpContext = this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext;
    String str = paramString;
    if (paramez != null)
    {
      paramez = paramez.a();
      if (paramString.indexOf("?") != -1) {
        break label78;
      }
    }
    label78:
    for (str = paramString + "?" + paramez;; str = paramString + "&" + paramez)
    {
      a(localDefaultHttpClient, localHttpContext, new HttpGet(str), paramev);
      return;
    }
  }
  
  public final void a(SSLSocketFactory paramSSLSocketFactory)
  {
    this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", paramSSLSocketFactory, 443));
  }
  
  public final void b(String paramString, ez paramez, ev paramev)
  {
    HttpEntity localHttpEntity = null;
    if (paramez != null) {
      localHttpEntity = paramez.a();
    }
    paramez = this.jdField_a_of_type_OrgApacheHttpImplClientDefaultHttpClient;
    HttpContext localHttpContext = this.jdField_a_of_type_OrgApacheHttpProtocolHttpContext;
    paramString = new HttpPost(paramString);
    if (localHttpEntity != null) {
      paramString.setEntity(localHttpEntity);
    }
    a(paramez, localHttpContext, paramString, paramev);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\eq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */