package cn.domob.android.ads;

import android.app.Activity;
import android.content.Context;
import android.view.animation.AnimationSet;
import cn.domob.android.b.a;
import cn.domob.android.i.f;
import cn.domob.android.i.h;

class u
  extends DomobAdView
  implements DomobAdEventListener
{
  private static f r = new f(u.class.getSimpleName());
  protected boolean p = false;
  protected boolean q = true;
  private DomobInterstitialAd s;
  private DomobInterstitialAdListener t;
  private v.a u;
  
  protected u(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, paramString1, paramString2, paramString3, null, false);
    if (this.a != null)
    {
      this.a.a(false);
      this.a.b(false);
    }
    this.b = DomobAdView.a.c.ordinal();
  }
  
  private boolean t()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if ("video".equals(this.a.e.d().b()))
    {
      int i = this.a.e.d().c();
      int j = this.a.e.d().d();
      if (i == 600)
      {
        bool1 = bool2;
        if (j == 500) {}
      }
      else
      {
        if ((i != 300) || (j != 250)) {
          break label91;
        }
      }
    }
    for (bool1 = bool2;; bool1 = false)
    {
      return bool1;
      label91:
      r.e("video ad size is not 600x500 or 300x250");
    }
  }
  
  private boolean u()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if ("domob".equals(this.a.e.d().b()))
    {
      String str = this.a.B().d().t();
      if (h.e(str)) {
        break label77;
      }
      if (!str.equals(a.r(this.c))) {
        break label64;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label64:
      r.d("Ad response carrying the current direction and the direction of mobile inconsistencies");
      bool1 = false;
      continue;
      label77:
      r.e("ad response not contain interstitial orientation");
      bool1 = false;
    }
  }
  
  private void v()
  {
    r.d("give up showing interstitial ad");
    this.p = false;
    onDomobAdFailed(this, DomobAdManager.ErrorCode.INTERNAL_ERROR);
  }
  
  private boolean w()
  {
    if (!this.a.B().d().b().equals("video")) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  void a(DomobInterstitialAdListener paramDomobInterstitialAdListener, DomobInterstitialAd paramDomobInterstitialAd)
  {
    this.s = paramDomobInterstitialAd;
    this.t = paramDomobInterstitialAdListener;
  }
  
  protected void a(n paramn) {}
  
  void b(Context paramContext)
  {
    boolean bool4 = false;
    j.c localc = this.a.B().d();
    boolean bool3 = localc.u();
    float f1 = localc.w();
    float f2 = localc.y();
    j.b localb1 = localc.H();
    boolean bool1 = localb1.a();
    j.b localb2 = localc.I();
    boolean bool2 = localb2.a();
    if ("domob".equals(this.a.e.d().b()))
    {
      this.i = -1;
      this.j = -1;
      bool1 = false;
    }
    for (bool2 = false;; bool2 = bool3)
    {
      this.u = new v.a(paramContext).a(this.i, this.j).a(bool2).a("rectangle").b(bool1).a(localb1.b()).c(bool4).b(localb2.b()).a(localc.x(), f1).b(localc.z(), f2).a(new v.c()
      {
        public void a()
        {
          u.this.n();
          u.this.a.a(System.currentTimeMillis());
        }
        
        public void b()
        {
          u.this.o();
        }
        
        public void c()
        {
          u.this.p();
        }
      });
      if ((!u()) || (!t())) {
        v();
      }
      for (;;)
      {
        this.q = true;
        r.a(this, "the ad is showing and change mIsAdShow to true");
        return;
        this.u.a(this.g.b());
      }
      bool4 = bool2;
    }
  }
  
  protected void b(n paramn) {}
  
  public void close()
  {
    if (this.u != null) {
      this.u.a();
    }
  }
  
  void l()
  {
    super.setAdEventListener(this);
    super.requestRefreshAd();
  }
  
  boolean m()
  {
    return this.p;
  }
  
  protected void n()
  {
    this.g.d();
    if (this.t != null) {
      this.t.onInterstitialAdPresent();
    }
    if (w()) {
      this.a.a(this.g.c(), "s", "s", 0L);
    }
  }
  
  protected void o()
  {
    if (w()) {
      this.a.a(this.g.c(), "m", "s", this.a.g());
    }
  }
  
  public void onDomobAdClicked(DomobAdView paramDomobAdView)
  {
    if ((this.t != null) && (this.s != null))
    {
      r.a(this, "Notify user clicks on the interstitial or feeds ad.");
      this.t.onInterstitialAdClicked(this.s);
    }
  }
  
  public void onDomobAdFailed(DomobAdView paramDomobAdView, DomobAdManager.ErrorCode paramErrorCode)
  {
    if (this.t != null)
    {
      r.a(this, "Notify interstitial or feeds ad failed.");
      this.t.onInterstitialAdFailed(paramErrorCode);
    }
  }
  
  public void onDomobAdOverlayDismissed(DomobAdView paramDomobAdView)
  {
    if (this.t != null)
    {
      r.a(this, "Notify interstitial or feeds ad landing page close.");
      this.t.onLandingPageClose();
    }
  }
  
  public void onDomobAdOverlayPresented(DomobAdView paramDomobAdView)
  {
    if (this.t != null)
    {
      r.a(this, "Notify interstitial or feeds ad landing page open.");
      this.t.onLandingPageOpen();
    }
  }
  
  public Context onDomobAdRequiresCurrentContext()
  {
    return this.a.b;
  }
  
  public void onDomobAdReturned(DomobAdView paramDomobAdView)
  {
    this.p = true;
    if (this.t != null)
    {
      r.a(this, "Notify interstitial or feeds ad ready.");
      this.q = false;
      r.a(this, "ad already received and change show status to false");
      this.t.onInterstitialAdReady();
    }
  }
  
  public void onDomobLeaveApplication(DomobAdView paramDomobAdView)
  {
    if (this.t != null)
    {
      r.a(this, "Notify interstitial or feeds ad leaving application.");
      this.t.onInterstitialAdLeaveApplication();
    }
  }
  
  protected void p()
  {
    this.p = false;
    this.q = true;
    this.g.e();
    if (w()) {
      this.a.a(this.g.c(), "f", "s", this.a.g());
    }
    if (this.t != null) {
      this.t.onInterstitialAdDismiss();
    }
  }
  
  boolean q()
  {
    return this.p;
  }
  
  boolean r()
  {
    return this.q;
  }
  
  DomobInterstitialAdListener s()
  {
    return this.t;
  }
  
  public void showAd(n paramn, AnimationSet[] paramArrayOfAnimationSet)
  {
    this.g = paramn;
    ((Activity)this.c).runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (u.this.o != null) {
          u.this.o.onDomobAdReturned(u.this);
        }
      }
    });
    this.a.D();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */