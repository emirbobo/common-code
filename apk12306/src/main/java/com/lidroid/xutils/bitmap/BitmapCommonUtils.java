package com.lidroid.xutils.bitmap;

import android.content.Context;
import android.view.View;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.bitmap.core.BitmapSize;

public class BitmapCommonUtils
{
  private static BitmapSize screenSize = null;
  
  static
  {
    JniLib.a(BitmapCommonUtils.class, 923);
  }
  
  private static native int getImageViewFieldValue(Object paramObject, String paramString);
  
  public static native BitmapSize getScreenSize(Context paramContext);
  
  public static native BitmapSize optimizeMaxSizeByView(View paramView, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\BitmapCommonUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */