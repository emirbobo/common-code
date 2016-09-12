package com.MobileTicket;

import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.splash.WebViewListenerMA;

class MobileTicket$1
  implements WebViewListenerMA
{
  static
  {
    JniLib.a(1.class, 6);
  }
  
  MobileTicket$1(MobileTicket paramMobileTicket) {}
  
  public native void onPageFinished();
  
  public native void onPageStart();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\MobileTicket$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */