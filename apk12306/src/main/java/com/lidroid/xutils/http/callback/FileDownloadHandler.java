package com.lidroid.xutils.http.callback;

import com.bangcle.andjni.JniLib;
import java.io.File;
import java.io.IOException;
import org.apache.http.HttpEntity;

public class FileDownloadHandler
{
  static
  {
    JniLib.a(FileDownloadHandler.class, 989);
  }
  
  public native File handleEntity(HttpEntity paramHttpEntity, RequestCallBackHandler paramRequestCallBackHandler, String paramString1, boolean paramBoolean, String paramString2)
    throws IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\callback\FileDownloadHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */