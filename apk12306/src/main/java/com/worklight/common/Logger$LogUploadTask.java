package com.worklight.common;

import android.os.AsyncTask;
import com.bangcle.andjni.JniLib;
import java.io.File;
import java.io.IOException;
import org.apache.http.HttpResponse;

class Logger$LogUploadTask
  extends AsyncTask<String, Void, Void>
{
  protected Void doInBackground(String... paramVarArgs)
  {
    paramVarArgs = new LogUploadThread(paramVarArgs[0], paramVarArgs[1]);
    paramVarArgs.setPriority(1);
    paramVarArgs.start();
    return null;
  }
  
  private static class LogUploadThread
    extends Thread
  {
    private String file;
    private String uri;
    
    static
    {
      JniLib.a(LogUploadThread.class, 1254);
    }
    
    public LogUploadThread(String paramString1, String paramString2)
    {
      this.uri = paramString1;
      this.file = paramString2;
    }
    
    private native void processResponse(HttpResponse paramHttpResponse, String paramString, File paramFile)
      throws IOException;
    
    public native void run();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\Logger$LogUploadTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */