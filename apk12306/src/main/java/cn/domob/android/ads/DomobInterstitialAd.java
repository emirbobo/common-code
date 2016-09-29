package cn.domob.android.ads;

import android.content.Context;
import cn.domob.android.i.f;

public class DomobInterstitialAd
{
  public static final String INTERSITIAL_SIZE_300X250 = "300x250";
  public static final String INTERSITIAL_SIZE_600X500 = "600x500";
  public static final String INTERSITIAL_SIZE_FULL_SCREEN = null;
  private static f a = new f(DomobInterstitialAd.class.getSimpleName());
  private u b;
  
  public DomobInterstitialAd(Context paramContext, String paramString1, String paramString2)
  {
    this.b = new u(paramContext, paramString1, paramString2, null);
  }
  
  private void domobAdDismiss()
  {
    this.b.a.j("mogo_dismiss");
  }
  
  private void domobAdImpression()
  {
    this.b.a.j("mogo_imp");
  }
  
  private void domobAdLoad()
  {
    this.b.a.j("mogo_load");
  }
  
  public boolean isInterstitialAdReady()
  {
    return this.b.m();
  }
  
  public void loadInterstitialAd()
  {
    if (!this.b.q()) {
      this.b.l();
    }
    for (;;)
    {
      return;
      if (!this.b.r()) {
        a.d(f.b(), "the last ad didn't show, so please show it before request the next ad");
      }
    }
  }
  
  public void setInterstitialAdListener(DomobInterstitialAdListener paramDomobInterstitialAdListener)
  {
    this.b.a(paramDomobInterstitialAdListener, this);
  }
  
  public void setKeyword(String paramString)
  {
    this.b.setKeyword(paramString);
  }
  
  public void setUserBirthdayStr(String paramString)
  {
    this.b.setUserBirthdayStr(paramString);
  }
  
  public void setUserGender(String paramString)
  {
    this.b.setUserGender(paramString);
  }
  
  public void setUserPostcode(String paramString)
  {
    this.b.setUserPostcode(paramString);
  }
  
  public void showInterstitialAd(Context paramContext)
  {
    if (!this.b.r())
    {
      a.b("Show Interstitial View.");
      this.b.b(paramContext);
    }
    for (;;)
    {
      return;
      a.d(this, "Interstial ad is not ready");
    }
  }
  
  public static enum BorderType
  {
    private BorderType() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */