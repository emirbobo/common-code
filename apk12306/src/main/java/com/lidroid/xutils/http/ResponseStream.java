package com.lidroid.xutils.http;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

public class ResponseStream
  extends InputStream
{
  private String _directResult;
  private HttpResponse baseResponse;
  private InputStream baseStream;
  private String charset;
  private long expiry;
  private String requestMethod;
  private String requestUrl;
  
  static
  {
    JniLib.a(ResponseStream.class, 986);
  }
  
  public ResponseStream(String paramString)
    throws IOException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("result may not be null");
    }
    this._directResult = paramString;
  }
  
  public ResponseStream(HttpResponse paramHttpResponse, String paramString, long paramLong)
    throws IOException
  {
    this(paramHttpResponse, "UTF-8", paramString, paramLong);
  }
  
  public ResponseStream(HttpResponse paramHttpResponse, String paramString1, String paramString2, long paramLong)
    throws IOException
  {
    if (paramHttpResponse == null) {
      throw new IllegalArgumentException("baseResponse may not be null");
    }
    this.baseResponse = paramHttpResponse;
    this.baseStream = paramHttpResponse.getEntity().getContent();
    this.charset = paramString1;
    this.requestUrl = paramString2;
    this.expiry = paramLong;
  }
  
  public native int available()
    throws IOException;
  
  public native void close()
    throws IOException;
  
  public native HttpResponse getBaseResponse();
  
  public native InputStream getBaseStream();
  
  public native long getContentLength();
  
  public native Locale getLocale();
  
  public native String getReasonPhrase();
  
  public native String getRequestMethod();
  
  public native String getRequestUrl();
  
  public native int getStatusCode();
  
  public native void mark(int paramInt);
  
  public native boolean markSupported();
  
  public native int read()
    throws IOException;
  
  public native int read(byte[] paramArrayOfByte)
    throws IOException;
  
  public native int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public native void readFile(String paramString)
    throws IOException;
  
  public native String readString()
    throws IOException;
  
  public native void reset()
    throws IOException;
  
  native void setRequestMethod(String paramString);
  
  public native long skip(long paramLong)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\ResponseStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */