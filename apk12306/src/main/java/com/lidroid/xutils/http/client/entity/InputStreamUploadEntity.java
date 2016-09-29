package com.lidroid.xutils.http.client.entity;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.http.callback.RequestCallBackHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.entity.AbstractHttpEntity;

public class InputStreamUploadEntity
  extends AbstractHttpEntity
  implements UploadEntity
{
  private static final int BUFFER_SIZE = 2048;
  private RequestCallBackHandler callBackHandler = null;
  private final InputStream content;
  private final long length;
  private long uploadedSize = 0L;
  
  static
  {
    JniLib.a(InputStreamUploadEntity.class, 998);
  }
  
  public InputStreamUploadEntity(InputStream paramInputStream, long paramLong)
  {
    if (paramInputStream == null) {
      throw new IllegalArgumentException("Source input stream may not be null");
    }
    this.content = paramInputStream;
    this.length = paramLong;
  }
  
  public native void consumeContent()
    throws IOException;
  
  public native InputStream getContent()
    throws IOException;
  
  public native long getContentLength();
  
  public native boolean isRepeatable();
  
  public native boolean isStreaming();
  
  public native void setCallBackHandler(RequestCallBackHandler paramRequestCallBackHandler);
  
  public native void writeTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\entity\InputStreamUploadEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */