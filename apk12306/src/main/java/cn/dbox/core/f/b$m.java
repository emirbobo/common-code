package cn.dbox.core.f;

import cn.dbox.core.c;
import java.util.HashMap;

class b$m
  extends b.c
{
  b$m(b paramb, c paramc)
  {
    super(paramb, paramc, cn.dbox.core.b.n.e);
    this.b.put("type", "ad_imp");
    this.b.put("sid", paramc.e());
  }
  
  void a(String paramString)
  {
    this.b.put("tr", paramString);
    a(this.b, paramString);
  }
  
  protected void b(String paramString)
  {
    new b.n(this.a, this.d.f()).a(this.b, String.valueOf(cn.dbox.core.b.n.e.ordinal()), paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */