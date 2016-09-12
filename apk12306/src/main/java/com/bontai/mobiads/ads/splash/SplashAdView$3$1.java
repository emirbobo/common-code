package com.bontai.mobiads.ads.splash;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.bangcle.andjni.JniLib;

class SplashAdView$3$1
  implements Animation.AnimationListener
{
  static
  {
    JniLib.a(1.class, 210);
  }
  
  SplashAdView$3$1(SplashAdView.3 param3) {}
  
  public native void onAnimationEnd(Animation paramAnimation);
  
  public native void onAnimationRepeat(Animation paramAnimation);
  
  public native void onAnimationStart(Animation paramAnimation);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\splash\SplashAdView$3$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */