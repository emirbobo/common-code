package cn.domob.android.ads;

import android.content.Context;
import cn.domob.android.i.f;
import cn.domob.android.i.g;

public class DomobPreRollAd
{
  private static f a = new f(DomobPreRollAd.class.getSimpleName());
  private G b;
  
  public DomobPreRollAd(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.b = new G(paramContext, paramString1, paramString2, g.b(paramContext, paramInt1) + "x" + g.b(paramContext, paramInt2), DomobAdView.a.h);
  }
  
  private G.a a(DomobSceneInfo paramDomobSceneInfo)
  {
    if ((paramDomobSceneInfo instanceof DomobPreRollSceneInfo)) {}
    for (paramDomobSceneInfo = (DomobPreRollSceneInfo)paramDomobSceneInfo;; paramDomobSceneInfo = new DomobPreRollSceneInfo())
    {
      G.a locala = new G.a();
      locala.c(2);
      locala.b("domob_close.png");
      locala.l(-16777216);
      if (paramDomobSceneInfo.a())
      {
        locala.b(paramDomobSceneInfo.a());
        locala.h(paramDomobSceneInfo.b());
        locala.i(paramDomobSceneInfo.c());
      }
      return locala;
    }
  }
  
  public void changeScene(DomobSceneInfo paramDomobSceneInfo)
  {
    a.b("scene change");
    this.b.b(paramDomobSceneInfo, a(paramDomobSceneInfo));
  }
  
  public void closePreRollAd(boolean paramBoolean)
  {
    G localG = this.b;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localG.a(paramBoolean);
      return;
    }
  }
  
  public boolean isPreRollAdReady()
  {
    return this.b.l();
  }
  
  public void loadPreRollAd()
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
  
  public void setCountdownTotalSeconds(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void setKeyword(String paramString)
  {
    this.b.setKeyword(paramString);
  }
  
  public void setProRollAdListener(DomobPreRollAdListener paramDomobPreRollAdListener)
  {
    this.b.a(paramDomobPreRollAdListener);
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
  
  public void showPreRollAd(DomobSceneInfo paramDomobSceneInfo)
  {
    if (this.b.m())
    {
      a.b("Show PreRoll View.");
      this.b.a(paramDomobSceneInfo, a(paramDomobSceneInfo));
    }
    for (;;)
    {
      return;
      a.d(this, "PreRoll ad is not ready");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobPreRollAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */