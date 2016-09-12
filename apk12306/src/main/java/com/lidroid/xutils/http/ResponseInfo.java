package com.lidroid.xutils.http;

import com.bangcle.andjni.JniLib;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;

public final class ResponseInfo<T>
{
  public final Header contentEncoding;
  public final long contentLength;
  public final Header contentType;
  public final Locale locale;
  public final ProtocolVersion protocolVersion;
  public final String reasonPhrase;
  private final HttpResponse response;
  public T result;
  public final boolean resultFormCache;
  public final int statusCode;
  
  static
  {
    JniLib.a(ResponseInfo.class, 985);
  }
  
  public ResponseInfo(HttpResponse paramHttpResponse, T paramT, boolean paramBoolean)
  {
    this.response = paramHttpResponse;
    this.result = paramT;
    this.resultFormCache = paramBoolean;
    if (paramHttpResponse != null)
    {
      this.locale = paramHttpResponse.getLocale();
      paramT = paramHttpResponse.getStatusLine();
      if (paramT != null)
      {
        this.statusCode = paramT.getStatusCode();
        this.protocolVersion = paramT.getProtocolVersion();
        this.reasonPhrase = paramT.getReasonPhrase();
        paramHttpResponse = paramHttpResponse.getEntity();
        if (paramHttpResponse == null) {
          break label134;
        }
        this.contentLength = paramHttpResponse.getContentLength();
        this.contentType = paramHttpResponse.getContentType();
        this.contentEncoding = paramHttpResponse.getContentEncoding();
      }
    }
    for (;;)
    {
      return;
      this.statusCode = 0;
      this.protocolVersion = null;
      this.reasonPhrase = null;
      break;
      label134:
      this.contentLength = 0L;
      this.contentType = null;
      this.contentEncoding = null;
      continue;
      this.locale = null;
      this.statusCode = 0;
      this.protocolVersion = null;
      this.reasonPhrase = null;
      this.contentLength = 0L;
      this.contentType = null;
      this.contentEncoding = null;
    }
  }
  
  public native Header[] getAllHeaders();
  
  public native Header getFirstHeader(String paramString);
  
  public native Header[] getHeaders(String paramString);
  
  public native Header getLastHeader(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\ResponseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */