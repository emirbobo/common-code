package cn.domob.wall.core.d;

import cn.domob.wall.core.h.d;

class b$6
  implements c.a
{
  b$6(b paramb) {}
  
  public void a()
  {
    if (this.a.b != null) {
      this.a.b.a();
    }
    b.a(this.a).loadUrl("");
    b.b().b("you click close button");
  }
  
  public void b()
  {
    if (b.a(this.a).canGoBack())
    {
      b.a(this.a).goBack();
      b.b().b("webView canGoBack");
    }
    for (;;)
    {
      this.a.a();
      b.b().b("you click back button");
      return;
      if (this.a.b != null) {
        this.a.b.a();
      }
    }
  }
  
  public void c()
  {
    if (b.a(this.a).canGoForward()) {
      b.a(this.a).goForward();
    }
    this.a.a();
    b.b().b("you click forward button");
  }
  
  public void d()
  {
    b.a(this.a).reload();
    this.a.a();
    b.b().b("you click refresh button");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\b$6.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */