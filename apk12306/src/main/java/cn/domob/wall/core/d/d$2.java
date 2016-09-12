package cn.domob.wall.core.d;

import android.app.Activity;
import android.app.Dialog;
import cn.domob.wall.core.DService.EWallReportType;

class d$2
  implements a.a
{
  d$2(d paramd, cn.domob.wall.core.b paramb) {}
  
  public void a(a parama, String paramString)
  {
    d.a().b("EWallView onURLIntercepted URL:" + paramString);
    try
    {
      parama = (Activity)d.c(this.b);
      Runnable local1 = new cn/domob/wall/core/d/d$2$1;
      local1.<init>(this, paramString);
      parama.runOnUiThread(local1);
      cn.domob.wall.core.f.a.a().a(this.a, DService.EWallReportType.E_PAGE_CLICK, paramString);
      return;
    }
    catch (Exception parama)
    {
      for (;;)
      {
        d.a().a(parama);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\d$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */