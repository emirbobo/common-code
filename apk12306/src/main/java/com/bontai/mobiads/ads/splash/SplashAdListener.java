package com.bontai.mobiads.ads.splash;

import com.bontai.mobiads.ads.entity.AdDomain;

public abstract interface SplashAdListener
{
  public abstract void onSplashDismiss();
  
  public abstract void onSplashJumpDetail(AdDomain paramAdDomain);
  
  public abstract void onSplashLoadFailed();
  
  public abstract void onSplashPresent();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\splash\SplashAdListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */