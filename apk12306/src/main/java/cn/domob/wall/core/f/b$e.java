package cn.domob.wall.core.f;

import cn.domob.wall.core.DService.EWallReportType;
import cn.domob.wall.core.bean.AdExtend;
import java.util.HashMap;

class b$e
  extends b.a
{
  b$e(b paramb, cn.domob.wall.core.b paramb1)
  {
    super(paramb, paramb1, b.n.h);
    this.a.put("sid", paramb1.f());
    if (paramb1.i() != null)
    {
      this.a.put("id", paramb1.i().getmId());
      a(this.a, paramb1.i().getmTr());
    }
  }
  
  void a(DService.EWallReportType paramEWallReportType)
  {
    String str = "";
    switch (b.1.f[paramEWallReportType.ordinal()])
    {
    default: 
      paramEWallReportType = str;
    }
    for (;;)
    {
      this.a.put("type", paramEWallReportType);
      return;
      paramEWallReportType = "e_entry_show";
      continue;
      paramEWallReportType = "e_entry_click";
      continue;
      paramEWallReportType = "e_page_req";
      continue;
      paramEWallReportType = "e_page_show";
      continue;
      paramEWallReportType = "e_page_click";
    }
  }
  
  public void a(String paramString)
  {
    if (paramString != null) {
      this.a.put("e_page_url", paramString);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\b$e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */