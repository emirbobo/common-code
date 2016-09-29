package cn.domob.android.ads.a;

import cn.domob.android.ads.DomobAdManager.ErrorCode;
import cn.domob.android.ads.a;
import cn.domob.android.ads.a.b;
import cn.domob.android.ads.g;
import cn.domob.android.ads.j;
import cn.domob.android.ads.j.c;
import cn.domob.android.ads.j.c.a;
import cn.domob.android.i.f;

class c$1$1
  implements a.b
{
  c$1$1(c.1 param1) {}
  
  public void a(a parama)
  {
    c.v().a("Finished to load domob banner view.");
    parama = c.f(this.a.b).d().n();
    if (parama != null)
    {
      c.a(this.a.b, new e(c.g(this.a.b), "expandable", 0));
      c.v().b("There is expandable part in current creative.");
      c.a(this.a.b, c.h(this.a.b), parama, parama.g());
      if (!parama.g()) {}
    }
    label147:
    for (;;)
    {
      return;
      c.v().b("Expandable preload is disabled in current creative. Show Ad.");
      for (;;)
      {
        if (c.i(this.a.b).G()) {
          break label147;
        }
        c.j(this.a.b);
        break;
        c.v().b("Banner is ready and there is no expandable part in current creative. Show Ad.");
      }
    }
  }
  
  public void b(a parama)
  {
    c.v().e("FAILED to load domob banner view.");
    c.b(this.a.b, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load failed.");
  }
  
  public void c(a parama)
  {
    c.a(this.a.b, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load timeout.");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\c$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */