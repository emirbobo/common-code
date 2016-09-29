package com.alipay.mobilesecuritysdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

@SuppressLint({"SimpleDateFormat"})
public class CommonUtils
{
  static
  {
    JniLib.a(CommonUtils.class, 47);
  }
  
  public static native JSONObject GetJsonFromFile(String paramString);
  
  public static native boolean GetSdCardFile();
  
  public static native boolean IsEmpty(String paramString);
  
  public static native String MD5(String paramString);
  
  public static native String ReadFile(String paramString);
  
  public static native void WriteFile(String paramString1, String paramString2)
    throws IOException;
  
  public static native String convertDate2String(Date paramDate);
  
  public static native boolean equalsIgnoreCase(String paramString1, String paramString2);
  
  public static native boolean isBlank(String paramString);
  
  public static native boolean isBlankCollection(List<String> paramList);
  
  public static native boolean isNetWorkActive(Context paramContext);
  
  public static native boolean outOfDate(long paramLong1, long paramLong2, int paramInt);
  
  public static native int string2int(String paramString);
  
  public static native long string2long(String paramString);
  
  public static native String textCompress(String paramString);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\alipay\mobilesecuritysdk\util\CommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */