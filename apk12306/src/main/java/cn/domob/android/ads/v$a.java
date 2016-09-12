package cn.domob.android.ads;

import android.content.Context;
import android.view.View;
import cn.domob.android.i.f;
import cn.domob.android.i.g;

public class v$a
{
  public static final String a = "rectangle";
  public static final String b = "triangle";
  private v c;
  private v.e d;
  
  public v$a(Context paramContext)
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


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\v$a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */