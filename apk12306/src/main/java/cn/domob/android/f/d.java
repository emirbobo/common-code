package cn.domob.android.f;

public class d
  implements Runnable
{
  private static String b;
  private static String c;
  private static final String[] h = { "domob.cn/a/", "domob.org/a/", "duomeng.org/a/", "duomeng.net/a/", "duomeng.cn/a/", "domob.com.cn/a/" };
  protected String a;
  private final b d;
  private final g e;
  private final f f;
  private final boolean g;
  
  public d(e parame)
  {
    b localb = new b(parame.a());
    localb.a(parame.f());
    localb.c(parame.g());
    localb.a(parame.j());
    localb.d(parame.i());
    this.d = localb;
    this.e = parame.d();
    this.a = parame.b();
    this.f = parame.c();
    this.g = parame.h();
  }
  
  public static void a(String paramString)
  {
    b = paramString;
  }
  
  private void e()
  {
    this.d.a(new b.b()
    {
      public String a()
      {
        return d.b();
      }
      
      public void a(String paramAnonymousString)
      {
        d.b(paramAnonymousString);
      }
      
      public String[] b()
      {
        return d.c();
      }
      
      public String c()
      {
        return d.d();
      }
    });
  }
  
  public h a()
  {
    if (this.g)
    {
      if (cn.domob.android.i.h.e(b))
      {
        c = this.a;
        b = this.a;
      }
      this.d.b(b);
      if (this.f == null) {
        break label179;
      }
      this.d.e(this.f.b());
    }
    for (;;)
    {
      if (this.g)
      {
        this.d.a(true);
        e();
      }
      this.d.h();
      h localh = new h();
      localh.a(this.d.d());
      localh.a(this.a);
      localh.a(this.d.f());
      localh.b(this.d.a());
      localh.c(this.d.e());
      if (this.e != null) {
        this.e.b(localh);
      }
      return localh;
      this.d.b(this.a);
      break;
      label179:
      this.d.e(null);
    }
  }
  
  public void run()
  {
    a();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\f\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */