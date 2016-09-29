package com.MobileTicket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.dbox.ui.DBoxManager;
import cn.domob.wall.core.DService;
import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.entity.AdDomain;
import com.bontai.mobiads.ads.splash.SplashAd;
import com.bontai.mobiads.ads.splash.SplashAdListener;
import com.bontai.mobiads.ads.splash.WebViewListenerMA;
import com.worklight.androidgap.SSLWLDroidGap;
import org.apache.cordova.CordovaWebView;

public class MobileTicket
  extends SSLWLDroidGap
{
  public static final int HONEYCOMB = 11;
  public static final String LASTUPDATETIME = "lastUpdateTime";
  private static final int PAGE_FINISH_MA = 1;
  private static final int PAGE_START_MA = 0;
  public static final String PI = "packageinfo";
  private static final String PLACEMENTID = "16TLm30oApUDwNUIALmsZy2s";
  private static final String PUBLISHERID = "56OJz4SIuNDdkwD4yB";
  private static final String PUBLISHER_ID_AD = "56OJz4SIuNDdkwD4yB";
  private static final int SPLASH_FINISH_MA = 3;
  private static final int SPLASH_START_MA = 2;
  private static final String SplashPPID_AD = "16TLm30oApUDwNU0ucjiVWli";
  public static DBoxManager mDBoxManager;
  public static DService mDService;
  public static final String placementID_DBox = "16TLm30oApUDwNU062W4ftVs";
  public static final String publisherID_DBOX = "56OJz4SIuNDdkwD4yB";
  boolean isFirstFinish = true;
  boolean isFirstStart = true;
  private boolean isNeedJumpDetailMA = false;
  private boolean isPageFirstFinishMA = true;
  private boolean isPageFirstStartMA = true;
  boolean isSplashFinish = false;
  private boolean isSplashFinishMA = false;
  private Context mContextMA;
  private MainWebViewHandlerMA mWebViewHandlerMA;
  private WebViewListenerMA mWebViewListenerMA;
  private String placementNo = "0007";
  private SplashAd splashAdMA;
  
  static
  {
    JniLib.a(MobileTicket.class, 11);
    System.loadLibrary("checkcode");
  }
  
  private native void closeSplashView();
  
  private native void initSplashAd();
  
  private native void jumpDetail(AdDomain paramAdDomain);
  
  private native void setWebViewListener(WebViewListenerMA paramWebViewListenerMA);
  
  protected native void bindBrowser(CordovaWebView paramCordovaWebView, boolean paramBoolean);
  
  public native void com_sec_plugin_action_APP_STARTED();
  
  native void freshTime(Context paramContext, long paramLong);
  
  native long getTime(Context paramContext);
  
  @SuppressLint({"NewApi"})
  public native boolean isNeedShowAd(Context paramContext);
  
  public native void onCreate(Bundle paramBundle);
  
  public native Object onMessage(String paramString, Object paramObject);
  
  protected native void onRestart();
  
  public native void onWLInitCompleted(Bundle paramBundle);
  
  public native void removeSplashScreen();
  
  class MainWebViewHandlerMA
    extends Handler
  {
    static
    {
      JniLib.a(MainWebViewHandlerMA.class, 8);
    }
    
    public MainWebViewHandlerMA() {}
    
    public MainWebViewHandlerMA(Looper paramLooper)
    {
      super();
    }
    
    public native void handleMessage(Message paramMessage);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\MobileTicket\MobileTicket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */