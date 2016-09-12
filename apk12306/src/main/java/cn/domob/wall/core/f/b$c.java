package cn.domob.wall.core.f;

import cn.domob.wall.core.DService;
import cn.domob.wall.core.b.a;
import cn.domob.wall.core.bean.AdInfo;
import cn.domob.wall.core.h.f;
import java.util.HashMap;

class b$c
  extends b.a
{
  b$c(b paramb, cn.domob.wall.core.b paramb1, AdInfo paramAdInfo)
  {
    super(paramb, paramb1, paramAdInfo, b.n.d);
  }
  
  protected void a()
  {
    b.l locall = new b.l(this.e);
    if (DService.getEndpoint().equals("online")) {
      locall.a(this.c.g(), this.a, f.f(a.k));
    }
    for (;;)
    {
      if ((this.b.getClickTrackerUrl() != null) && (!((String)this.a.get("type")).equals("details_down"))) {
        locall.a(this.c.g(), this.a, this.b.getClickTrackerUrl());
      }
      return;
      locall.a(this.c.g(), this.a, f.f(a.o));
    }
  }
  
  public void a(int paramInt)
  {
    this.a.put("order", String.valueOf(paramInt));
  }
  
  public void a(b.k paramk)
  {
    String str = "";
    switch (b.1.e[paramk.ordinal()])
    {
    default: 
      paramk = str;
    }
    for (;;)
    {
      this.a.put("type", paramk);
      return;
      paramk = "banner_ad";
      continue;
      paramk = "list_ad";
      continue;
      paramk = "listad_down";
      continue;
      paramk = "details_down";
    }
  }
  
  public void b(int paramInt)
  {
    this.a.put("posit", String.valueOf(paramInt));
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\b$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */