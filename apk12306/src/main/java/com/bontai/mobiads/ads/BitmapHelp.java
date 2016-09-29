package com.bontai.mobiads.ads;

import android.content.Context;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.BitmapUtils;

public class BitmapHelp
{
  private static BitmapUtils bitmapUtils;
  
  static
  {
    JniLib.a(BitmapHelp.class, 185);
  }
  
  public static native BitmapUtils getBitmapUtils(Context paramContext);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\BitmapHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */