package cn.dbox.core.f;

import cn.dbox.core.b.e;
import cn.dbox.core.b.f;
import cn.dbox.core.b.n;
import cn.dbox.core.c;
import java.util.HashMap;

class b$i
  extends b.c
{
  b$i(b paramb, c paramc)
  {
    super(paramb, paramc, b.n.d);
    this.b.put("sid", paramc.e());
    a(this.b, "-1");
  }
  
  void a(b.e parame)
  {
    String str = "";
    switch (b.1.d[parame.ordinal()])
    {
    default: 
      parame = str;
    }
    for (;;)
    {
      this.b.put("action", parame);
      return;
      parame = "slide";
      continue;
      parame = "click";
    }
  }
  
  void a(b.f paramf)
  {
    String str = "";
    switch (b.1.c[paramf.ordinal()])
    {
    default: 
      paramf = str;
    }
    for (;;)
    {
      this.b.put("type", paramf);
      return;
      paramf = "container_entry_clk";
      continue;
      paramf = "landing";
    }
  }
  
  void a(String paramString)
  {
    this.b.put("chanid", paramString);
  }
  
  void c(String paramString)
  {
    this.b.put("acid", paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */