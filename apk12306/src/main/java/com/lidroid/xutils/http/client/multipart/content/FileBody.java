package com.lidroid.xutils.http.client.multipart.content;

import com.bangcle.andjni.JniLib;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileBody
  extends AbstractContentBody
{
  private final String charset;
  private final File file;
  private final String filename;
  
  static
  {
    JniLib.a(FileBody.class, 1006);
  }
  
  public FileBody(File paramFile)
  {
    this(paramFile, null, "application/octet-stream", null);
  }
  
  public FileBody(File paramFile, String paramString)
  {
    this(paramFile, null, paramString, null);
  }
  
  public FileBody(File paramFile, String paramString1, String paramString2)
  {
    this(paramFile, null, paramString1, paramString2);
  }
  
  public FileBody(File paramFile, String paramString1, String paramString2, String paramString3)
  {
    super(paramString2);
    if (paramFile == null) {
      throw new IllegalArgumentException("File may not be null");
    }
    this.file = paramFile;
    if (paramString1 != null) {}
    for (this.filename = paramString1;; this.filename = paramFile.getName())
    {
      this.charset = paramString3;
      return;
    }
  }
  
  public native String getCharset();
  
  public native long getContentLength();
  
  public native File getFile();
  
  public native String getFilename();
  
  public native InputStream getInputStream()
    throws IOException;
  
  public native String getTransferEncoding();
  
  public native void writeTo(OutputStream paramOutputStream)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\multipart\content\FileBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */