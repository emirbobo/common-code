package cn.domob.android.ads.c;

import android.os.Handler;

public class d
{
  private Handler a;
  private a b;
  private c c = c.c;
  private long d;
  private long e;
  
  public d(Handler paramHandler, b paramb)
  {
    this.a = paramHandler;
    this.b = new a(paramb);
  }
  
  private boolean h()
  {
    if ((this.a != null) && (this.b.b())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public long a()
  {
    return this.e;
  }
  
  public void a(long paramLong)
  {
    if (h())
    {
      this.e = paramLong;
      this.a.postDelayed(this.b, this.e);
      this.c = c.a;
      this.d = System.currentTimeMillis();
    }
  }
  
  public void a(b paramb)
  {
    this.b.a(paramb);
  }
  
  public void b()
  {
    if ((h()) && (this.c == c.a))
    {
      this.a.removeCallbacks(this.b);
      this.e -= System.currentTimeMillis() - this.d;
      this.c = c.b;
    }
  }
  
  public void c()
  {
    if ((h()) && (this.c == c.b))
    {
      this.a.postDelayed(this.b, this.e);
      this.d = System.currentTimeMillis();
      this.c = c.a;
    }
  }
  
  public void d()
  {
    if (h())
    {
      this.a.removeCallbacks(this.b);
      this.b.run();
    }
    this.c = c.c;
    this.a = null;
  }
  
  public void e()
  {
    if (h()) {
      this.a.removeCallbacks(this.b);
    }
    this.c = c.c;
  }
  
  public void f()
  {
    if (h()) {
      this.a.removeCallbacks(this.b);
    }
    this.c = c.c;
    this.a = null;
  }
  
  public boolean g()
  {
    return this.b.a();
  }
  
  private class a
    implements Runnable
  {
    private boolean b = false;
    private d.b c;
    
    protected a(d.b paramb)
    {
      this.c = paramb;
    }
    
    protected void a(d.b paramb)
    {
      this.c = paramb;
    }
    
    protected boolean a()
    {
      return this.b;
    }
    
    protected boolean b()
    {
      if ((this.c != null) && (!this.b)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public void run()
    {
      if (this.c != null)
      {
        this.c.a();
        this.b = true;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a();
  }
  
  static enum c
  {
    private c() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */