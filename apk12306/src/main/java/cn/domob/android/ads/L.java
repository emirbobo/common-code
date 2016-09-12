package cn.domob.android.ads;

import android.app.Activity;
import android.content.Context;
import cn.domob.android.b.a;

public class l
  implements n.a
{
  private cn.domob.android.i.f a = new cn.domob.android.i.f(l.class.getSimpleName());
  private g b;
  private m c;
  private f d;
  
  public l(g paramg, m paramm)
  {
    this.b = paramg;
    this.c = paramm;
    this.d = new f();
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.onDomobAdClicked();
    }
  }
  
  protected void a(Context paramContext, j paramj)
  {
    j.c localc = paramj.d();
    int i;
    int j;
    if (localc.c() == 0)
    {
      i = a.u(paramContext);
      if (localc.d() != 0) {
        break label111;
      }
      j = a.v(paramContext);
      label33:
      if (this.c != null) {
        this.c.setCreativeRect(i, j);
      }
      paramj = this.d.a(paramContext, this.b, paramj, i, j);
      if (paramj == null) {
        break label128;
      }
      paramj.a(this);
      ((Activity)paramContext).runOnUiThread(new l.1(this, paramj));
    }
    for (;;)
    {
      return;
      i = (int)(localc.c() * a.t(paramContext));
      break;
      label111:
      j = (int)(localc.d() * a.t(paramContext));
      break label33;
      label128:
      this.a.b("bad ad received");
      this.b.a(DomobAdManager.ErrorCode.INTERNAL_ERROR);
    }
  }
  
  public void a(DomobAdManager.ErrorCode paramErrorCode, String paramString)
  {
    this.a.e(String.format("FAILED to load ad content view and the errorMessage is: %s", new Object[] { paramString }));
    this.b.a(paramErrorCode);
  }
  
  public void a(n paramn)
  {
    if (this.c != null) {
      this.c.onDomobAdReturned(paramn);
    }
  }
  
  public void a(String paramString)
  {
    if (this.c != null) {
      this.c.onProcessActionType(paramString);
    }
  }
  
  public Context b()
  {
    Context localContext;
    if (this.c != null)
    {
      localContext = this.c.onDomobAdRequiresCurrentContext();
      if (localContext == null) {}
    }
    for (;;)
    {
      return localContext;
      localContext = this.b.x();
    }
  }
  
  public void c()
  {
    this.b.c();
    this.b.a(g.a.b);
    if (this.c != null) {
      this.c.onDomobAdOverlayPresented();
    }
  }
  
  public void d()
  {
    this.b.a(g.a.a);
    this.b.e();
    if (this.c != null) {
      this.c.onDomobAdOverlayDismissed();
    }
  }
  
  public void e()
  {
    if (this.c != null) {
      this.c.onDomobLeaveApplication();
    }
  }
  
  public void f()
  {
    this.a.b("ad call to close itself");
    if (this.c != null) {
      this.c.close();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\L.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */