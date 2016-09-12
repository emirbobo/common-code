package cn.domob.android.ads.a;

import cn.domob.android.ads.DomobAdManager.ErrorCode;
import cn.domob.android.ads.a;
import cn.domob.android.ads.a.b;
import cn.domob.android.ads.j;
import cn.domob.android.ads.j.c;
import cn.domob.android.ads.j.c.a;
import cn.domob.android.i.f;

class c$2
  implements a.b
{
  c$2(c paramc) {}
  
  public void a(a parama)
  {
    c.v().b("Both banner and expandable part are ok in current creative. Show Ad.");
    c.l(this.a);
    if (c.m(this.a).d().n().i()) {
      c.a(this.a, c.n(this.a).d().n());
    }
  }
  
  public void b(a parama)
  {
    c.v().e("FAILED to load domob expandable view.");
    c.d(this.a, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Expandable part load failed.");
  }
  
  public void c(a parama)
  {
    c.v().a("Timeout while loading expandable part. Show AD.");
    c.k(this.a);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\c$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */