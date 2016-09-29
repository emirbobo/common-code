package cn.dbox.core.f;

import cn.dbox.core.b.n;
import cn.dbox.core.b.o;
import cn.dbox.core.c;
import java.util.HashMap;

class b$r
  extends b.c
{
  b$r(b paramb, c paramc)
  {
    super(paramb, paramc, b.n.f);
    this.b.put("sid", paramc.e());
  }
  
  public void a(b.o paramo)
  {
    String str = "";
    switch (b.1.i[paramo.ordinal()])
    {
    default: 
      paramo = str;
    }
    for (;;)
    {
      this.b.put("type", paramo);
      return;
      paramo = "setting_entry_clk";
      continue;
      paramo = "about_clk";
      continue;
      paramo = "feedback_submit";
      continue;
      paramo = "contact_clk";
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.b.put("message", paramString);
    }
  }
  
  public void c(String paramString)
  {
    if (paramString != null) {
      this.b.put("contact", paramString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */