package com.MobileTicket;

import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.entity.AdDomain;
import com.bontai.mobiads.ads.splash.SplashAdListener;

class MobileTicket$2
  implements SplashAdListener
{
  static
  {
    JniLib.a(2.class, 7);
  }
  
  MobileTicket$2(MobileTicket paramMobileTicket) {}
  
  public native void onSplashDismiss();
  
  public native void onSplashJumpDetail(AdDomain paramAdDomain);
  
  public native void onSplashLoadFailed();
  
  public native void onSplashPresent();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\MobileTicket$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */