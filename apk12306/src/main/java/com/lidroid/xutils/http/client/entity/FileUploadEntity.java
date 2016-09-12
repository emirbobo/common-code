package com.lidroid.xutils.http.client.entity;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.http.callback.RequestCallBackHandler;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.entity.FileEntity;

public class FileUploadEntity
  extends FileEntity
  implements UploadEntity
{
  private RequestCallBackHandler callBackHandler = null;
  private long fileSize;
  private long uploadedSize = 0L;
  
  static
  {
    JniLib.a(FileUploadEntity.class, 996);
  }
  
  public FileUploadEntity(File paramFile, String paramString)
  {
    super(paramFile, paramString);
    this.fileSize = paramFile.length();
  }
  
  public native void setCallBackHandler(RequestCallBackHandler paramRequestCallBackHandler);
  
  public native void writeTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\entity\FileUploadEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */