package com.lidroid.xutils.http.client.multipart.content;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class StringBody
  extends AbstractContentBody
{
  private final Charset charset;
  private final byte[] content;
  
  static
  {
    JniLib.a(StringBody.class, 1008);
  }
  
  public StringBody(String paramString)
    throws UnsupportedEncodingException
  {
    this(paramString, "text/plain", null);
  }
  
  public StringBody(String paramString1, String paramString2, Charset paramCharset)
    throws UnsupportedEncodingException
  {
    super(paramString2);
    if (paramString1 == null) {
      throw new IllegalArgumentException("Text may not be null");
    }
    paramString2 = paramCharset;
    if (paramCharset == null) {
      paramString2 = Charset.forName("UTF-8");
    }
    this.content = paramString1.getBytes(paramString2.name());
    this.charset = paramString2;
  }
  
  public StringBody(String paramString, Charset paramCharset)
    throws UnsupportedEncodingException
  {
    this(paramString, "text/plain", paramCharset);
  }
  
  public static native StringBody create(String paramString)
    throws IllegalArgumentException;
  
  public static native StringBody create(String paramString1, String paramString2, Charset paramCharset)
    throws IllegalArgumentException;
  
  public static native StringBody create(String paramString, Charset paramCharset)
    throws IllegalArgumentException;
  
  public native String getCharset();
  
  public native long getContentLength();
  
  public native String getFilename();
  
  public native Reader getReader();
  
  public native String getTransferEncoding();
  
  public native void writeTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\multipart\content\StringBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */