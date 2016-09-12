package cn.domob.android.ads;

import android.content.Context;
import android.view.View;
import java.util.HashMap;

public abstract class n
{
  protected Context a;
  protected k b;
  protected j c;
  protected g d;
  protected a e;
  protected View f;
  
  public n(Context paramContext, k paramk, j paramj, g paramg)
  {
    this.a = paramContext;
    this.b = paramk;
    this.c = paramj;
    this.d = paramg;
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  protected void a(DomobAdManager.ErrorCode paramErrorCode, String paramString)
  {
    if (this.e != null) {
      this.e.a(paramErrorCode, paramString);
    }
  }
  
  public void a(a parama)
  {
    this.e = parama;
  }
  
  protected void a(String paramString)
  {
    if (this.e != null) {
      this.e.a(paramString);
    }
  }
  
  public abstract void a(HashMap<String, String> paramHashMap, String paramString, long paramLong);
  
  public View b()
  {
    return this.f;
  }
  
  public j c()
  {
    return this.c;
  }
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract void f();
  
  protected void g()
  {
    if (this.e != null) {
      this.e.a(this);
    }
  }
  
  protected void h()
  {
    if (this.e != null) {
      this.e.a();
    }
  }
  
  protected Context i()
  {
    if (this.e != null) {}
    for (Context localContext = this.e.b();; localContext = this.a) {
      return localContext;
    }
  }
  
  protected void j()
  {
    if (this.e != null) {
      this.e.c();
    }
  }
  
  protected void k()
  {
    if (this.e != null) {
      this.e.d();
    }
  }
  
  protected void l()
  {
    if (this.e != null) {
      this.e.e();
    }
  }
  
  protected void m()
  {
    if (this.e != null) {
      this.e.f();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void a(DomobAdManager.ErrorCode paramErrorCode, String paramString);
    
    public abstract void a(n paramn);
    
    public abstract void a(String paramString);
    
    public abstract Context b();
    
    public abstract void c();
    
    public abstract void d();
    
    public abstract void e();
    
    public abstract void f();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */