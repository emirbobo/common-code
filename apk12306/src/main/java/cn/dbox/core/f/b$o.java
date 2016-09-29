package cn.dbox.core.f;

import cn.dbox.core.b.i;
import cn.dbox.core.b.n;
import cn.dbox.core.bean.a;
import cn.dbox.core.c;
import java.util.HashMap;

class b$o
  extends b.c
{
  b$o(b paramb, c paramc, a parama)
  {
    super(paramb, paramc, parama, b.n.i);
    this.b.put("sid", paramc.e());
  }
  
  public void a(b.i parami)
  {
    String str = "";
    switch (b.1.h[parami.ordinal()])
    {
    default: 
      parami = str;
    }
    for (;;)
    {
      this.b.put("type", parami);
      return;
      parami = "la_success";
      continue;
      parami = "la_failed";
      continue;
      parami = "la_failsafe_success";
      continue;
      parami = "la_failsafe_failed";
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.b.put("failsafe", paramString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */