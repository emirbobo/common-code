package com.lidroid.xutils.http.client.multipart;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.http.callback.RequestCallBackHandler;
import com.lidroid.xutils.http.client.entity.UploadEntity;
import com.lidroid.xutils.http.client.multipart.content.ContentBody;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

public class MultipartEntity
  implements UploadEntity, HttpEntity
{
  private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
  private final String boundary;
  private CallBackInfo callBackInfo = new CallBackInfo();
  private final Charset charset;
  private Header contentType;
  private volatile boolean dirty;
  private long length;
  private final HttpMultipart multipart;
  private String multipartSubtype = "form-data";
  
  static
  {
    JniLib.a(MultipartEntity.class, 1004);
  }
  
  public MultipartEntity()
  {
    this(HttpMultipartMode.STRICT, null, null);
  }
  
  public MultipartEntity(HttpMultipartMode paramHttpMultipartMode)
  {
    this(paramHttpMultipartMode, null, null);
  }
  
  public MultipartEntity(HttpMultipartMode paramHttpMultipartMode, String paramString, Charset paramCharset)
  {
    String str = paramString;
    if (paramString == null) {
      str = generateBoundary();
    }
    this.boundary = str;
    paramString = paramHttpMultipartMode;
    if (paramHttpMultipartMode == null) {
      paramString = HttpMultipartMode.STRICT;
    }
    if (paramCharset != null) {}
    for (;;)
    {
      this.charset = paramCharset;
      this.multipart = new HttpMultipart(this.multipartSubtype, this.charset, this.boundary, paramString);
      this.contentType = new BasicHeader("Content-Type", generateContentType(this.boundary, this.charset));
      this.dirty = true;
      return;
      paramCharset = MIME.DEFAULT_CHARSET;
    }
  }
  
  public native void addPart(FormBodyPart paramFormBodyPart);
  
  public native void addPart(String paramString, ContentBody paramContentBody);
  
  public native void addPart(String paramString1, ContentBody paramContentBody, String paramString2);
  
  public native void consumeContent()
    throws IOException, UnsupportedOperationException;
  
  protected native String generateBoundary();
  
  protected native String generateContentType(String paramString, Charset paramCharset);
  
  public native InputStream getContent()
    throws IOException, UnsupportedOperationException;
  
  public native Header getContentEncoding();
  
  public native long getContentLength();
  
  public native Header getContentType();
  
  public native boolean isChunked();
  
  public native boolean isRepeatable();
  
  public native boolean isStreaming();
  
  public native void setCallBackHandler(RequestCallBackHandler paramRequestCallBackHandler);
  
  public native void setMultipartSubtype(String paramString);
  
  public native void writeTo(OutputStream paramOutputStream)
    throws IOException;
  
  public static class CallBackInfo
  {
    public static final CallBackInfo DEFAULT = new CallBackInfo();
    public RequestCallBackHandler callBackHandler = null;
    public long pos = 0L;
    public long totalLength = 0L;
    
    static
    {
      JniLib.a(CallBackInfo.class, 1003);
    }
    
    public native boolean doCallBack(boolean paramBoolean);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\multipart\MultipartEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */