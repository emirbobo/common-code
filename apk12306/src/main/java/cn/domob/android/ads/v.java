package cn.domob.android.ads;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import cn.domob.android.b.a;
import cn.domob.android.i.d;
import cn.domob.android.i.f;
import cn.domob.android.i.g;
import cn.domob.android.i.h;

public class v
{
  public static final int a = -1;
  public static final int b = 1232;
  public static final String c = "btn_close_interstitial.png";
  public static final String d = "btn_close_interstitial_pressed.png";
  public static final String e = "domob_close.png";
  public static final int f = 36;
  public static final int g = 36;
  private static f h = new f(v.class.getSimpleName());
  private static final int i = 5;
  private static final int j = 15;
  private static final int k = 88;
  private static final int l = 28;
  private e m;
  private Dialog n;
  private Handler o = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        return;
        ((ImageButton)paramAnonymousMessage.obj).setVisibility(0);
        continue;
        v.b().a("Arrival auto-off time");
        if (v.a(v.this).isShowing())
        {
          v.a(v.this).dismiss();
          continue;
          v.b().a("the time of ad to reach the minimum");
          v.a(v.this).setCancelable(true);
          if (v.e.a(v.b(v.this)) != null) {
            v.e.a(v.b(v.this)).b();
          }
        }
      }
    }
  };
  
  private v(e parame)
  {
    this.m = parame;
  }
  
  private int a(int paramInt)
  {
    return g.a(e.b(this.m), paramInt);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 < 0) {}
    for (paramInt1 = Math.abs(paramInt3) + paramInt1;; paramInt1 = Math.max(paramInt3 + paramInt2, paramInt1)) {
      return paramInt1;
    }
  }
  
  private RelativeLayout.LayoutParams a(String paramString)
  {
    if (("triangle".equals(paramString)) || (!e.g(this.m))) {}
    for (paramString = i();; paramString = h()) {
      return paramString;
    }
  }
  
  private RelativeLayout a(Integer paramInteger)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(e.b(this.m));
    if (paramInteger != null) {
      localRelativeLayout.setBackgroundColor(paramInteger.intValue());
    }
    return localRelativeLayout;
  }
  
  private void a(View paramView)
  {
    if ((paramView == null) || (paramView.getParent() != null))
    {
      h.e("需要弹出显示的View已经被加载其他ViewGroup中，需要remove之后显示。");
      return;
    }
    if (e.h(this.m)) {}
    for (Object localObject = Integer.valueOf(e.i(this.m));; localObject = null)
    {
      localObject = a((Integer)localObject);
      RelativeLayout localRelativeLayout = a(Integer.valueOf(e.j(this.m)));
      localRelativeLayout.setId(1232);
      localRelativeLayout.addView(paramView, g());
      ((RelativeLayout)localObject).addView(localRelativeLayout, a(e.k(this.m)));
      if (e.g(this.m)) {
        ((RelativeLayout)localObject).addView(b(e.k(this.m)), c(e.k(this.m)));
      }
      this.n = b(paramView);
      this.n.addContentView((View)localObject, p());
      if (e.l(this.m))
      {
        paramView = new Message();
        paramView.what = 1;
        this.o.sendMessageDelayed(paramView, e.m(this.m));
      }
      this.n.setContentView((View)localObject);
      this.n.show();
      if (e.a(this.m) == null) {
        break;
      }
      e.a(this.m).a();
      break;
    }
  }
  
  private void a(View paramView, String paramString)
  {
    if ((paramView != null) && (!h.e(paramString))) {
      paramView.setBackgroundDrawable(d.b(e.b(this.m), paramString));
    }
  }
  
  private void a(ImageButton paramImageButton)
  {
    paramImageButton.setVisibility(8);
    paramImageButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (v.a(v.this).isShowing()) {
          v.a(v.this).dismiss();
        }
      }
    });
    Message localMessage = new Message();
    localMessage.obj = paramImageButton;
    localMessage.what = 0;
    this.o.sendMessageDelayed(localMessage, e.x(this.m));
  }
  
  private Dialog b(final View paramView)
  {
    this.n = new Dialog(e.b(this.m), 16973841);
    this.n.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        ((ViewGroup)paramView.getParent()).removeAllViews();
        if (v.e.y(v.b(v.this)) != null) {
          v.e.y(v.b(v.this)).a();
        }
        if (v.e.a(v.b(v.this)) != null) {
          v.e.a(v.b(v.this)).c();
        }
      }
    });
    if (e.z(this.m))
    {
      this.n.setCancelable(false);
      paramView = new Message();
      paramView.what = 2;
      this.o.sendMessageDelayed(paramView, e.x(this.m));
    }
    return this.n;
  }
  
  private ImageButton b(String paramString)
  {
    if ("triangle".equals(paramString)) {}
    for (paramString = m();; paramString = l())
    {
      a(paramString);
      return paramString;
    }
  }
  
  private RelativeLayout.LayoutParams c(String paramString)
  {
    if ("triangle".equals(paramString)) {}
    for (paramString = n();; paramString = o()) {
      return paramString;
    }
  }
  
  private boolean c()
  {
    boolean bool = false;
    int i1 = e();
    int i2 = f();
    if (i1 >= e.n(this.m) + e.o(this.m)) {}
    for (;;)
    {
      return bool;
      if (i2 < e.p(this.m) + e.q(this.m)) {
        bool = true;
      }
    }
  }
  
  private boolean d()
  {
    int i3 = e();
    int i2 = f();
    int i1 = a.u(e.b(this.m));
    if ((a.v(e.b(this.m)) > i2) && (i1 > i3)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int e()
  {
    if (e.g(this.m)) {}
    for (int i1 = a(e.o(this.m), e.n(this.m), e.r(this.m)[0]);; i1 = e.o(this.m)) {
      return i1;
    }
  }
  
  private int f()
  {
    if (e.g(this.m)) {}
    for (int i1 = a(e.q(this.m), e.p(this.m), e.r(this.m)[1]);; i1 = e.q(this.m)) {
      return i1;
    }
  }
  
  private RelativeLayout.LayoutParams g()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(e.o(this.m), e.q(this.m));
    localLayoutParams.addRule(13);
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams h()
  {
    RelativeLayout.LayoutParams localLayoutParams = j();
    localLayoutParams.addRule(14);
    localLayoutParams.topMargin = k();
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams i()
  {
    RelativeLayout.LayoutParams localLayoutParams = j();
    if ((!e.s(this.m)) && (!e.t(this.m)) && (!e.u(this.m)) && (!e.v(this.m))) {
      localLayoutParams.addRule(13);
    }
    if (e.s(this.m)) {
      localLayoutParams.addRule(9);
    }
    if (e.u(this.m)) {
      localLayoutParams.addRule(11);
    }
    if (e.t(this.m)) {
      localLayoutParams.addRule(10);
    }
    if (e.v(this.m)) {
      localLayoutParams.addRule(12);
    }
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams j()
  {
    int i3 = -1;
    int i1 = 0;
    if (e.w(this.m)) {
      i1 = a(5) * 2;
    }
    if (e.o(this.m) != -1) {}
    for (int i2 = e.o(this.m) + i1;; i2 = -1)
    {
      if (e.q(this.m) != -1) {
        i3 = e.q(this.m) + i1;
      }
      return new RelativeLayout.LayoutParams(i2, i3);
    }
  }
  
  private int k()
  {
    int i1 = (f() - e.q(this.m)) / 2;
    int i2 = a.v(e.b(this.m));
    int i3 = e.q(this.m);
    if (e.r(this.m)[1] < 0) {
      i1 += (i2 - i3) / 2;
    }
    for (;;)
    {
      return i1;
      i1 = (i2 - i3) / 2 - i1;
    }
  }
  
  private ImageButton l()
  {
    final ImageButton localImageButton = new ImageButton(e.b(this.m));
    a(localImageButton, "btn_close_interstitial.png");
    localImageButton.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if (paramAnonymousMotionEvent.getAction() == 0) {
          v.a(v.this, localImageButton, "btn_close_interstitial_pressed.png");
        }
        for (;;)
        {
          return false;
          if (paramAnonymousMotionEvent.getAction() == 1) {
            v.a(v.this, localImageButton, "btn_close_interstitial.png");
          }
        }
      }
    });
    return localImageButton;
  }
  
  private ImageButton m()
  {
    ImageButton localImageButton = new ImageButton(e.b(this.m));
    a(localImageButton, "domob_close.png");
    return localImageButton;
  }
  
  private RelativeLayout.LayoutParams n()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(e.n(this.m), e.p(this.m));
    localLayoutParams.addRule(6, 1232);
    localLayoutParams.addRule(7, 1232);
    return localLayoutParams;
  }
  
  private RelativeLayout.LayoutParams o()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(e.n(this.m), e.p(this.m));
    int i2;
    if ((e.r(this.m) != null) && (e.r(this.m).length == 2))
    {
      if (!e.w(this.m)) {
        break label107;
      }
      i2 = 5;
    }
    for (int i1 = 5;; i1 = 0)
    {
      localLayoutParams.leftMargin = (e.r(this.m)[0] + i1);
      localLayoutParams.topMargin = (i2 + e.r(this.m)[1]);
      localLayoutParams.addRule(6, 1232);
      localLayoutParams.addRule(5, 1232);
      return localLayoutParams;
      label107:
      i2 = 0;
    }
  }
  
  private RelativeLayout.LayoutParams p()
  {
    return new RelativeLayout.LayoutParams(-1, -1);
  }
  
  public void a()
  {
    if ((this.n != null) && (this.n.isShowing())) {}
    try
    {
      this.n.dismiss();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
  
  public static class a
  {
    public static final String a = "rectangle";
    public static final String b = "triangle";
    private v c;
    private v.e d;
    
    public a(Context paramContext)
    {
      v.b().a("Init and config present dialog.");
      this.d = new v.e(paramContext);
    }
    
    private boolean a(v paramv)
    {
      boolean bool = false;
      if ((v.e.e(this.d)) && (!v.c(paramv))) {
        v.b().d("Interstitial is too big, Give up ads show");
      }
      for (;;)
      {
        return bool;
        if ((v.e.f(this.d)) && (v.e.g(this.d)) && (v.d(paramv))) {
          v.b().d("Close button and ad views overlap, Give up ads show");
        } else {
          bool = true;
        }
      }
    }
    
    public a a(int paramInt)
    {
      v.e.e(this.d, paramInt);
      return this;
    }
    
    public a a(int paramInt1, int paramInt2)
    {
      v.e.a(this.d, paramInt1);
      v.e.b(this.d, paramInt2);
      return this;
    }
    
    public a a(v.b paramb)
    {
      v.e.a(this.d, paramb);
      return this;
    }
    
    public a a(v.c paramc)
    {
      v.e.a(this.d, paramc);
      return this;
    }
    
    public a a(v.d paramd)
    {
      v.e.a(this.d, paramd);
      return this;
    }
    
    public a a(String paramString)
    {
      v.e.a(this.d, paramString);
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      v.b().a("Close button is needed for present dialog.");
      v.e.a(this.d, paramBoolean);
      return this;
    }
    
    public a a(boolean paramBoolean, float paramFloat)
    {
      v.b().a("Force show is needed for present dialog with time = " + paramFloat);
      if (paramBoolean)
      {
        v.e.b(this.d, true);
        v.e.c(this.d, (int)paramFloat * 1000);
      }
      return this;
    }
    
    public a a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
    {
      v.e.d(this.d, paramBoolean1);
      v.e.e(this.d, paramBoolean2);
      v.e.f(this.d, paramBoolean3);
      v.e.g(this.d, paramBoolean4);
      return this;
    }
    
    public a a(int[] paramArrayOfInt)
    {
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length == 2))
      {
        v.b().a(String.format("Close button offset x: %d y: %d", new Object[] { new Integer(paramArrayOfInt[0]), new Integer(paramArrayOfInt[1]) }));
        paramArrayOfInt[0] = g.a(v.e.b(this.d), paramArrayOfInt[0]);
        paramArrayOfInt[1] = g.a(v.e.b(this.d), paramArrayOfInt[1]);
        v.e.a(this.d, paramArrayOfInt);
      }
      for (;;)
      {
        return this;
        v.e.a(this.d, null);
      }
    }
    
    public void a()
    {
      this.c.a();
    }
    
    public void a(View paramView)
    {
      v.e.c(this.d);
      this.c = new v(this.d, null);
      if (a(this.c)) {
        v.a(this.c, paramView);
      }
      for (;;)
      {
        return;
        if (v.e.d(this.d) != null) {
          v.e.d(this.d).a();
        }
      }
    }
    
    public a b(int paramInt)
    {
      v.e.f(this.d, paramInt);
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      v.e.h(this.d, paramBoolean);
      return this;
    }
    
    public a b(boolean paramBoolean, float paramFloat)
    {
      v.b().a("Auto close is needed for present dialog with time = " + paramFloat);
      if (paramBoolean)
      {
        v.e.c(this.d, true);
        v.e.d(this.d, (int)paramFloat * 1000);
      }
      return this;
    }
    
    public a c(boolean paramBoolean)
    {
      v.e.i(this.d, paramBoolean);
      return this;
    }
    
    public a d(boolean paramBoolean)
    {
      v.e.j(this.d, paramBoolean);
      return this;
    }
    
    public a e(boolean paramBoolean)
    {
      v.e.k(this.d, paramBoolean);
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
  }
  
  public static abstract interface d
  {
    public abstract void a();
  }
  
  public static class e
  {
    private Context a;
    private int b = -1;
    private int c = -1;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private v.d h;
    private v.c i;
    private v.b j;
    private boolean k = false;
    private String l = "triangle";
    private int[] m = null;
    private boolean n = false;
    private int o = 0;
    private boolean p = false;
    private int q = 0;
    private boolean r = false;
    private int s = Color.parseColor("#7f000000");
    private boolean t = true;
    private int u = Color.parseColor("#7f000000");
    private boolean v = false;
    private boolean w = false;
    private int x;
    private int y;
    
    e(Context paramContext)
    {
      this.a = paramContext;
    }
    
    private void a()
    {
      if (this.k)
      {
        if (!"rectangle".equals(this.l)) {
          break label70;
        }
        this.x = g.a(this.a, 88);
        this.y = g.a(this.a, 28);
        if ((this.m == null) || (this.m.length != 2)) {
          this.m = b();
        }
      }
      for (;;)
      {
        return;
        label70:
        if ("triangle".equals(this.l))
        {
          this.x = g.a(this.a, 36);
          this.y = g.a(this.a, 36);
        }
      }
    }
    
    private int[] b()
    {
      return new int[] { (this.b - this.x) / 2, -(g.a(this.a, 15) + this.y) };
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */