package cn.domob.android.ads;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import cn.domob.android.b.a;
import cn.domob.android.i.f;

class y
  extends DomobAdView
  implements DomobAdEventListener
{
  private static final String A = "domob_close.png";
  private static final int B = 40;
  private static final int C = 40;
  private static f t = new f(y.class.getSimpleName());
  private boolean D = true;
  private FrameLayout E;
  private WindowManager F;
  private RelativeLayout G;
  private int H = 300;
  protected View p;
  protected int q;
  protected boolean r = false;
  protected DomobSplashAd.DomobSplashMode s;
  private String u;
  private String v;
  private DomobSplashAdListener w;
  private int x;
  private boolean y = false;
  private String z;
  
  y(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    super(paramContext, paramString1, paramString2, paramString3, null, false);
    t.a("Init SplashAdView.");
    if (this.a != null)
    {
      this.a.a(false);
      this.a.b(false);
    }
    this.f.setVisibility(0);
    this.b = DomobAdView.a.d.ordinal();
    this.D = p();
  }
  
  y(Context paramContext, String paramString1, String paramString2, String paramString3, View paramView, int paramInt)
  {
    super(paramContext, paramString1, paramString2, paramString3, null, false);
    this.p = paramView;
    this.q = paramInt;
    t.a("Init SplashAdView.");
    if (this.a != null)
    {
      this.a.a(false);
      this.a.b(false);
    }
    this.f.setVisibility(0);
    this.b = DomobAdView.a.d.ordinal();
    this.D = p();
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return d.a(paramContext).e(paramString);
  }
  
  private void a(View paramView)
  {
    if (o()) {}
    for (;;)
    {
      return;
      this.y = true;
      try
      {
        if (getParent() == null) {
          break label42;
        }
        t.b("SplashView already has a parent.");
      }
      catch (Exception paramView)
      {
        t.a(paramView);
      }
      continue;
      label42:
      if ((this.p != null) && (this.p.getRootView() != null))
      {
        this.E = ((FrameLayout)this.p.getRootView().findViewById(16908290));
        Object localObject1 = this.a.B().d();
        boolean bool = ((j.c)localObject1).u();
        float f1 = ((j.c)localObject1).w();
        float f2 = ((j.c)localObject1).y();
        Object localObject2 = new android/widget/RelativeLayout;
        ((RelativeLayout)localObject2).<init>(this.c);
        this.G = ((RelativeLayout)localObject2);
        localObject2 = this.G;
        Object localObject3 = new android/widget/RelativeLayout$LayoutParams;
        ((RelativeLayout.LayoutParams)localObject3).<init>(-1, -1);
        ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        if (this.q != 0) {
          this.G.setBackgroundResource(this.q);
        }
        t.b(String.format("Creative width:%d, creative height:%d", new Object[] { Integer.valueOf(this.i), Integer.valueOf(this.j) }));
        localObject2 = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        if (localObject2 == null) {
          t.e("DomobSplashAdView adViewLayoutParams is null");
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(2);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = this.x;
        this.G.addView(paramView, (ViewGroup.LayoutParams)localObject2);
        if (bool)
        {
          int j = (int)(a.t(this.c) * 40.0F);
          int i = (int)(a.t(this.c) * 40.0F);
          paramView = new android/widget/ImageButton;
          paramView.<init>(this.c);
          paramView.setVisibility(8);
          paramView.setBackgroundDrawable(cn.domob.android.i.d.b(this.c, "domob_close.png"));
          localObject2 = new android/widget/RelativeLayout$LayoutParams;
          ((RelativeLayout.LayoutParams)localObject2).<init>(j, i);
          ((RelativeLayout.LayoutParams)localObject2).addRule(11);
          this.G.addView(paramView, (ViewGroup.LayoutParams)localObject2);
          localObject2 = new cn/domob/android/ads/y$1;
          ((1)localObject2).<init>(this);
          paramView.setOnClickListener((View.OnClickListener)localObject2);
          localObject3 = new android/os/Handler;
          ((Handler)localObject3).<init>();
          localObject2 = new cn/domob/android/ads/y$2;
          ((2)localObject2).<init>(this, paramView);
          ((Handler)localObject3).postDelayed((Runnable)localObject2, (int)(f1 * 1000.0F));
        }
        if (((j.c)localObject1).x())
        {
          paramView = t;
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          paramView.b("Min imp time:" + f1);
          localObject2 = new android/os/Handler;
          ((Handler)localObject2).<init>();
          paramView = new cn/domob/android/ads/y$3;
          paramView.<init>(this);
          ((Handler)localObject2).postDelayed(paramView, (int)(f1 * 1000.0F));
        }
        if (((j.c)localObject1).z())
        {
          paramView = t;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          paramView.b("Auto close time:" + f2);
          localObject1 = new android/os/Handler;
          ((Handler)localObject1).<init>();
          paramView = new cn/domob/android/ads/y$4;
          paramView.<init>(this);
          ((Handler)localObject1).postDelayed(paramView, (int)(f2 * 1000.0F));
        }
        if (this.D) {
          this.E.addView(this.G);
        }
        for (;;)
        {
          if (this.w != null) {
            this.w.onSplashPresent();
          }
          this.a.a(this.g.c(), "s", "s", 0L);
          this.a.a(System.currentTimeMillis());
          break;
          this.F = ((WindowManager)this.c.getSystemService("window"));
          paramView = new android/view/WindowManager$LayoutParams;
          paramView.<init>();
          paramView.type = 2007;
          paramView.windowAnimations = 16973828;
          this.F.addView(this.G, paramView);
        }
      }
      t.e("Splash cannot find view holder.");
    }
  }
  
  private boolean r()
  {
    boolean bool = true;
    K localK = new c().b(this.c);
    if (localK == null)
    {
      t.a("There is no available cache ad.");
      ((x)this.a).b(null, "sp_no_creative");
    }
    for (;;)
    {
      bool = false;
      for (;;)
      {
        return bool;
        if (System.currentTimeMillis() / 1000L >= localK.d())
        {
          t.a("Cached ad expires.");
          ((x)this.a).b(j.a(localK.c()), "sp_expire");
          break;
        }
        String str = localK.a();
        t.b(String.format("Cached ad orientation:%s", new Object[] { str }));
        if (!a.r(this.c).equals(str)) {
          break label226;
        }
        this.u = localK.b();
        this.v = localK.c();
        this.z = new c().a(this.c, this.u);
        if (TextUtils.isEmpty(this.z)) {
          break label194;
        }
        t.a("resources of creative is ok.");
      }
      label194:
      t.a("resources of creative is not ok.");
      ((x)this.a).b(j.a(this.v), "sp_res_incomplete");
      continue;
      label226:
      t.a("There is no available cache ad. Orientation wrong.");
      ((x)this.a).b(null, "sp_no_creative");
    }
  }
  
  void a(int paramInt)
  {
    this.x = paramInt;
    t.b("Set splash top margin:" + paramInt);
  }
  
  void a(Context paramContext, View paramView, int paramInt)
  {
    this.p = paramView;
    this.q = paramInt;
    t.b("Load cached Ad:" + this.v);
    this.c = paramContext;
    super.setAdEventListener(this);
    paramContext = j.a(this.v);
    if (paramContext != null) {
      paramContext.b(this.z);
    }
    this.a.a(paramContext, -1);
  }
  
  void a(DomobSplashAdListener paramDomobSplashAdListener)
  {
    this.w = paramDomobSplashAdListener;
  }
  
  protected void a(n paramn) {}
  
  protected void a(String paramString1, String paramString2)
  {
    this.a = new x(this, paramString1, paramString2);
  }
  
  public void close()
  {
    if (this.D) {
      if ((this.E != null) && (this.G != null))
      {
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        localAlphaAnimation.setDuration(this.H);
        localAlphaAnimation.setAnimationListener(new Animation.AnimationListener()
        {
          public void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            y.b(y.this).removeView(y.a(y.this));
          }
          
          public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
        this.G.startAnimation(localAlphaAnimation);
      }
    }
    for (;;)
    {
      return;
      if ((this.F != null) && (this.G != null)) {
        this.F.removeView(this.G);
      }
    }
  }
  
  protected boolean l()
  {
    if (this.b == DomobAdView.a.d.ordinal()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  boolean m()
  {
    if (r()) {
      t.a("Both splash ad response and it's resources are OK.");
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      requestRefreshAd();
    }
  }
  
  protected void n()
  {
    if (!this.r)
    {
      this.r = true;
      this.a.a(this.g.c(), "f", "s", this.a.g());
      if (this.w != null) {
        this.w.onSplashDismiss();
      }
      t.a("Request another Ad when current cached Ad is shown.");
      t.a("Delete old cached ad response.");
      new c().c(this.c);
      new c().d(this.c);
      setAdEventListener(null);
      requestRefreshAd();
    }
  }
  
  protected boolean o()
  {
    return this.y;
  }
  
  public void onDomobAdClicked(DomobAdView paramDomobAdView) {}
  
  public void onDomobAdFailed(DomobAdView paramDomobAdView, DomobAdManager.ErrorCode paramErrorCode)
  {
    t.e("Failed to load ad or get ad responce and the ErrorCode is " + paramErrorCode);
    if (this.w != null) {
      this.w.onSplashLoadFailed();
    }
  }
  
  public void onDomobAdOverlayDismissed(DomobAdView paramDomobAdView) {}
  
  public void onDomobAdOverlayPresented(DomobAdView paramDomobAdView) {}
  
  public Context onDomobAdRequiresCurrentContext()
  {
    return this.c;
  }
  
  public void onDomobAdReturned(DomobAdView paramDomobAdView)
  {
    t.a("Get new splash ad responce.");
  }
  
  public void onDomobLeaveApplication(DomobAdView paramDomobAdView) {}
  
  public boolean p()
  {
    String str = Build.MODEL;
    if (str != null)
    {
      int i = str.indexOf("MI");
      int j = str.indexOf("HM");
      if (i != -1) {
        this.H = 300;
      }
      if (j != -1) {
        this.H = 350;
      }
      if ((i == -1) && (j == -1)) {}
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void showAd(n paramn, AnimationSet[] paramArrayOfAnimationSet)
  {
    paramArrayOfAnimationSet = paramn.b();
    this.g = paramn;
    a(paramArrayOfAnimationSet);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */