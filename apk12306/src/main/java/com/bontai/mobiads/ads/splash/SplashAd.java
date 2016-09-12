package com.bontai.mobiads.ads.splash;

import android.content.Context;
import android.view.View;
import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.entity.AdDomain;

public class SplashAd
{
  private AdDomain adDomain;
  private Context context;
  private boolean isAdShowing = false;
  private boolean isSplashAdReady = false;
  private SplashAdView mAdView;
  private String placementNo;
  private SplashAdListener splashAdListener;
  
  static
  {
    JniLib.a(SplashAd.class, 207);
  }
  
  public SplashAd(Context paramContext, String paramString)
  {
    this.context = paramContext;
    this.isSplashAdReady = true;
    this.placementNo = paramString;
    this.mAdView = new SplashAdView(paramContext, this.placementNo);
  }
  
  public native void backToFrontSplash(Context paramContext, View paramView, int paramInt1, int paramInt2);
  
  public native void closeSplashAd();
  
  public native void displaySkipButton();
  
  public native AdDomain getCurrAdDomain();
  
  public native String getPlacementNo();
  
  public native boolean isNeedShowAd();
  
  public native boolean isNeedShowAgain();
  
  public native boolean isSplashAdReady();
  
  public native void jumpDetail(AdDomain paramAdDomain);
  
  public native void setKeyword(String paramString);
  
  public native void setSplashAdListener(SplashAdListener paramSplashAdListener);
  
  public native void setUserBirthdayStr(String paramString);
  
  public native void setUserGender(String paramString);
  
  public native void setUserPostcode(String paramString);
  
  public native void splash(Context paramContext, View paramView, int paramInt1, int paramInt2);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\splash\SplashAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */