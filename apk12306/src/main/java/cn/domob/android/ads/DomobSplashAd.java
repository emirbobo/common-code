package cn.domob.android.ads;

import android.content.Context;
import android.util.Log;
import android.view.View;
import cn.domob.android.i.f;

public class DomobSplashAd
{
  private static f a = new f(DomobSplashAd.class.getSimpleName());
  private Context b;
  private y c;
  private boolean d = false;
  private boolean e = false;
  
  public DomobSplashAd(Context paramContext, String paramString1, String paramString2, DomobSplashMode paramDomobSplashMode)
  {
    this.b = paramContext;
    this.c = new y(paramContext, paramString1, paramString2, A.a(paramContext, paramDomobSplashMode));
    this.c.s = paramDomobSplashMode;
  }
  
  private void domobAdDismiss()
  {
    this.c.a.j("mogo_dismiss");
  }
  
  private void domobAdImpression()
  {
    this.c.a.j("mogo_imp");
  }
  
  private void domobAdLoad()
  {
    this.c.a.j("mogo_load");
  }
  
  public void closeSplash()
  {
    if (this.c != null) {
      this.c.close();
    }
  }
  
  public boolean isSplashAdReady()
  {
    this.d = true;
    this.e = this.c.m();
    return this.e;
  }
  
  public void setKeyword(String paramString)
  {
    this.c.setKeyword(paramString);
  }
  
  public void setSplashAdListener(DomobSplashAdListener paramDomobSplashAdListener)
  {
    this.c.a(paramDomobSplashAdListener);
  }
  
  public void setSplashTopMargin(int paramInt)
  {
    A.a(this.b, this.c, paramInt);
  }
  
  public void setUserBirthdayStr(String paramString)
  {
    this.c.setUserBirthdayStr(paramString);
  }
  
  public void setUserGender(String paramString)
  {
    this.c.setUserGender(paramString);
  }
  
  public void setUserPostcode(String paramString)
  {
    this.c.setUserPostcode(paramString);
  }
  
  public void splash(Context paramContext, View paramView, int paramInt)
  {
    if ((this.d) && (this.e))
    {
      a.b("Show Splash View.");
      this.c.a(paramContext, paramView, paramInt);
      this.d = false;
    }
    for (;;)
    {
      return;
      if (this.d)
      {
        Log.e(f.b(), "Splash AD is not ready yet.");
      }
      else if (isSplashAdReady())
      {
        this.c.a(paramContext, paramView, paramInt);
        this.d = false;
      }
      else
      {
        Log.e(f.b(), "Splash AD is not ready yet. Please call \"isSplashReady()\" first to check.");
      }
    }
  }
  
  public static enum DomobSplashMode
  {
    private DomobSplashMode() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobSplashAd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */