package com.lidroid.xutils.http.client.multipart.content;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayBody
  extends AbstractContentBody
{
  private final byte[] data;
  private final String filename;
  
  static
  {
    JniLib.a(ByteArrayBody.class, 1005);
  }
  
  public ByteArrayBody(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte, "application/octet-stream", paramString);
  }
  
  public ByteArrayBody(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    super(paramString1);
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("byte[] may not be null");
    }
    this.data = paramArrayOfByte;
    this.filename = paramString2;
  }
  
  public native String getCharset();
  
  public native long getContentLength();
  
  public native String getFilename();
  
  public native String getTransferEncoding();
  
  public native void writeTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\multipart\content\ByteArrayBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */