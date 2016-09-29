package com.alipay.sdk.net;

import android.content.Context;
import com.alipay.sdk.data.InteractionData;
import com.alipay.sdk.exception.NetErrorException;
import com.bangcle.andjni.JniLib;
import org.apache.http.HttpResponse;

public class RequestUtils
{
  private static MspClient a;
  
  static
  {
    JniLib.a(RequestUtils.class, 115);
  }
  
  public static native String a(String paramString);
  
  public static native String a(HttpResponse paramHttpResponse)
    throws NetErrorException;
  
  public static native HttpResponse a(Context paramContext, String paramString1, String paramString2)
    throws NetErrorException;
  
  public static native HttpResponse a(Context paramContext, String paramString1, String paramString2, InteractionData paramInteractionData)
    throws NetErrorException;
  
  public static native void a();
  
  public static native String b(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\net\RequestUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */