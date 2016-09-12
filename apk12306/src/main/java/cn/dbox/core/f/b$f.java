package cn.dbox.core.f;

import cn.dbox.core.b.d;
import cn.dbox.core.b.n;
import cn.dbox.core.bean.a;
import cn.dbox.core.c;
import java.util.HashMap;

class b$f
  extends b.c
{
  b$f(b paramb, c paramc, a parama)
  {
    super(paramb, paramc, parama, b.n.e);
    this.b.put("type", "ad_clk");
    this.b.put("sid", paramc.e());
  }
  
  public void a(int paramInt)
  {
    this.b.put("position", String.valueOf(paramInt));
  }
  
  public void a(b.d paramd)
  {
    String str = "";
    switch (b.1.f[paramd.ordinal()])
    {
    default: 
      paramd = str;
    }
    for (;;)
    {
      this.b.put("element", paramd);
      return;
      paramd = "banner_ad";
      continue;
      paramd = "list_ad";
      continue;
      paramd = "listad_down";
      continue;
      paramd = "details_down";
    }
  }
  
  public void a(String paramString)
  {
    this.b.put("chanid", String.valueOf(paramString));
  }
  
  protected void b(String paramString)
  {
    b.p localp = new b.p(this.a);
    localp.a(this.d.f(), this.b, paramString);
    if ((this.c.n() != null) && (!((String)this.b.get("type")).equals("details_down"))) {
      localp.a(this.d.f(), this.b, this.c.n());
    }
  }
  
  public void c(String paramString)
  {
    this.b.put("acid", String.valueOf(paramString));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */