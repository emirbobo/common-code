package cn.domob.wall.core.f;

import cn.domob.wall.core.DService.ReportUserActionType;
import java.util.HashMap;

class b$o
  extends b.a
{
  b$o(b paramb, cn.domob.wall.core.b paramb1)
  {
    super(paramb, paramb1, b.n.f);
    this.a.put("sid", paramb1.f());
    a(this.a, "-1");
  }
  
  void a(DService.ReportUserActionType paramReportUserActionType)
  {
    String str = "";
    switch (b.1.a[paramReportUserActionType.ordinal()])
    {
    default: 
      paramReportUserActionType = str;
    }
    for (;;)
    {
      this.a.put("type", paramReportUserActionType);
      return;
      paramReportUserActionType = "entry";
      continue;
      paramReportUserActionType = "exit";
      continue;
      paramReportUserActionType = "pgdn";
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\b$o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */