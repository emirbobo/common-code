package com.worklight.utils;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import java.lang.reflect.InvocationTargetException;

public class PaidSecurityUtils
{
  static
  {
    JniLib.a(PaidSecurityUtils.class, 1275);
  }
  
  private static native double UFa(double paramDouble);
  
  private static native double UFr(double paramDouble);
  
  private static native void g(StringBuffer paramStringBuffer, double paramDouble);
  
  public static native byte[] kpg(Context paramContext, String[] paramArrayOfString);
  
  private static native byte[] xpg(String[] paramArrayOfString, StringBuffer paramStringBuffer, byte[] paramArrayOfByte)
    throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchMethodException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\utils\PaidSecurityUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */