package cn.domob.android.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationSet;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import cn.domob.android.b.a;
import cn.domob.android.i.d;
import cn.domob.android.i.f;

public class DomobFeedsAdView
  extends u
  implements DomobInterstitialAdListener
{
  private static f r = new f(DomobFeedsAdView.class.getSimpleName());
  private DomobFeedsAdListener s;
  private Handler t = new Handler(Looper.getMainLooper());
  
  public DomobFeedsAdView(Context paramContext, String paramString1, String paramString2)
  {
    super(paramContext, paramString1, paramString2, "320x240");
    this.b = DomobAdView.a.f.ordinal();
    a(this, null);
    setLayoutParams(new ViewGroup.LayoutParams(-1, 0));
    setBackgroundColor(-16777216);
    t();
  }
  
  private void c(Context paramContext)
  {
    try
    {
      this.q = true;
      this.a.b = paramContext;
      Activity localActivity = (Activity)this.c;
      Runnable local2 = new cn/domob/android/ads/DomobFeedsAdView$2;
      local2.<init>(this, paramContext);
      localActivity.runOnUiThread(local2);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void t()
  {
    addView(new VideoView(this.c));
  }
  
  public void close()
  {
    if (this.p)
    {
      getLayoutParams().height = 0;
      invalidate();
      p();
    }
  }
  
  public void closeFeedsAd()
  {
    close();
  }
  
  public boolean isFeedsAdReady()
  {
    return m();
  }
  
  public void loadFeedsAd()
  {
    if (!isFeedsAdReady()) {
      l();
    }
    for (;;)
    {
      return;
      if (!r()) {
        r.d(f.b(), "the last ad didn't show, so please show it before request the next ad");
      }
    }
  }
  
  public void onDomobAdClicked(DomobAdView paramDomobAdView)
  {
    if (this.s != null) {
      this.s.onFeedsAdClicked(this);
    }
  }
  
  public void onInterstitialAdClicked(DomobInterstitialAd paramDomobInterstitialAd) {}
  
  public void onInterstitialAdDismiss()
  {
    if (this.s != null) {
      this.s.onFeedsAdDismiss();
    }
  }
  
  public void onInterstitialAdFailed(DomobAdManager.ErrorCode paramErrorCode)
  {
    if (this.s != null) {
      this.s.onFeedsAdFailed(paramErrorCode);
    }
  }
  
  public void onInterstitialAdLeaveApplication()
  {
    if (this.s != null) {
      this.s.onFeedsAdLeaveApplication();
    }
  }
  
  public void onInterstitialAdPresent()
  {
    if (this.s != null) {
      this.s.onFeedsAdPresent();
    }
  }
  
  public void onInterstitialAdReady()
  {
    if (this.s != null) {
      this.s.onFeedsAdReady();
    }
  }
  
  public void onLandingPageClose()
  {
    if (this.s != null) {
      this.s.onLandingPageClose();
    }
  }
  
  public void onLandingPageOpen()
  {
    if (this.s != null) {
      this.s.onLandingPageOpen();
    }
  }
  
  public void setFeedsAdListener(DomobFeedsAdListener paramDomobFeedsAdListener)
  {
    this.s = paramDomobFeedsAdListener;
  }
  
  public void setKeyword(String paramString)
  {
    super.setKeyword(paramString);
  }
  
  public void setUserBirthdayStr(String paramString)
  {
    super.setUserBirthdayStr(paramString);
  }
  
  public void setUserGender(String paramString)
  {
    super.setUserGender(paramString);
  }
  
  public void setUserPostcode(String paramString)
  {
    super.setUserPostcode(paramString);
  }
  
  public void showAd(final n paramn, AnimationSet[] paramArrayOfAnimationSet)
  {
    this.g = paramn;
    paramn = paramn.b();
    ((Activity)this.c).runOnUiThread(new Runnable()
    {
      public void run()
      {
        DomobFeedsAdView.this.removeAllViews();
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(DomobFeedsAdView.this.i, DomobFeedsAdView.this.j);
        localLayoutParams.addRule(13);
        DomobFeedsAdView.this.addView(paramn, localLayoutParams);
        if (DomobFeedsAdView.this.o != null) {
          DomobFeedsAdView.this.o.onDomobAdReturned(DomobFeedsAdView.this);
        }
      }
    });
    this.a.D();
  }
  
  public void showFeedsAd(Context paramContext)
  {
    if (!r())
    {
      r.b("Show Feeds View.");
      c(paramContext);
    }
    for (;;)
    {
      return;
      r.d(this, "Feeds ad is not ready or ad is showing");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobFeedsAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */