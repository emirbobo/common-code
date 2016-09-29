package com.bontai.mobiads.ads.splash;

import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.entity.AdDomain;

class SplashAdView$5
  implements SplashAdListener
{
  static
  {
    JniLib.a(5.class, 213);
  }
  
  SplashAdView$5(SplashAdView paramSplashAdView) {}
  
  public native void onSplashDismiss();
  
  public native void onSplashJumpDetail(AdDomain paramAdDomain);
  
  public native void onSplashLoadFailed();
  
  public native void onSplashPresent();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\splash\SplashAdView$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */