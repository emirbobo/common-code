package com.alipay.mobilesecuritysdk.deviceID;

import android.content.SharedPreferences;
import com.bangcle.andjni.JniLib;
import java.util.Map;

public class DataShare
{
  static
  {
    JniLib.a(DataShare.class, 31);
  }
  
  native String GetDataFromSharedPre(SharedPreferences paramSharedPreferences, String paramString);
  
  native void SetDataToSharePre(SharedPreferences paramSharedPreferences, Map<String, String> paramMap);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\deviceID\DataShare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */