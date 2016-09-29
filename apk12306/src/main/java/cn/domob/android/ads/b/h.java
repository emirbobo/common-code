package cn.domob.android.ads.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import cn.domob.android.b.a;
import cn.domob.android.i.d;
import cn.domob.android.i.f;
import java.util.ArrayList;

class h
{
  private static f f = new f(h.class.getSimpleName());
  private static final long g = 3000L;
  private static final int h = 50;
  private static final String i = "domob_close.png";
  protected BroadcastReceiver a = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent) {}
  };
  protected float b;
  protected int c = -1;
  protected int d = -1;
  FrameLayout e;
  private m j;
  private Context k;
  private m.l l = m.l.d;
  private final m.b m;
  private final m.d n;
  private FrameLayout o;
  private boolean p;
  private Runnable q = new Runnable()
  {
    public void run()
    {
      boolean bool = h.this.e();
      if (h.a(h.this) != bool)
      {
        h.a(h.this, bool);
        h.b(h.this).a(n.a(h.a(h.this)));
      }
      h.c(h.this).postDelayed(this, 3000L);
    }
  };
  private Handler r = new Handler();
  private final int s;
  private ImageView t;
  private boolean u;
  private int v;
  private int w;
  
  h(m paramm, m.b paramb, m.d paramd)
  {
    this.j = paramm;
    this.m = paramb;
    this.n = paramd;
    this.k = this.j.getContext();
    if ((this.k instanceof Activity)) {
      i1 = ((Activity)this.k).getRequestedOrientation();
    }
    this.s = i1;
    f();
  }
  
  private ViewGroup a(View paramView, int paramInt1, int paramInt2)
  {
    int i2 = (int)(50.0F * this.b);
    int i1 = paramInt1;
    if (paramInt1 < i2) {
      i1 = i2;
    }
    paramInt1 = paramInt2;
    if (paramInt2 < i2) {
      paramInt1 = i2;
    }
    FrameLayout localFrameLayout = new FrameLayout(this.j.getContext());
    localFrameLayout.setId(101);
    Object localObject = new View(this.j.getContext());
    ((View)localObject).setBackgroundColor(0);
    ((View)localObject).setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, -1));
    localObject = new FrameLayout(this.j.getContext());
    ((FrameLayout)localObject).setId(102);
    ((FrameLayout)localObject).addView(paramView, new FrameLayout.LayoutParams(i1, paramInt1));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i1, paramInt1);
    paramView = new int[2];
    this.e.getLocationOnScreen(paramView);
    int i3 = paramView[0];
    i2 = paramView[1];
    i1 = a.x(this.k);
    paramInt2 = this.e.getHeight();
    f.a(String.format("Mraid banner view's location on screen is:(%d, %d)", new Object[] { Integer.valueOf(i3), Integer.valueOf(i3) }));
    if (i1 - i2 > paramInt1)
    {
      localLayoutParams.leftMargin = i3;
      localLayoutParams.topMargin = (i2 - this.w);
    }
    for (;;)
    {
      localFrameLayout.addView((View)localObject, localLayoutParams);
      return localFrameLayout;
      if (i2 - this.w + paramInt2 > paramInt1)
      {
        localLayoutParams.leftMargin = paramView[0];
        localLayoutParams.topMargin = (i2 - (paramInt1 - paramInt2));
      }
      else
      {
        localLayoutParams.gravity = 17;
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.j.getContext();
    for (;;)
    {
      try
      {
        localObject = (Activity)localObject;
        if (paramBoolean)
        {
          i1 = ((Activity)localObject).getResources().getConfiguration().orientation;
          ((Activity)localObject).setRequestedOrientation(i1);
          return;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        int i1;
        f.e("Unable to modify device orientation.");
        continue;
      }
      i1 = this.s;
    }
  }
  
  private void f()
  {
    this.l = m.l.a;
    h();
  }
  
  private void g()
  {
    Object localObject = this.k;
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)((Context)localObject).getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.b = localDisplayMetrics.density;
    int i2;
    int i1;
    if ((localObject instanceof Activity))
    {
      Window localWindow = ((Activity)localObject).getWindow();
      localObject = new Rect();
      localWindow.getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      i2 = ((Rect)localObject).top;
      i1 = localWindow.findViewById(16908290).getTop() - i2;
    }
    for (;;)
    {
      this.w = (i2 + i1);
      int i3 = localDisplayMetrics.widthPixels;
      i1 = localDisplayMetrics.heightPixels - i2 - i1;
      f.a(String.format("Metrics pixels: width=%d, height=%d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i1) }));
      this.c = ((int)(i3 * (160.0D / localDisplayMetrics.densityDpi)));
      this.d = ((int)(i1 * (160.0D / localDisplayMetrics.densityDpi)));
      f.a(String.format("Screen size: width=%d, height=%d", new Object[] { Integer.valueOf(this.c), Integer.valueOf(this.d) }));
      return;
      i1 = 0;
      i2 = 0;
    }
  }
  
  private void h()
  {
    this.r.removeCallbacks(this.q);
    this.r.post(this.q);
  }
  
  private void i()
  {
    FrameLayout localFrameLayout = (FrameLayout)this.o.findViewById(102);
    Object localObject = (FrameLayout)this.o.findViewById(101);
    a(false);
    localFrameLayout.removeAllViewsInLayout();
    this.o.removeView((View)localObject);
    this.j.requestLayout();
    localObject = (ViewGroup)this.e.getParent();
    ((ViewGroup)localObject).addView(this.j, this.v, this.e.getLayoutParams());
    ((ViewGroup)localObject).removeView(this.e);
    ((ViewGroup)localObject).invalidate();
    if ((localObject instanceof ViewFlipper))
    {
      ((ViewFlipper)localObject).setInAnimation(null);
      ((ViewFlipper)localObject).setOutAnimation(null);
      ((ViewFlipper)localObject).setDisplayedChild(this.v);
    }
  }
  
  private void j()
  {
    ViewGroup localViewGroup = (ViewGroup)this.j.getParent();
    if (localViewGroup == null) {
      return;
    }
    this.e = new FrameLayout(this.k);
    this.e.setBackgroundColor(-16711936);
    int i2 = localViewGroup.getChildCount();
    for (int i1 = 0;; i1++) {
      if ((i1 >= i2) || (localViewGroup.getChildAt(i1) == this.j))
      {
        f.a("Current MRAID view's index is:" + i1);
        this.v = i1;
        localViewGroup.addView(this.e, i1, new ViewGroup.LayoutParams(this.j.getWidth(), this.j.getHeight()));
        localViewGroup.removeView(this.j);
        break;
      }
    }
  }
  
  public void a()
  {
    this.r.removeCallbacks(this.q);
  }
  
  protected void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.m == m.b.b) {}
    for (;;)
    {
      return;
      if ((paramString != null) && (!URLUtil.isValidUrl(paramString)))
      {
        this.j.b("expand", "URL passed to expand() was invalid.");
      }
      else
      {
        this.o = ((FrameLayout)this.j.getRootView().findViewById(16908290));
        b(paramBoolean1);
        c(paramBoolean2);
        j();
        m localm = this.j;
        if (paramString != null)
        {
          localm = new m(this.k);
          localm.loadUrl(paramString);
        }
        paramString = a(localm, (int)(paramInt1 * this.b), (int)(paramInt2 * this.b));
        this.o.addView(paramString, new FrameLayout.LayoutParams(-1, -1));
        if ((this.n == m.d.a) || ((!this.u) && (this.n != m.d.b))) {
          a(true);
        }
        this.l = m.l.c;
        this.j.a(l.a(this.l));
        if (this.j.d() != null) {
          this.j.d().a(this.j);
        }
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (this.o == null) {
      return;
    }
    Object localObject = (FrameLayout)this.o.findViewById(102);
    if (paramBoolean)
    {
      if (this.t == null)
      {
        this.t = new ImageView(this.j.getContext());
        this.t.setBackgroundDrawable(d.b(this.k, "domob_close.png"));
        this.t.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            h.this.d();
          }
        });
      }
      int i1 = (int)(50.0F * this.b);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(i1, i1, 5);
      ((FrameLayout)localObject).addView(this.t, localLayoutParams);
    }
    for (;;)
    {
      localObject = this.j;
      if (((m)localObject).h() == null) {
        break;
      }
      ((m)localObject).h().a((m)localObject, paramBoolean);
      break;
      ((FrameLayout)localObject).removeView(this.t);
    }
  }
  
  protected void b()
  {
    g();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(k.a(this.c, this.d));
    localArrayList.add(n.a(this.p));
    this.j.a(localArrayList);
    this.l = m.l.b;
    this.j.a(l.a(this.l));
  }
  
  protected void b(boolean paramBoolean)
  {
    this.u = paramBoolean;
    m localm = this.j;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (localm.h() != null) {
        localm.h().a(localm, paramBoolean);
      }
      return;
    }
  }
  
  protected boolean c()
  {
    if (this.l == m.l.c) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected void d()
  {
    f.a("MRAID expandable part will be closed.");
    if (this.l == m.l.c)
    {
      f.a("MRAID view state is expanded and expand part will be closed.");
      i();
      c(false);
      this.l = m.l.b;
      this.j.a(l.a(this.l));
    }
    for (;;)
    {
      if (this.j.e() != null) {
        this.j.e().a(this.j, this.l);
      }
      return;
      if (this.l == m.l.b)
      {
        f.a("MRAID view state is default and MRAID view will be hidden.");
        this.j.setVisibility(4);
        this.l = m.l.d;
        this.j.a(l.a(this.l));
      }
    }
  }
  
  protected boolean e()
  {
    if (this.j.getVisibility() == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\b\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */