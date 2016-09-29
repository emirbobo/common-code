package com.lidroid.xutils.http.client.multipart.content;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamBody
  extends AbstractContentBody
{
  private final String filename;
  private final InputStream in;
  private long length;
  
  static
  {
    JniLib.a(InputStreamBody.class, 1007);
  }
  
  public InputStreamBody(InputStream paramInputStream, long paramLong)
  {
    this(paramInputStream, paramLong, "no_name", "application/octet-stream");
  }
  
  public InputStreamBody(InputStream paramInputStream, long paramLong, String paramString)
  {
    this(paramInputStream, paramLong, paramString, "application/octet-stream");
  }
  
  public InputStreamBody(InputStream paramInputStream, long paramLong, String paramString1, String paramString2)
  {
    super(paramString2);
    if (paramInputStream == null) {
      throw new IllegalArgumentException("Input stream may not be null");
    }
    this.in = paramInputStream;
    this.filename = paramString1;
    this.length = paramLong;
  }
  
  public native String getCharset();
  
  public native long getContentLength();
  
  public native String getFilename();
  
  public native InputStream getInputStream();
  
  public native String getTransferEncoding();
  
  public native void writeTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\multipart\content\InputStreamBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */