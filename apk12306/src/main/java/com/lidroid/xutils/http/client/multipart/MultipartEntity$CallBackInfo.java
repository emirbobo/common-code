package com.lidroid.xutils.http.client.multipart;

import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.http.callback.RequestCallBackHandler;

public class MultipartEntity$CallBackInfo
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\http\client\multipart\MultipartEntity$CallBackInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */