package com.bontai.mobiads.ads.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bangcle.andjni.JniLib;
import com.bontai.mobiads.ads.ADDialog;
import com.bontai.mobiads.ads.AdView;
import com.bontai.mobiads.ads.entity.AdDomain;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;
import com.lidroid.xutils.bitmap.callback.BitmapLoadFrom;
import com.lidroid.xutils.bitmap.callback.DefaultBitmapLoadCallBack;

public class SplashAdView
  extends AdView
{
  private ADDialog adDetailDialog;
  private AdDomain adDomain;
  private ADDialog adSplashDialog;
  private FrameLayout adSplashFramelayout;
  private BitmapDisplayConfig bigPicDisplayConfig;
  private BitmapUtils bitmapUtils;
  private ImageView btnClose;
  private Context context;
  private Handler dismissHandler;
  private Runnable dismissThread;
  private String placementNo;
  private LinearLayout rootll;
  private SplashAdListener splashAdListener;
  private SplashAdView splashAdView;
  private ImageView splashBackgroundView;
  private SplashDetailAd splashDetailAd;
  
  static
  {
    JniLib.a(SplashAdView.class, 221);
  }
  
  public SplashAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    initImageLoader(paramContext);
  }
  
  public SplashAdView(Context paramContext, String paramString)
  {
    this(paramContext, null, 0);
    this.placementNo = paramString;
  }
  
  private native void closeAdDetail();
  
  private native void enterDetailPage();
  
  private native void init(View paramView, int paramInt1, int paramInt2);
  
  @SuppressLint({"NewApi"})
  private native void initUI(View paramView, int paramInt1, int paramInt2);
  
  public native void close();
  
  public native void displaySkipButton();
  
  public native void initImageLoader(Context paramContext);
  
  public native void jumbDetailClick();
  
  public native void splash(View paramView, SplashAdListener paramSplashAdListener, int paramInt1, int paramInt2);
  
  private class SplashBitmapLoadCallBack<T extends View>
    extends DefaultBitmapLoadCallBack<T>
  {
    static
    {
      JniLib.a(SplashBitmapLoadCallBack.class, 220);
    }
    
    private SplashBitmapLoadCallBack() {}
    
    public native void onLoadCompleted(T paramT, String paramString, Bitmap paramBitmap, BitmapDisplayConfig paramBitmapDisplayConfig, BitmapLoadFrom paramBitmapLoadFrom);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\bontai\mobiads\ads\splash\SplashAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */