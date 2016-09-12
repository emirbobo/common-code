package com.lidroid.xutils.http.client.util;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.util.LogUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.NameValuePair;

public class URIBuilder
{
  private String encodedAuthority;
  private String encodedFragment;
  private String encodedPath;
  private String encodedQuery;
  private String encodedSchemeSpecificPart;
  private String encodedUserInfo;
  private String fragment;
  private String host;
  private String path;
  private int port;
  private List<NameValuePair> queryParams;
  private String scheme;
  private String userInfo;
  
  static
  {
    JniLib.a(URIBuilder.class, 1009);
  }
  
  public URIBuilder()
  {
    this.port = -1;
  }
  
  public URIBuilder(String paramString)
  {
    try
    {
      URI localURI = new java/net/URI;
      localURI.<init>(paramString);
      digestURI(localURI);
      return;
    }
    catch (URISyntaxException paramString)
    {
      for (;;)
      {
        LogUtils.e(paramString.getMessage(), paramString);
      }
    }
  }
  
  public URIBuilder(URI paramURI)
  {
    digestURI(paramURI);
  }
  
  private native String buildString(Charset paramCharset);
  
  private native void digestURI(URI paramURI);
  
  private native String encodeFragment(String paramString, Charset paramCharset);
  
  private native String encodePath(String paramString, Charset paramCharset);
  
  private native String encodeQuery(List<NameValuePair> paramList, Charset paramCharset);
  
  private native String encodeUserInfo(String paramString, Charset paramCharset);
  
  private static native String normalizePath(String paramString);
  
  private native List<NameValuePair> parseQuery(String paramString);
  
  public native URIBuilder addParameter(String paramString1, String paramString2);
  
  public native URI build(Charset paramCharset)
    throws URISyntaxException;
  
  public native String getFragment();
  
  public native String getHost();
  
  public native String getPath();
  
  public native int getPort();
  
  public native List<NameValuePair> getQueryParams();
  
  public native String getScheme();
  
  public native String getUserInfo();
  
  public native URIBuilder setFragment(String paramString);
  
  public native URIBuilder setHost(String paramString);
  
  public native URIBuilder setParameter(String paramString1, String paramString2);
  
  public native URIBuilder setPath(String paramString);
  
  public native URIBuilder setPort(int paramInt);
  
  public native URIBuilder setQuery(String paramString);
  
  public native URIBuilder setScheme(String paramString);
  
  public native URIBuilder setUserInfo(String paramString);
  
  public native URIBuilder setUserInfo(String paramString1, String paramString2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\util\URIBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */