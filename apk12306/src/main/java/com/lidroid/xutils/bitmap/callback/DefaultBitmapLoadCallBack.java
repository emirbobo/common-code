package com.lidroid.xutils.bitmap.callback;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;

public class DefaultBitmapLoadCallBack<T extends View>
  extends BitmapLoadCallBack<T>
{
  static
  {
    JniLib.a(DefaultBitmapLoadCallBack.class, 219);
  }
  
  private native void animationDisplay(T paramT, Animation paramAnimation);
  
  public native void onLoadCompleted(T paramT, String paramString, Bitmap paramBitmap, BitmapDisplayConfig paramBitmapDisplayConfig, BitmapLoadFrom paramBitmapLoadFrom);
  
  public native void onLoadFailed(T paramT, String paramString, Drawable paramDrawable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\lidroid\xutils\bitmap\callback\DefaultBitmapLoadCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */