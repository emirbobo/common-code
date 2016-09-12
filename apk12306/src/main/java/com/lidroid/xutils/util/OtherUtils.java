package com.lidroid.xutils.util;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

public class OtherUtils
{
  private static final int STRING_BUFFER_LENGTH = 100;
  private static SSLSocketFactory sslSocketFactory;
  
  static
  {
    JniLib.a(OtherUtils.class, 1026);
  }
  
  public static native long getAvailableSpace(File paramFile);
  
  public static native StackTraceElement getCallerStackTraceElement();
  
  public static native Charset getCharsetFromHttpRequest(HttpRequestBase paramHttpRequestBase);
  
  public static native StackTraceElement getCurrentStackTraceElement();
  
  public static native String getDiskCacheDir(Context paramContext, String paramString);
  
  public static native String getFileNameFromHttpResponse(HttpResponse paramHttpResponse);
  
  public static native String getSubString(String paramString, int paramInt1, int paramInt2);
  
  public static native String getUserAgent(Context paramContext);
  
  public static native boolean isSupportRange(HttpResponse paramHttpResponse);
  
  public static native long sizeOfString(String paramString1, String paramString2)
    throws UnsupportedEncodingException;
  
  public static native void trustAllHttpsURLConnection();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\util\OtherUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */