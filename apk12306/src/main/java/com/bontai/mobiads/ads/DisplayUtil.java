package com.bontai.mobiads.ads;

import android.content.Context;
import com.bangcle.andjni.JniLib;

public class DisplayUtil
{
  public static final int CHINESE = 0;
  public static final int NUMBER_OR_CHARACTER = 1;
  
  static
  {
    JniLib.a(DisplayUtil.class, 188);
  }
  
  public static native int dip2px(Context paramContext, float paramFloat);
  
  public static native int px2dip(Context paramContext, float paramFloat);
  
  public static native float sp2px(Context paramContext, float paramFloat, int paramInt);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\DisplayUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */