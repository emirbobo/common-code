package com.tl.uic.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.bangcle.andjni.JniLib;

public final class ImageUtil
{
  private static final int PERCENT = 100;
  private static volatile ImageUtil _myInstance;
  
  static
  {
    JniLib.a(ImageUtil.class, 1119);
  }
  
  public static native ImageUtil getInstance();
  
  private static native View getMainView(View paramView);
  
  private static native Boolean saveImageAsPNG(Bitmap paramBitmap, Context paramContext, String paramString1, String paramString2);
  
  public static native Boolean snapShot(View paramView, String paramString1, String paramString2);
  
  private static native Boolean snapShotHelper(Context paramContext, View paramView, String paramString, StringBuffer paramStringBuffer);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\tl\uic\util\ImageUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */