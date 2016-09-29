package com.alipay.sdk.data;

import com.alipay.sdk.exception.UnZipException;
import com.bangcle.andjni.JniLib;
import org.apache.http.HttpResponse;
import org.json.JSONObject;

public class FrameUtils
{
  private static final String a = "Msp-Param";
  
  static
  {
    JniLib.a(FrameUtils.class, 98);
  }
  
  public static native Request a();
  
  public static native Request a(InteractionData paramInteractionData, String paramString, JSONObject paramJSONObject, boolean paramBoolean);
  
  private static native Request a(JSONObject paramJSONObject, boolean paramBoolean);
  
  private static native String a(String paramString);
  
  private static native void a(InteractionData paramInteractionData, Request paramRequest, String paramString);
  
  public static native void a(InteractionData paramInteractionData, HttpResponse paramHttpResponse);
  
  public static native byte[] a(byte[] paramArrayOfByte)
    throws UnZipException;
  
  private static native String b(String paramString);
  
  private static native String c(String paramString);
  
  private static native String d(String paramString);
  
  private static native String e(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\data\FrameUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */