package com.tl.uic.util;

import android.os.AsyncTask;
import com.bangcle.andjni.JniLib;
import com.tl.uic.TLFCache;

public class PostTask
  extends AsyncTask<Void, Void, Boolean>
{
  private static final int BUFFER_SIZE = 40;
  
  static
  {
    JniLib.a(PostTask.class, 1123);
  }
  
  private native void logResult(String paramString1, String paramString2, Boolean paramBoolean);
  
  private native Boolean sendMessageFormat();
  
  protected final Boolean doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = Boolean.valueOf(false);
    try
    {
      Boolean localBoolean = sendMessageFormat();
      paramVarArgs = localBoolean;
      TLFCache.closePostTask();
      paramVarArgs = Boolean.valueOf(true);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogInternal.logException(localException);
      }
    }
    return paramVarArgs;
  }
  
  public final native Boolean flush();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\PostTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */