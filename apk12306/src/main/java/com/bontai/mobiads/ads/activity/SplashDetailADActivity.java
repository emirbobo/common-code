package com.bontai.mobiads.ads.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.entity.AdDomain;
import com.bontai.mobiads.ads.splash.SplashAdListener;
import com.bontai.mobiads.ads.splash.SplashDetailAd;

public class SplashDetailADActivity
  extends Activity
{
  private ImageView btnClose;
  private SplashDetailAd splashDetailAd;
  private LinearLayout splashDetailLL;
  
  static
  {
    JniLib.a(SplashDetailADActivity.class, 197);
  }
  
  private native void jump();
  
  private native void viewInited();
  
  @SuppressLint({"NewApi"})
  protected native void onCreate(Bundle paramBundle);
  
  protected native void onDestroy();
  
  protected native void onPause();
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\activity\SplashDetailADActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */