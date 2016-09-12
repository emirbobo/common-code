package com.lidroid.xutils.http.callback;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import org.apache.http.HttpEntity;

public class StringDownloadHandler
{
  static
  {
    JniLib.a(StringDownloadHandler.class, 990);
  }
  
  public native String handleEntity(HttpEntity paramHttpEntity, RequestCallBackHandler paramRequestCallBackHandler, String paramString)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\callback\StringDownloadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */