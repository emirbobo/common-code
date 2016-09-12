package com.bontai.mobiads.ads.splash;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.callback.DefaultBitmapLoadCallBack;

class SplashDetailAdView$SplashBitmapLoadCallBack<T extends View>
  extends DefaultBitmapLoadCallBack<T>
{
  static
  {
    JniLib.a(SplashBitmapLoadCallBack.class, 225);
  }
  
  private SplashDetailAdView$SplashBitmapLoadCallBack(SplashDetailAdView paramSplashDetailAdView) {}
  
  public native void onLoadCompleted(T paramT, String paramString, Bitmap paramBitmap, BitmapDisplayConfig paramBitmapDisplayConfig, BitmapLoadFrom paramBitmapLoadFrom);
  
  public native void onLoadFailed(T paramT, String paramString, Drawable paramDrawable);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\splash\SplashDetailAdView$SplashBitmapLoadCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */