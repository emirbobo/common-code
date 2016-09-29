package com.lidroid.xutils;

import android.text.TextUtils;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.http.HttpCache;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseStream;
import com.lidroid.xutils.http.callback.HttpRedirectHandler;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.DefaultSSLSocketFactory;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import com.lidroid.xutils.http.client.RetryHandler;
import com.lidroid.xutils.task.PriorityExecutor;
import com.lidroid.xutils.util.OtherUtils;
import java.io.File;
import java.io.IOException;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
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
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public class HttpUtils
{
  private static final int DEFAULT_CONN_TIMEOUT = 15000;
  private static final int DEFAULT_POOL_SIZE = 3;
  private static final int DEFAULT_RETRY_TIMES = 3;
  private static final String ENCODING_GZIP = "gzip";
  private static final PriorityExecutor EXECUTOR = new PriorityExecutor(3);
  private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
  public static final HttpCache sHttpCache;
  private long currentRequestExpiry = HttpCache.getDefaultExpiryTime();
  private final DefaultHttpClient httpClient;
  private final HttpContext httpContext = new BasicHttpContext();
  private HttpRedirectHandler httpRedirectHandler;
  private String responseTextCharset = "UTF-8";
  
  static
  {
    JniLib.a(HttpUtils.class, 921);
    sHttpCache = new HttpCache();
  }
  
  public HttpUtils()
  {
    this(15000, null);
  }
  
  public HttpUtils(int paramInt)
  {
    this(paramInt, null);
  }
  
  public HttpUtils(int paramInt, String paramString)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    ConnManagerParams.setTimeout(localBasicHttpParams, paramInt);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, paramInt);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, paramInt);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = OtherUtils.getUserAgent(null);
    }
    HttpProtocolParams.setUserAgent(localBasicHttpParams, str);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(10));
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 10);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    paramString = new SchemeRegistry();
    paramString.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    paramString.register(new Scheme("https", DefaultSSLSocketFactory.getSocketFactory(), 443));
    this.httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, paramString), localBasicHttpParams);
    this.httpClient.setHttpRequestRetryHandler(new RetryHandler(3));
    this.httpClient.addRequestInterceptor(new HttpRequestInterceptor()
    {
      static
      {
        JniLib.a(1.class, 919);
      }
      
      public native void process(org.apache.http.HttpRequest paramAnonymousHttpRequest, HttpContext paramAnonymousHttpContext)
        throws org.apache.http.HttpException, IOException;
    });
    this.httpClient.addResponseInterceptor(new HttpResponseInterceptor()
    {
      static
      {
        JniLib.a(2.class, 920);
      }
      
      public native void process(HttpResponse paramAnonymousHttpResponse, HttpContext paramAnonymousHttpContext)
        throws org.apache.http.HttpException, IOException;
    });
  }
  
  public HttpUtils(String paramString)
  {
    this(15000, paramString);
  }
  
  private native <T> HttpHandler<T> sendRequest(com.lidroid.xutils.http.client.HttpRequest paramHttpRequest, RequestParams paramRequestParams, RequestCallBack<T> paramRequestCallBack);
  
  private native ResponseStream sendSyncRequest(com.lidroid.xutils.http.client.HttpRequest paramHttpRequest, RequestParams paramRequestParams)
    throws com.lidroid.xutils.exception.HttpException;
  
  public native HttpUtils configCookieStore(CookieStore paramCookieStore);
  
  public native HttpUtils configCurrentHttpCacheExpiry(long paramLong);
  
  public native HttpUtils configDefaultHttpCacheExpiry(long paramLong);
  
  public native HttpUtils configHttpCacheSize(int paramInt);
  
  public native HttpUtils configHttpRedirectHandler(HttpRedirectHandler paramHttpRedirectHandler);
  
  public native HttpUtils configRegisterScheme(Scheme paramScheme);
  
  public native HttpUtils configRequestRetryCount(int paramInt);
  
  public native HttpUtils configRequestThreadPoolSize(int paramInt);
  
  public native HttpUtils configResponseTextCharset(String paramString);
  
  public native HttpUtils configSSLSocketFactory(SSLSocketFactory paramSSLSocketFactory);
  
  public native HttpUtils configSoTimeout(int paramInt);
  
  public native HttpUtils configTimeout(int paramInt);
  
  public native HttpUtils configUserAgent(String paramString);
  
  public native HttpHandler<File> download(HttpRequest.HttpMethod paramHttpMethod, String paramString1, String paramString2, RequestParams paramRequestParams, RequestCallBack<File> paramRequestCallBack);
  
  public native HttpHandler<File> download(HttpRequest.HttpMethod paramHttpMethod, String paramString1, String paramString2, RequestParams paramRequestParams, boolean paramBoolean, RequestCallBack<File> paramRequestCallBack);
  
  public native HttpHandler<File> download(HttpRequest.HttpMethod paramHttpMethod, String paramString1, String paramString2, RequestParams paramRequestParams, boolean paramBoolean1, boolean paramBoolean2, RequestCallBack<File> paramRequestCallBack);
  
  public native HttpHandler<File> download(String paramString1, String paramString2, RequestParams paramRequestParams, RequestCallBack<File> paramRequestCallBack);
  
  public native HttpHandler<File> download(String paramString1, String paramString2, RequestParams paramRequestParams, boolean paramBoolean, RequestCallBack<File> paramRequestCallBack);
  
  public native HttpHandler<File> download(String paramString1, String paramString2, RequestParams paramRequestParams, boolean paramBoolean1, boolean paramBoolean2, RequestCallBack<File> paramRequestCallBack);
  
  public native HttpHandler<File> download(String paramString1, String paramString2, RequestCallBack<File> paramRequestCallBack);
  
  public native HttpHandler<File> download(String paramString1, String paramString2, boolean paramBoolean, RequestCallBack<File> paramRequestCallBack);
  
  public native HttpHandler<File> download(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, RequestCallBack<File> paramRequestCallBack);
  
  public native HttpClient getHttpClient();
  
  public native <T> HttpHandler<T> send(HttpRequest.HttpMethod paramHttpMethod, String paramString, RequestParams paramRequestParams, RequestCallBack<T> paramRequestCallBack);
  
  public native <T> HttpHandler<T> send(HttpRequest.HttpMethod paramHttpMethod, String paramString, RequestCallBack<T> paramRequestCallBack);
  
  public native ResponseStream sendSync(HttpRequest.HttpMethod paramHttpMethod, String paramString)
    throws com.lidroid.xutils.exception.HttpException;
  
  public native ResponseStream sendSync(HttpRequest.HttpMethod paramHttpMethod, String paramString, RequestParams paramRequestParams)
    throws com.lidroid.xutils.exception.HttpException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */