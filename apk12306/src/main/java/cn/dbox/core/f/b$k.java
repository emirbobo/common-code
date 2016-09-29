package cn.dbox.core.f;

import cn.dbox.core.b.n;
import cn.dbox.core.bean.Entrance.EntryReportType;
import cn.dbox.core.c;
import java.util.HashMap;

class b$k
  extends b.c
{
  b$k(b paramb, c paramc)
  {
    super(paramb, paramc, b.n.b);
    this.b.put("sid", paramc.e());
    if ((paramc.k() == null) || (paramc.k().equals(""))) {
      a(this.b, "-1");
    }
    for (;;)
    {
      return;
      a(this.b, paramc.k());
    }
  }
  
  void a(Entrance.EntryReportType paramEntryReportType)
  {
    String str = "";
    switch (b.1.a[paramEntryReportType.ordinal()])
    {
    default: 
      paramEntryReportType = str;
    }
    for (;;)
    {
      this.b.put("type", paramEntryReportType);
      return;
      paramEntryReportType = "entry_imp";
      continue;
      paramEntryReportType = "entry_clk";
      continue;
      paramEntryReportType = "presented";
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */