package com.lidroid.xutils.http.client.multipart;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.util.ByteArrayBuffer;

class HttpMultipart
{
  private static final ByteArrayBuffer CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
  private static final ByteArrayBuffer FIELD_SEP;
  private static final ByteArrayBuffer TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
  private final String boundary;
  private final Charset charset;
  private final HttpMultipartMode mode;
  private final List<FormBodyPart> parts;
  private String subType;
  
  static
  {
    JniLib.a(HttpMultipart.class, 1000);
    FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
  }
  
  public HttpMultipart(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2);
  }
  
  public HttpMultipart(String paramString1, Charset paramCharset, String paramString2)
  {
    this(paramString1, paramCharset, paramString2, HttpMultipartMode.STRICT);
  }
  
  public HttpMultipart(String paramString1, Charset paramCharset, String paramString2, HttpMultipartMode paramHttpMultipartMode)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Multipart subtype may not be null");
    }
    if (paramString2 == null) {
      throw new IllegalArgumentException("Multipart boundary may not be null");
    }
    this.subType = paramString1;
    if (paramCharset != null) {}
    for (;;)
    {
      this.charset = paramCharset;
      this.boundary = paramString2;
      this.parts = new ArrayList();
      this.mode = paramHttpMultipartMode;
      return;
      paramCharset = MIME.DEFAULT_CHARSET;
    }
  }
  
  private native void doWriteTo(HttpMultipartMode paramHttpMultipartMode, OutputStream paramOutputStream, MultipartEntity.CallBackInfo paramCallBackInfo, boolean paramBoolean)
    throws IOException;
  
  private native void doWriteTo(HttpMultipartMode paramHttpMultipartMode, OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException;
  
  private static native ByteArrayBuffer encode(Charset paramCharset, String paramString);
  
  private static native void writeBytes(String paramString, OutputStream paramOutputStream)
    throws IOException;
  
  private static native void writeBytes(String paramString, Charset paramCharset, OutputStream paramOutputStream)
    throws IOException;
  
  private static native void writeBytes(ByteArrayBuffer paramByteArrayBuffer, OutputStream paramOutputStream)
    throws IOException;
  
  private static native void writeField(MinimalField paramMinimalField, OutputStream paramOutputStream)
    throws IOException;
  
  private static native void writeField(MinimalField paramMinimalField, Charset paramCharset, OutputStream paramOutputStream)
    throws IOException;
  
  public native void addBodyPart(FormBodyPart paramFormBodyPart);
  
  public native List<FormBodyPart> getBodyParts();
  
  public native String getBoundary();
  
  public native Charset getCharset();
  
  public native HttpMultipartMode getMode();
  
  public native String getSubType();
  
  public native long getTotalLength();
  
  public native void setSubType(String paramString);
  
  public native void writeTo(OutputStream paramOutputStream, MultipartEntity.CallBackInfo paramCallBackInfo)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\multipart\HttpMultipart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */