package com.bontai.mobiads.ads.activity;

import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.entity.AdDomain;
import com.bontai.mobiads.ads.splash.SplashAdListener;

class SplashDetailADActivity$1
  implements SplashAdListener
{
  static
  {
    JniLib.a(1.class, 194);
  }
  
  SplashDetailADActivity$1(SplashDetailADActivity paramSplashDetailADActivity) {}
  
  public native void onSplashDismiss();
  
  public native void onSplashJumpDetail(AdDomain paramAdDomain);
  
  public native void onSplashLoadFailed();
  
  public native void onSplashPresent();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\activity\SplashDetailADActivity$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */