package cn.domob.android.ads;

import android.app.Activity;
import android.content.Context;
import android.os.PowerManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import cn.domob.android.i.f;

public class DomobAdView
  extends RelativeLayout
  implements m
{
  public static final String INLINE_SIZE_300X250 = "300x250";
  public static final String INLINE_SIZE_320X50 = "320x50";
  public static final String INLINE_SIZE_600X500 = "600x500";
  public static final String INLINE_SIZE_600X94 = "600x94";
  public static final String INLINE_SIZE_728X90 = "728x90";
  public static final String INLINE_SIZE_FLEXIBLE = "FLEXIBLE_BANNER";
  private static f p = new f(DomobAdView.class.getSimpleName());
  private static final String r = "0x90";
  private static final String s = "0x50";
  protected g a = null;
  protected int b;
  protected Context c;
  protected boolean d = false;
  protected boolean e = true;
  protected H f;
  protected n g;
  protected String h;
  protected int i = 0;
  protected int j = 0;
  protected boolean k = true;
  protected boolean l = false;
  protected boolean m = false;
  protected DomobAdListener n;
  protected DomobAdEventListener o;
  private boolean q = true;
  
  @Deprecated
  public DomobAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, null, null, "320x50", paramAttributeSet);
  }
  
  public DomobAdView(Context paramContext, String paramString1, String paramString2)
  {
    this(paramContext, paramString1, paramString2, "FLEXIBLE_BANNER", null);
  }
  
  protected DomobAdView(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this(paramContext, paramString1, paramString2, paramString3, null);
  }
  
  private DomobAdView(Context paramContext, String paramString1, String paramString2, String paramString3, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramString1, paramString2, paramString3, paramAttributeSet, true);
  }
  
  protected DomobAdView(Context paramContext, String paramString1, String paramString2, String paramString3, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    this.c = paramContext;
    this.f = new H(paramContext);
    this.f.setVisibility(8);
    a(paramString1, paramString2);
    addView(this.f);
    setAdSize(paramString3);
    this.b = a.b.ordinal();
    this.a.a(this.c);
    this.a.H();
    if (paramBoolean)
    {
      cn.domob.android.i.g.a(this);
      p.b("close hardware");
    }
  }
  
  public DomobAdView(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    this(paramContext, paramString1, paramString2, "FLEXIBLE_BANNER", null);
    if ((this.a != null) && (!paramBoolean))
    {
      this.a.a(false);
      this.a.b(false);
    }
  }
  
  private void c(n paramn)
  {
    int i1;
    if (this.a.i())
    {
      i1 = paramn.c().d().s();
      switch (i1)
      {
      default: 
        i1 -= 2;
        if ((i1 >= 0) && (i1 < L.a.values().length)) {
          showAd(paramn, L.a(L.a.values()[i1]));
        }
        break;
      }
    }
    for (;;)
    {
      return;
      showAd(paramn, null);
      continue;
      i1 = L.a.values().length;
      i1 = (int)(Math.random() * i1);
      showAd(paramn, L.a(L.a.values()[i1]));
      continue;
      p.e("Invalid animation type index.");
      showAd(paramn, null);
      continue;
      showAd(paramn, null);
    }
  }
  
  private void domobAdDismiss()
  {
    this.a.j("mogo_dismiss");
  }
  
  private void domobAdImpression()
  {
    this.a.j("mogo_imp");
  }
  
  private void domobAdLoad()
  {
    this.a.j("mogo_load");
  }
  
  private void l()
  {
    if ((this.a != null) && (!this.a.A())) {
      requestRefreshAd();
    }
  }
  
  private void needCleanWhenDetached(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  protected void a(n paramn)
  {
    this.a.a(paramn.c(), "s", "s", 0L);
  }
  
  protected void a(String paramString1, String paramString2)
  {
    this.a = new g(this, paramString1, paramString2);
  }
  
  protected boolean a()
  {
    return cn.domob.android.i.g.a(this.c, this);
  }
  
  protected boolean a(Context paramContext)
  {
    try
    {
      bool = ((PowerManager)paramContext.getSystemService("power")).isScreenOn();
      return bool;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        p.a(paramContext);
        boolean bool = true;
      }
    }
  }
  
  protected Context b()
  {
    return this.c;
  }
  
  protected void b(n paramn)
  {
    paramn.d();
  }
  
  protected boolean c()
  {
    return this.d;
  }
  
  public void clean()
  {
    try
    {
      this.a.b();
      p.a("Clean DomobAdView.");
      int i2 = this.f.getChildCount();
      Object localObject = p;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      ((f)localObject).a(i2 + " WebView to DESTROY.");
      int i1 = 0;
      if (i1 < i2)
      {
        if ((this.f.getChildAt(0) instanceof a))
        {
          localObject = (a)this.f.getChildAt(0);
          if (localObject == null) {
            break label112;
          }
          this.f.removeView((View)localObject);
          ((a)localObject).destroy();
        }
        for (;;)
        {
          i1++;
          break;
          label112:
          p.a("WebView has already been destroyed.");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      p.a(localException);
    }
  }
  
  public void close() {}
  
  protected boolean d()
  {
    return this.e;
  }
  
  protected int e()
  {
    return this.b;
  }
  
  protected DomobAdListener f()
  {
    return this.n;
  }
  
  protected DomobAdEventListener g()
  {
    return this.o;
  }
  
  protected n h()
  {
    return this.g;
  }
  
  protected String i()
  {
    return this.h;
  }
  
  protected boolean j()
  {
    ViewParent localViewParent = getParent();
    boolean bool;
    if (localViewParent != null) {
      if (!(localViewParent instanceof View)) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      if (((View)localViewParent).getVisibility() != 0)
      {
        bool = false;
      }
      else
      {
        localViewParent = localViewParent.getParent();
        break;
        bool = true;
      }
    }
  }
  
  public void loadUrl(String paramString1, String paramString2)
  {
    if (this.a != null)
    {
      this.a.a(false);
      this.a.c(true);
      this.a.h(paramString1);
      this.a.i(paramString2);
      this.a.F();
    }
    for (;;)
    {
      return;
      p.e("mAdController is not initialized!");
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    p.a("onAttachedToWindow");
    p.b("Start to load AD.");
    l();
  }
  
  /* Error */
  protected void onDetachedFromWindow()
  {
    // Byte code:
    //   0: getstatic 77	cn/domob/android/ads/DomobAdView:p	Lcn/domob/android/i/f;
    //   3: ldc_w 342
    //   6: invokevirtual 263	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 93	cn/domob/android/ads/DomobAdView:a	Lcn/domob/android/ads/g;
    //   13: invokevirtual 259	cn/domob/android/ads/g:b	()V
    //   16: aload_0
    //   17: getfield 109	cn/domob/android/ads/DomobAdView:q	Z
    //   20: ifeq +132 -> 152
    //   23: getstatic 77	cn/domob/android/ads/DomobAdView:p	Lcn/domob/android/i/f;
    //   26: ldc_w 261
    //   29: invokevirtual 263	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   32: aload_0
    //   33: getfield 118	cn/domob/android/ads/DomobAdView:f	Lcn/domob/android/ads/H;
    //   36: invokevirtual 266	cn/domob/android/ads/H:getChildCount	()I
    //   39: istore_2
    //   40: getstatic 77	cn/domob/android/ads/DomobAdView:p	Lcn/domob/android/i/f;
    //   43: astore 4
    //   45: new 268	java/lang/StringBuilder
    //   48: astore_3
    //   49: aload_3
    //   50: invokespecial 270	java/lang/StringBuilder:<init>	()V
    //   53: aload 4
    //   55: aload_3
    //   56: iload_2
    //   57: invokevirtual 274	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: ldc_w 276
    //   63: invokevirtual 279	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 282	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokevirtual 263	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   72: iconst_0
    //   73: istore_1
    //   74: iload_1
    //   75: iload_2
    //   76: if_icmpge +85 -> 161
    //   79: aload_0
    //   80: getfield 118	cn/domob/android/ads/DomobAdView:f	Lcn/domob/android/ads/H;
    //   83: iconst_0
    //   84: invokevirtual 286	cn/domob/android/ads/H:getChildAt	(I)Landroid/view/View;
    //   87: instanceof 288
    //   90: ifeq +31 -> 121
    //   93: aload_0
    //   94: getfield 118	cn/domob/android/ads/DomobAdView:f	Lcn/domob/android/ads/H;
    //   97: iconst_0
    //   98: invokevirtual 286	cn/domob/android/ads/H:getChildAt	(I)Landroid/view/View;
    //   101: checkcast 288	cn/domob/android/ads/a
    //   104: astore_3
    //   105: aload_3
    //   106: ifnull +21 -> 127
    //   109: aload_0
    //   110: getfield 118	cn/domob/android/ads/DomobAdView:f	Lcn/domob/android/ads/H;
    //   113: aload_3
    //   114: invokevirtual 291	cn/domob/android/ads/H:removeView	(Landroid/view/View;)V
    //   117: aload_3
    //   118: invokevirtual 294	cn/domob/android/ads/a:destroy	()V
    //   121: iinc 1 1
    //   124: goto -50 -> 74
    //   127: getstatic 77	cn/domob/android/ads/DomobAdView:p	Lcn/domob/android/i/f;
    //   130: ldc_w 296
    //   133: invokevirtual 263	cn/domob/android/i/f:a	(Ljava/lang/String;)V
    //   136: goto -15 -> 121
    //   139: astore_3
    //   140: getstatic 77	cn/domob/android/ads/DomobAdView:p	Lcn/domob/android/i/f;
    //   143: aload_3
    //   144: invokevirtual 253	cn/domob/android/i/f:a	(Ljava/lang/Throwable;)V
    //   147: aload_0
    //   148: invokespecial 344	android/widget/RelativeLayout:onDetachedFromWindow	()V
    //   151: return
    //   152: getstatic 77	cn/domob/android/ads/DomobAdView:p	Lcn/domob/android/i/f;
    //   155: ldc_w 346
    //   158: invokevirtual 156	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: invokespecial 344	android/widget/RelativeLayout:onDetachedFromWindow	()V
    //   165: goto -14 -> 151
    //   168: astore_3
    //   169: aload_0
    //   170: invokespecial 344	android/widget/RelativeLayout:onDetachedFromWindow	()V
    //   173: aload_3
    //   174: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	DomobAdView
    //   73	49	1	i1	int
    //   39	38	2	i2	int
    //   48	70	3	localObject1	Object
    //   139	5	3	localException	Exception
    //   168	6	3	localObject2	Object
    //   43	11	4	localf	f
    // Exception table:
    //   from	to	target	type
    //   0	72	139	java/lang/Exception
    //   79	105	139	java/lang/Exception
    //   109	121	139	java/lang/Exception
    //   127	136	139	java/lang/Exception
    //   152	161	139	java/lang/Exception
    //   0	72	168	finally
    //   79	105	168	finally
    //   109	121	168	finally
    //   127	136	168	finally
    //   140	147	168	finally
    //   152	161	168	finally
  }
  
  public void onDomobAdClicked()
  {
    if (this.o != null) {
      this.o.onDomobAdClicked(this);
    }
  }
  
  public void onDomobAdFailed(DomobAdManager.ErrorCode paramErrorCode)
  {
    if (this.o != null) {
      this.o.onDomobAdFailed(this, paramErrorCode);
    }
  }
  
  public void onDomobAdOverlayDismissed()
  {
    if (this.o != null) {
      this.o.onDomobAdOverlayDismissed(this);
    }
  }
  
  public void onDomobAdOverlayPresented()
  {
    if (this.o != null) {
      this.o.onDomobAdOverlayPresented(this);
    }
  }
  
  public Context onDomobAdRequiresCurrentContext()
  {
    if (this.o != null) {}
    for (Context localContext = this.o.onDomobAdRequiresCurrentContext();; localContext = null) {
      return localContext;
    }
  }
  
  public void onDomobAdReturned(n paramn)
  {
    c(paramn);
  }
  
  public void onDomobLeaveApplication()
  {
    if (this.o != null) {
      this.o.onDomobLeaveApplication(this);
    }
  }
  
  public void onProcessActionType(String paramString) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    p.a("onWindowFocusChanged:" + paramBoolean);
    this.e = paramBoolean;
    if (this.a != null)
    {
      if ((!this.e) || (!this.d)) {
        break label85;
      }
      if (!this.a.A()) {
        break label75;
      }
      this.a.e();
    }
    for (;;)
    {
      return;
      label75:
      this.a.k();
      continue;
      label85:
      if ((!this.e) || (!this.d)) {
        this.a.c();
      }
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    boolean bool2 = true;
    super.onWindowVisibilityChanged(paramInt);
    f localf = p;
    StringBuilder localStringBuilder = new StringBuilder().append("onWindowVisibilityChanged:");
    if (paramInt == 0)
    {
      bool1 = true;
      localf.a(bool1);
      if (paramInt != 0) {
        break label64;
      }
    }
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.d = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public void orientationChanged()
  {
    if ((this.a != null) && (this.f != null) && (this.h != null) && ((this.h.equals("0x50")) || (this.h.equals("0x90"))))
    {
      int i1 = cn.domob.android.b.a.u(this.c);
      if ((this.i != 0) && (this.i != i1))
      {
        onDetachedFromWindow();
        this.i = i1;
        requestRefreshAd();
      }
    }
  }
  
  public void requestRefreshAd()
  {
    if ((this.a != null) && (this.a.j())) {
      this.a.C();
    }
  }
  
  public void setAdEventListener(DomobAdEventListener paramDomobAdEventListener)
  {
    this.o = paramDomobAdEventListener;
  }
  
  public void setAdSize(String paramString)
  {
    if (paramString != null) {
      if (paramString.equals("FLEXIBLE_BANNER")) {
        if (cn.domob.android.b.a.E(this.c)) {
          this.h = "0x90";
        }
      }
    }
    for (;;)
    {
      return;
      this.h = "0x50";
      continue;
      this.h = paramString;
      continue;
      this.h = null;
    }
  }
  
  public void setCreativeRect(int paramInt1, int paramInt2)
  {
    this.i = paramInt1;
    this.j = paramInt2;
  }
  
  public void setKeyword(String paramString)
  {
    this.a.b(paramString);
  }
  
  @Deprecated
  public void setOnAdListener(DomobAdListener paramDomobAdListener)
  {
    this.n = paramDomobAdListener;
  }
  
  public void setRefreshable(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.a(paramBoolean);
    }
  }
  
  public void setSpots(String paramString)
  {
    if (this.a != null) {
      this.a.f(paramString);
    }
  }
  
  public void setUserBirthdayStr(String paramString)
  {
    this.a.e(paramString);
  }
  
  public void setUserGender(String paramString)
  {
    this.a.d(paramString);
  }
  
  public void setUserPostcode(String paramString)
  {
    this.a.c(paramString);
  }
  
  public void showAd(final n paramn, final AnimationSet[] paramArrayOfAnimationSet)
  {
    p.b("Switch AD with/without animation.");
    this.g = paramn;
    final View localView = paramn.b();
    ((Activity)this.c).runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (DomobAdView.this.f.getLayoutParams() != null)
        {
          DomobAdView.k().a("AdView's layoutParams is not null.");
          DomobAdView.this.f.getLayoutParams().width = DomobAdView.this.i;
          DomobAdView.this.f.getLayoutParams().height = DomobAdView.this.j;
          if (paramArrayOfAnimationSet == null) {
            break label356;
          }
          DomobAdView.k().b("Show ad with animation.");
          Object localObject = paramArrayOfAnimationSet[0];
          AnimationSet localAnimationSet = paramArrayOfAnimationSet[1];
          DomobAdView.this.f.setInAnimation((Animation)localObject);
          DomobAdView.this.f.setOutAnimation(localAnimationSet);
          label112:
          DomobAdView.this.f.setVisibility(0);
          DomobAdView.this.f.addView(localView, new RelativeLayout.LayoutParams(DomobAdView.this.i, DomobAdView.this.j));
          if (!DomobAdView.this.k) {
            break label389;
          }
          DomobAdView.this.k = false;
          label176:
          if (DomobAdView.this.f.getChildCount() >= 3)
          {
            if (!(DomobAdView.this.f.getChildAt(0) instanceof a)) {
              break label402;
            }
            localObject = (a)DomobAdView.this.f.getChildAt(0);
            DomobAdView.this.f.removeView((View)localObject);
            ((a)localObject).destroy();
          }
        }
        for (;;)
        {
          DomobAdView.this.b(paramn);
          DomobAdView.this.a.a(System.currentTimeMillis());
          if (DomobAdView.this.n != null) {
            DomobAdView.this.n.onReceivedFreshAd(DomobAdView.this);
          }
          if (DomobAdView.this.o != null) {
            DomobAdView.this.o.onDomobAdReturned(DomobAdView.this);
          }
          return;
          DomobAdView.k().a("AdView's layoutParams is null.");
          DomobAdView.this.f.setLayoutParams(new RelativeLayout.LayoutParams(DomobAdView.this.i, DomobAdView.this.j));
          break;
          label356:
          DomobAdView.k().b("Show ad without animation.");
          DomobAdView.this.f.setInAnimation(null);
          DomobAdView.this.f.setOutAnimation(null);
          break label112;
          label389:
          DomobAdView.this.f.showNext();
          break label176;
          label402:
          DomobAdView.this.f.removeViewAt(0);
        }
      }
    });
    a(paramn);
    this.a.D();
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\DomobAdView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */