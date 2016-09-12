package com.bontai.mobiads.ads.splash;

import android.graphics.Bitmap;
import android.view.View;
import com.bangcle.andjni.JniLib;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.callback.DefaultBitmapLoadCallBack;

class SplashAdView$SplashBitmapLoadCallBack<T extends View>
  extends DefaultBitmapLoadCallBack<T>
{
  static
  {
    JniLib.a(SplashBitmapLoadCallBack.class, 220);
  }
  
  private SplashAdView$SplashBitmapLoadCallBack(SplashAdView paramSplashAdView) {}
  
  public native void onLoadCompleted(T paramT, String paramString, Bitmap paramBitmap, BitmapDisplayConfig paramBitmapDisplayConfig, BitmapLoadFrom paramBitmapLoadFrom);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\splash\SplashAdView$SplashBitmapLoadCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */