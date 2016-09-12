package com.worklight.common;

import com.bangcle.andjni.JniLib;
import java.io.File;
import java.io.IOException;
import org.apache.http.HttpResponse;

class Logger$LogUploadTask$LogUploadThread
  extends Thread
{
  private String file;
  private String uri;
  
  static
  {
    JniLib.a(LogUploadThread.class, 1254);
  }
  
  public Logger$LogUploadTask$LogUploadThread(String paramString1, String paramString2)
  {
    this.uri = paramString1;
    this.file = paramString2;
  }
  
  private native void processResponse(HttpResponse paramHttpResponse, String paramString, File paramFile)
    throws IOException;
  
  public native void run();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\Logger$LogUploadTask$LogUploadThread.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */