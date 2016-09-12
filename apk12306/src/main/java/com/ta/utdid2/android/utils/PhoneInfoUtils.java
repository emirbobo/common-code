package com.ta.utdid2.android.utils;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class PhoneInfoUtils
{
  static
  {
    JniLib.a(PhoneInfoUtils.class, 1064);
  }
  
  public static native String getImei(Context paramContext);
  
  public static native String getImsi(Context paramContext);
  
  public static final native String getUniqueID();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\android\utils\PhoneInfoUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */