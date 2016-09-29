package com.alipay.mobilesecuritysdk.deviceID;

import android.content.SharedPreferences;
import com.bangcle.andjni.JniLib;
import java.util.Map;
import org.json.JSONException;

public class Profile
{
  public static final String devicever = "0";
  
  static
  {
    JniLib.a(Profile.class, 39);
  }
  
  private native String MaptoString(Map<String, String> paramMap)
    throws JSONException;
  
  native String GetDataFromSharedPre(SharedPreferences paramSharedPreferences, String paramString);
  
  public native IdResponseInfo ParseResponse(String paramString);
  
  native void SetDataToSharePre(SharedPreferences paramSharedPreferences, Map<String, String> paramMap);
  
  public native String generatePrivateData(Map<String, String> paramMap)
    throws JSONException;
  
  public native String generateUploadData(Map<String, Object> paramMap);
  
  public native Map<String, String> getMap(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\deviceID\Profile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */