package com.alipay.sdk.util;

import com.bangcle.andjni.JniLib;
import org.json.JSONObject;

public class JsonUtils
{
  static
  {
    JniLib.a(JsonUtils.class, 134);
  }
  
  public static native String a(String paramString);
  
  public static native String a(String paramString1, String paramString2);
  
  public static native JSONObject a(JSONObject paramJSONObject1, JSONObject paramJSONObject2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\sdk\util\JsonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */