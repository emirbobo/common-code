package cn.dbox.core.f;

import cn.dbox.core.b.b;
import cn.dbox.core.b.n;
import cn.dbox.core.bean.a;
import cn.dbox.core.c;
import java.util.HashMap;

class b$d
  extends b.c
{
  b$d(b paramb, c paramc, a parama)
  {
    super(paramb, paramc, parama, b.n.e);
    this.b.put("sid", paramc.e());
    this.b.put("type", "landing");
  }
  
  public void a(b.b paramb)
  {
    String str = "";
    switch (b.1.e[paramb.ordinal()])
    {
    default: 
      paramb = str;
    }
    for (;;)
    {
      this.b.put("phase", paramb);
      return;
      paramb = "load_success";
      continue;
      paramb = "load_failed";
      continue;
      paramb = "load_cancel";
      continue;
      paramb = "close_lp";
      continue;
      paramb = "lp_url";
    }
  }
  
  public void a(String paramString)
  {
    this.b.put("data", paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */