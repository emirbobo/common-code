package cn.domob.android.j;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.VideoView;
import cn.domob.android.i.f;
import cn.domob.android.i.g;
import cn.domob.android.i.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class a
  extends RelativeLayout
  implements c.a, d.b, e.a, e.b
{
  public static final int a = 0;
  private static f b = new f(a.class.getSimpleName());
  private boolean A = false;
  private boolean B = false;
  private boolean C = false;
  private boolean D = false;
  private boolean E = false;
  private boolean F = false;
  private int G;
  private int H;
  private int I;
  private boolean J = false;
  private boolean K = false;
  private Runnable L = new Runnable()
  {
    public void run()
    {
      a.this.g();
    }
  };
  private Context c;
  private b d;
  private d e;
  private int f = 0;
  private int g = 0;
  private String h;
  private RelativeLayout.LayoutParams i;
  private RelativeLayout.LayoutParams j;
  private RelativeLayout k;
  private VideoView l;
  private Dialog m;
  private c n;
  private a o;
  private c p;
  private b q = null;
  private long[] r;
  private e s;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private Handler x = new Handler(Looper.getMainLooper());
  private Timer y;
  private Timer z;
  
  public a(Context paramContext, String paramString, int paramInt1, int paramInt2, b paramb, a parama)
  {
    super(paramContext);
    if ((paramContext != null) && (!h.e(paramString)) && (paramInt1 > 0) && (paramInt2 > 0))
    {
      this.c = paramContext;
      this.h = paramString;
      this.f = paramInt1;
      this.g = paramInt2;
      this.o = parama;
      this.d = paramb;
      this.I = this.d.f();
      this.e = new d(paramContext, this.d, this.I, this.x, this);
      this.i = this.e.b(this.c, this.f, this.g);
      this.i.addRule(13);
      this.j = this.e.b(this.c, this.f, this.g);
      this.j.addRule(13);
      this.k = new RelativeLayout(paramContext);
      this.k.setBackgroundColor(-16777216);
      this.k.setLayoutParams(this.i);
      addView(this.k);
      paramContext = this.e.b(this.c, this.f, this.g);
      paramContext.addRule(13);
      setLayoutParams(paramContext);
      setBackgroundColor(-16777216);
      this.e.g();
      if (this.d.d()) {
        H();
      }
    }
    for (;;)
    {
      return;
      b.e("Constructor parameter error, video ad end");
      g();
    }
  }
  
  private boolean A()
  {
    try
    {
      bool = this.l.isPlaying();
      return bool;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        b.a(localIllegalStateException);
        boolean bool = false;
      }
    }
  }
  
  private void B()
  {
    if (this.z != null) {
      this.z.cancel();
    }
    final Object localObject = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    int i1 = 1000;
    if (this.I > 0)
    {
      this.C = false;
      this.I -= this.I % 100;
      if (this.I % 1000 != 0) {
        break label210;
      }
    }
    label210:
    for (i1 = 1000;; i1 = 100)
    {
      this.D = false;
      if ((this.r == null) || (this.r.length <= 0)) {
        break label265;
      }
      int i3 = 0;
      while (i3 < this.r.length)
      {
        Long localLong = new Long(this.r[i3] - this.r[i3] % 100L);
        if (!localArrayList.contains(localLong))
        {
          localArrayList.add(localLong);
          ((ArrayList)localObject).add(new Long(this.r[i3]));
        }
        int i2 = i1;
        if (i1 == 1000)
        {
          i2 = i1;
          if (this.r[i3] % 1000L > 0L) {
            i2 = 100;
          }
        }
        i3++;
        i1 = i2;
      }
    }
    label265:
    for (;;)
    {
      this.z = new Timer();
      localObject = new TimerTask()
      {
        public void run()
        {
          if ((a.c(a.this) != null) && (a.u(a.this) != null))
          {
            int i = a.s(a.this);
            if ((a.v(a.this) > 0) && (!a.w(a.this)) && (i >= a.v(a.this)))
            {
              a.a(a.this, i);
              a.c(a.this, true);
            }
            while ((localObject.size() > 0) && (((Long)localObject.get(0)).longValue() <= i))
            {
              a.b(a.this, ((Long)localObject.get(0)).longValue());
              localObject.remove(0);
            }
            if (((a.w(a.this)) || (a.v(a.this) <= 0)) && (localObject.size() == 0)) {
              a.x(a.this).cancel();
            }
          }
        }
      };
      try
      {
        this.z.scheduleAtFixedRate((TimerTask)localObject, 0L, i1);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          b.a(localIllegalStateException);
        }
      }
    }
  }
  
  private void C()
  {
    E();
  }
  
  private void D()
  {
    int i1 = cn.domob.android.b.a.u(this.c);
    int i2 = cn.domob.android.b.a.v(this.c);
    if (this.f / this.g > i1 / i2) {
      b(i1, (int)(i1 / this.f * this.g));
    }
    for (;;)
    {
      return;
      b((int)(i2 / this.g * this.f), i2);
    }
  }
  
  private void E()
  {
    this.x.post(new Runnable()
    {
      public void run()
      {
        if (a.z(a.this) != null)
        {
          a.s(a.this);
          a.a(a.this, a.A(a.this));
          a.z(a.this).dismiss();
          a.a(a.this, null);
          a.a(a.this, a.B(a.this), a.C(a.this));
          a.D(a.this).topMargin = 0;
          a.D(a.this).leftMargin = 0;
          a.this.addView(a.A(a.this));
        }
      }
    });
  }
  
  private boolean F()
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.d.d())
    {
      bool1 = bool2;
      if (this.v)
      {
        if (!this.u) {
          break label50;
        }
        bool1 = bool2;
      }
    }
    for (;;)
    {
      if (bool1) {
        I();
      }
      return bool1;
      bool1 = bool2;
      if (!H()) {
        label50:
        bool1 = false;
      }
    }
  }
  
  private boolean G()
  {
    if (!h.e(this.d.c())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean H()
  {
    boolean bool;
    if (G())
    {
      String str1 = this.d.c();
      String str2 = Uri.parse(str1).getScheme();
      if (("http".equals(str2)) || ("https".equals(str2)))
      {
        this.s = new e(this.c);
        this.s.a(this);
        this.s.a(this);
        this.s.loadUrl(str1);
        bool = true;
        return bool;
      }
      b(str1);
      J();
    }
    for (;;)
    {
      bool = false;
      break;
      b.d("detail URL is empty");
      L();
    }
  }
  
  private boolean I()
  {
    if (this.s != null)
    {
      o();
      this.x.post(new Runnable()
      {
        public void run()
        {
          if (a.k(a.this)) {
            a.l(a.this);
          }
          a.A(a.this).removeAllViews();
          a.F(a.this).setLayoutParams(a.E(a.this));
          a.b(a.this, a.F(a.this));
          b.a locala = a.m(a.this).e();
          if (locala.f()) {
            a.b(a.this, a.j(a.this).b());
          }
          if (locala.h()) {
            a.b(a.this, a.j(a.this).a(false));
          }
          if (a.t(a.this) != null) {
            a.t(a.this).cancel();
          }
        }
      });
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void J()
  {
    b.b("DetailPage Load Finish");
    this.v = true;
    if (this.d.d()) {
      w();
    }
  }
  
  private void K()
  {
    this.u = true;
    J();
    if (this.o != null) {
      this.o.q();
    }
  }
  
  private void L()
  {
    if ((this.s != null) && (this.s.getParent() != null) && (!this.d.d())) {
      g();
    }
    for (;;)
    {
      if (this.o != null) {
        this.o.p();
      }
      return;
      J();
    }
  }
  
  private void M()
  {
    if (this.s != null)
    {
      b(this.s);
      this.s.destroy();
      this.s = null;
    }
  }
  
  private int N()
  {
    int i1 = 0;
    int i2 = 0;
    try
    {
      VideoView localVideoView = this.l;
      if (localVideoView != null) {}
      try
      {
        i1 = this.l.getCurrentPosition();
        i2 = i1;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        for (;;)
        {
          b.a(localIllegalStateException);
        }
      }
      i1 = i2;
      if (this.G > 0)
      {
        if ((i2 > 0) && (i2 <= this.G)) {
          this.H = i2;
        }
        if (i2 <= this.G)
        {
          i1 = i2;
          if (i2 >= 0) {}
        }
        else
        {
          b.d(String.format("the value(%d) of video play position is invalid, so turn to the last available pasition(%d)", new Object[] { Integer.valueOf(i2), Integer.valueOf(this.H) }));
          i1 = this.H;
        }
      }
      return i1;
    }
    finally {}
  }
  
  private boolean O()
  {
    boolean bool;
    if (this.k.getParent() != null) {
      if (((RelativeLayout)this.k.getParent() instanceof a)) {
        bool = false;
      }
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = false;
    }
  }
  
  private void P()
  {
    o();
    if (this.l != null)
    {
      this.l.stopPlayback();
      this.l = null;
    }
  }
  
  private void Q()
  {
    this.J = false;
    o();
    this.x.removeCallbacks(this.L);
    if (this.l != null)
    {
      this.l.seekTo(0);
      this.l.start();
      this.e.c(true);
    }
    n();
  }
  
  private void a(long paramLong)
  {
    if (s())
    {
      b.b("imp progress report, time note: " + paramLong);
      this.p.a(paramLong);
    }
  }
  
  private void a(View paramView)
  {
    this.k.addView(paramView);
  }
  
  private void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams)
  {
    this.k.addView(paramView, paramLayoutParams);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if ((this.i != null) && (this.j != null))
    {
      this.i.width = paramInt1;
      this.i.height = paramInt2;
      this.j.width = paramInt1;
      this.j.height = paramInt2;
    }
  }
  
  private void b(long paramLong)
  {
    if (s())
    {
      b.b("imp report min");
      this.p.b(paramLong);
    }
  }
  
  private void b(final View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null)) {
      ((Activity)this.c).runOnUiThread(new Runnable()
      {
        public void run()
        {
          ((ViewGroup)paramView.getParent()).removeView(paramView);
        }
      });
    }
  }
  
  private void b(String paramString)
  {
    if ((this.o != null) && (!h.e(paramString)))
    {
      b.b("Intercept webview url:" + paramString);
      this.o.b(paramString);
    }
  }
  
  private void c(long paramLong)
  {
    if ((this.p != null) && (this.F))
    {
      b.b("imp report finish");
      this.p.c(paramLong);
    }
  }
  
  private void n()
  {
    B();
    t();
  }
  
  private void o()
  {
    if ((this.p != null) && (!this.D))
    {
      this.D = true;
      int i1 = 0;
      if (this.l != null) {
        i1 = N();
      }
      int i2;
      if (i1 > 0)
      {
        i2 = i1;
        if (i1 <= this.G) {}
      }
      else
      {
        i2 = this.H;
      }
      c(i2);
    }
  }
  
  private void p()
  {
    if (this.o != null)
    {
      b.b("call method of callbackOnVideoReadyToPlay");
      this.o.a(this);
      this.B = true;
    }
  }
  
  private void q()
  {
    if (this.o != null) {
      this.o.a(this.B);
    }
  }
  
  private void r()
  {
    try
    {
      g();
      if ((this.o != null) && (!this.E))
      {
        this.E = true;
        this.o.o();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean s()
  {
    if ((this.p != null) && (this.F) && (g.a(this.c, this.k))) {}
    for (boolean bool = true;; bool = false)
    {
      return bool;
      b.d("can not meet condition to send imp report, mResourceAvailable: " + this.F);
    }
  }
  
  private void t()
  {
    if (s())
    {
      b.b("imp report start");
      this.p.n();
    }
  }
  
  private void u()
  {
    if ((this.l != null) && (this.l.canPause())) {}
    try
    {
      this.l.pause();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.a(localException);
      }
    }
  }
  
  private void v()
  {
    if (this.l != null)
    {
      b.b("video resume, current position: " + N() + " total time: " + this.l.getDuration());
      if (this.J) {}
    }
    try
    {
      this.l.start();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.a(localException);
      }
    }
  }
  
  private void w()
  {
    if (x())
    {
      b.b("meet condition to create video");
      this.x.post(new Runnable()
      {
        public void run()
        {
          a.a(a.this);
        }
      });
    }
    for (;;)
    {
      return;
      b.b("can not meet condition to create video");
    }
  }
  
  private boolean x()
  {
    if ((!this.w) && (this.t) && (((this.d.d()) && (this.v)) || (!this.d.d()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  /* Error */
  private void y()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 139	cn/domob/android/j/a:w	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 120	cn/domob/android/j/a:b	Lcn/domob/android/i/f;
    //   17: ldc_w 573
    //   20: invokevirtual 371	cn/domob/android/i/f:b	(Ljava/lang/String;)V
    //   23: aload_0
    //   24: iconst_1
    //   25: putfield 139	cn/domob/android/j/a:w	Z
    //   28: new 248	android/widget/VideoView
    //   31: astore_3
    //   32: aload_3
    //   33: aload_0
    //   34: getfield 180	cn/domob/android/j/a:c	Landroid/content/Context;
    //   37: invokespecial 574	android/widget/VideoView:<init>	(Landroid/content/Context;)V
    //   40: aload_0
    //   41: aload_3
    //   42: putfield 246	cn/domob/android/j/a:l	Landroid/widget/VideoView;
    //   45: aload_0
    //   46: getfield 200	cn/domob/android/j/a:e	Lcn/domob/android/j/d;
    //   49: iconst_1
    //   50: invokevirtual 427	cn/domob/android/j/d:c	(Z)V
    //   53: aload_0
    //   54: getfield 246	cn/domob/android/j/a:l	Landroid/widget/VideoView;
    //   57: astore_3
    //   58: new 38	cn/domob/android/j/a$8
    //   61: astore 4
    //   63: aload 4
    //   65: aload_0
    //   66: invokespecial 575	cn/domob/android/j/a$8:<init>	(Lcn/domob/android/j/a;)V
    //   69: aload_3
    //   70: aload 4
    //   72: invokevirtual 579	android/widget/VideoView:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   75: aload_0
    //   76: getfield 246	cn/domob/android/j/a:l	Landroid/widget/VideoView;
    //   79: astore 4
    //   81: new 40	cn/domob/android/j/a$9
    //   84: astore_3
    //   85: aload_3
    //   86: aload_0
    //   87: invokespecial 580	cn/domob/android/j/a$9:<init>	(Lcn/domob/android/j/a;)V
    //   90: aload 4
    //   92: aload_3
    //   93: invokevirtual 584	android/widget/VideoView:setOnPreparedListener	(Landroid/media/MediaPlayer$OnPreparedListener;)V
    //   96: aload_0
    //   97: getfield 246	cn/domob/android/j/a:l	Landroid/widget/VideoView;
    //   100: astore_3
    //   101: new 16	cn/domob/android/j/a$10
    //   104: astore 4
    //   106: aload 4
    //   108: aload_0
    //   109: invokespecial 585	cn/domob/android/j/a$10:<init>	(Lcn/domob/android/j/a;)V
    //   112: aload_3
    //   113: aload 4
    //   115: invokevirtual 589	android/widget/VideoView:setOnTouchListener	(Landroid/view/View$OnTouchListener;)V
    //   118: aload_0
    //   119: getfield 246	cn/domob/android/j/a:l	Landroid/widget/VideoView;
    //   122: astore_3
    //   123: new 18	cn/domob/android/j/a$11
    //   126: astore 4
    //   128: aload 4
    //   130: aload_0
    //   131: invokespecial 590	cn/domob/android/j/a$11:<init>	(Lcn/domob/android/j/a;)V
    //   134: aload_3
    //   135: aload 4
    //   137: invokevirtual 594	android/widget/VideoView:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   140: aload_0
    //   141: aload_0
    //   142: getfield 246	cn/domob/android/j/a:l	Landroid/widget/VideoView;
    //   145: aload_0
    //   146: getfield 213	cn/domob/android/j/a:j	Landroid/widget/RelativeLayout$LayoutParams;
    //   149: invokespecial 596	cn/domob/android/j/a:a	(Landroid/view/View;Landroid/widget/RelativeLayout$LayoutParams;)V
    //   152: aload_0
    //   153: getfield 246	cn/domob/android/j/a:l	Landroid/widget/VideoView;
    //   156: invokevirtual 563	android/widget/VideoView:getDuration	()I
    //   159: istore_1
    //   160: aload_0
    //   161: aload_0
    //   162: getfield 200	cn/domob/android/j/a:e	Lcn/domob/android/j/d;
    //   165: iload_1
    //   166: sipush 1000
    //   169: idiv
    //   170: invokevirtual 599	cn/domob/android/j/d:c	(I)Landroid/widget/RelativeLayout;
    //   173: invokespecial 494	cn/domob/android/j/a:a	(Landroid/view/View;)V
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 200	cn/domob/android/j/a:e	Lcn/domob/android/j/d;
    //   181: invokevirtual 602	cn/domob/android/j/d:e	()Landroid/widget/RelativeLayout;
    //   184: invokespecial 494	cn/domob/android/j/a:a	(Landroid/view/View;)V
    //   187: aload_0
    //   188: invokespecial 603	cn/domob/android/j/a:p	()V
    //   191: goto -180 -> 11
    //   194: astore_3
    //   195: aload_0
    //   196: monitorexit
    //   197: aload_3
    //   198: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	199	0	this	a
    //   159	11	1	i1	int
    //   6	2	2	bool	boolean
    //   31	104	3	localObject1	Object
    //   194	4	3	localObject2	Object
    //   61	75	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	194	finally
    //   14	191	194	finally
  }
  
  private void z()
  {
    if (this.y == null)
    {
      TimerTask local12 = new TimerTask()
      {
        public void run()
        {
          try
          {
            if (a.c(a.this) != null) {
              if (a.r(a.this))
              {
                int i = (a.c(a.this).getDuration() - a.s(a.this)) / 1000;
                a.j(a.this).a(i);
              }
            }
            for (;;)
            {
              return;
              a.t(a.this).cancel();
              a.a(a.this, null);
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              a.m().a(localException);
            }
          }
        }
      };
      this.y = new Timer();
      this.y.scheduleAtFixedRate(local12, 0L, 1000L);
    }
  }
  
  public void a()
  {
    v();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.m != null) {
      D();
    }
    for (;;)
    {
      this.f = paramInt1;
      this.g = paramInt2;
      ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.width = paramInt1;
        localLayoutParams.height = paramInt2;
      }
      return;
      b(paramInt1, paramInt2);
    }
  }
  
  public void a(b paramb)
  {
    this.q = paramb;
  }
  
  public void a(b.a.a.a parama)
  {
    String str = parama.d();
    int i1;
    if (h.e(str))
    {
      str = parama.b();
      if (str.equals("goto"))
      {
        F();
        parama = parama.f();
        if (parama == null) {
          return;
        }
        i1 = 0;
        label43:
        if (i1 >= parama.length) {
          return;
        }
        if (!h.e(parama[i1]))
        {
          if (!parama[i1].startsWith("http")) {
            break label120;
          }
          if (this.o != null) {
            this.o.c(parama[i1]);
          }
        }
      }
    }
    for (;;)
    {
      i1++;
      break label43;
      if (!str.equals("replay")) {
        break;
      }
      Q();
      break;
      b(str);
      break;
      label120:
      b(parama[i1]);
    }
  }
  
  public void a(e parame)
  {
    b.b("detail page load successfully");
    K();
  }
  
  public void a(String paramString)
  {
    b(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (!this.A)
      {
        this.A = true;
        if (this.z != null) {
          this.z.cancel();
        }
        if (this.y != null) {
          this.y.cancel();
        }
        Activity localActivity = (Activity)this.c;
        Runnable local5 = new cn/domob/android/j/a$5;
        local5.<init>(this);
        localActivity.runOnUiThread(local5);
        if (!paramBoolean) {
          q();
        }
        if (this.n != null) {
          this.n.b();
        }
        b.b("destroy videoAdView");
      }
      return;
    }
    finally {}
  }
  
  public void a(long[] paramArrayOfLong, c paramc)
  {
    if ((paramArrayOfLong != null) && (paramc != null))
    {
      this.r = paramArrayOfLong;
      Arrays.sort(this.r);
      this.p = paramc;
    }
    for (;;)
    {
      return;
      b.e("the method setImpProgressListener parameter error");
    }
  }
  
  public void b()
  {
    u();
  }
  
  public void b(e parame)
  {
    b.d("detail page load failed");
    L();
  }
  
  public void c()
  {
    b.b("start to play video when prepared");
    if (this.l != null)
    {
      this.l.setVideoPath(this.h);
      b.a("video local path: " + this.h);
      this.l.start();
      this.n = new c(this.c, this);
      this.n.a();
    }
  }
  
  public void c(e parame)
  {
    if (!this.A)
    {
      b.d("detail page load timeout");
      this.x.post(new Runnable()
      {
        public void run()
        {
          a.I(a.this);
        }
      });
    }
    for (;;)
    {
      return;
      b.d("detail page load timeout and videoAdView has destroyed now");
    }
  }
  
  public void d()
  {
    u();
    this.K = true;
  }
  
  public void e()
  {
    v();
    this.K = false;
  }
  
  public void f()
  {
    this.m = new Dialog(this.c, 16973841);
    this.e.b(false);
    this.m.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        a.l(a.this);
        a.j(a.this).b(true);
        if (a.y(a.this) != null) {
          a.y(a.this).b();
        }
      }
    });
    RelativeLayout localRelativeLayout = new RelativeLayout(this.c);
    localRelativeLayout.setBackgroundColor(-16777216);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.m.setContentView(localRelativeLayout);
    N();
    b(this.k);
    D();
    localRelativeLayout.addView(this.k);
    this.m.show();
  }
  
  public void g()
  {
    a(false);
  }
  
  public void h()
  {
    g();
  }
  
  public void i()
  {
    if (O()) {
      C();
    }
    for (;;)
    {
      return;
      f();
    }
  }
  
  public void j()
  {
    b.b("button images download finish");
    this.t = true;
    w();
  }
  
  public void k()
  {
    b.b("no image need to download");
    this.t = true;
    w();
  }
  
  public b l()
  {
    return this.d;
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama);
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void b(String paramString);
    
    public abstract void c(String paramString);
    
    public abstract void o();
    
    public abstract void p();
    
    public abstract void q();
  }
  
  public static abstract interface b
  {
    public abstract void b();
  }
  
  public static abstract interface c
  {
    public abstract void a(long paramLong);
    
    public abstract void b(long paramLong);
    
    public abstract void c(long paramLong);
    
    public abstract void n();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */