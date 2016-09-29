package cn.domob.wall.core.f;

import cn.domob.wall.core.DService.ReportDownLoadType;
import cn.domob.wall.core.bean.AdInfo;
import java.util.HashMap;

class b$d
  extends b.a
{
  b$d(b paramb, cn.domob.wall.core.b paramb1, AdInfo paramAdInfo)
  {
    super(paramb, paramb1, paramAdInfo, b.n.b);
    this.a.put("vc", String.valueOf(paramAdInfo.getAdVersionCode()));
    this.a.put("vn", String.valueOf(paramAdInfo.getAdVersionName()));
    this.a.put("pkg", paramAdInfo.getAdPackageName());
    this.a.put("id", paramAdInfo.getAdId());
  }
  
  void a(DService.ReportDownLoadType paramReportDownLoadType)
  {
    String str = "";
    switch (b.1.b[paramReportDownLoadType.ordinal()])
    {
    default: 
      paramReportDownLoadType = str;
    }
    for (;;)
    {
      this.a.put("type", paramReportDownLoadType);
      return;
      paramReportDownLoadType = "download_start";
      continue;
      paramReportDownLoadType = "download_repeat";
      continue;
      paramReportDownLoadType = "download_finish";
      continue;
      paramReportDownLoadType = "download_failed";
      continue;
      paramReportDownLoadType = "download_cancel";
      continue;
      paramReportDownLoadType = "install_success";
      continue;
      paramReportDownLoadType = "run";
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\f\b$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */