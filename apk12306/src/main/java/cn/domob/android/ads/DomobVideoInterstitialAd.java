package cn.domob.android.ads;

import android.content.Context;
import cn.domob.android.i.f;
import cn.domob.android.i.g;

public class DomobVideoInterstitialAd
{
  private static f a = new f(DomobVideoInterstitialAd.class.getSimpleName());
  private G b;
  
  public DomobVideoInterstitialAd(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.b = new G(paramContext, paramString1, paramString2, g.b(paramContext, paramInt1) + "x" + g.b(paramContext, paramInt2), DomobAdView.a.g);
  }
  
  private G.a a(Context paramContext, DomobSceneInfo paramDomobSceneInfo)
  {
    G.a locala;
    if ((paramDomobSceneInfo instanceof DomobVideoInterstitialSceneInfo))
    {
      paramDomobSceneInfo = (DomobVideoInterstitialSceneInfo)paramDomobSceneInfo;
      locala = new G.a();
      locala.b("domob_close_interstitial.png");
      locala.b(paramContext, 0);
      locala.c(paramContext, 0);
      locala.c(paramDomobSceneInfo.a());
      if (paramDomobSceneInfo.a() != 1) {
        break label73;
      }
      a(paramContext, locala);
    }
    for (;;)
    {
      return locala;
      paramDomobSceneInfo = new DomobVideoInterstitialSceneInfo();
      break;
      label73:
      if (paramDomobSceneInfo.a() == 3) {
        b(paramContext, locala);
      }
    }
  }
  
  private void a(Context paramContext, G.a parama)
  {
    parama.a(paramContext, 34);
    parama.d(paramContext, 6);
  }
  
  private void b(Context paramContext, G.a parama)
  {
    parama.d(paramContext, 30);
    parama.a(paramContext, 12);
  }
  
  public void changeScene(DomobSceneInfo paramDomobSceneInfo)
  {
    a.b("scene change");
    this.b.b(paramDomobSceneInfo, a(paramDomobSceneInfo.e(), paramDomobSceneInfo));
  }
  
  public void closeVideoInterstitialAd()
  {
    this.b.q();
  }
  
  public boolean isVideoInterstitialAdReady()
  {
    return this.b.l();
  }
  
  public void loadVideoInterstitialAd()
  {
    if (!this.b.l()) {
      this.b.n();
    }
    for (;;)
    {
      return;
      if (this.b.m()) {
        a.d(f.b(), "the last ad didn't show, so please show it before request the next ad");
      }
    }
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
  
  public void setVideoInterstitialAdListener(DomobVideoInterstitialAdListener paramDomobVideoInterstitialAdListener)
  {
    this.b.a(paramDomobVideoInterstitialAdListener);
  }
  
  public void showVideoInterstitialAd(DomobSceneInfo paramDomobSceneInfo)
  {
    if (this.b.m())
    {
      a.b("Show VideoInterstitial View.");
      this.b.a(paramDomobSceneInfo, a(paramDomobSceneInfo.e(), paramDomobSceneInfo));
    }
    for (;;)
    {
      return;
      a.d(this, "VideoInterstitial ad is not ready");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobVideoInterstitialAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */