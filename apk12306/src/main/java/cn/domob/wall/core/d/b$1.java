package cn.domob.wall.core.d;

import cn.domob.wall.core.DService.EWallReportType;
import cn.domob.wall.core.h.d;

class b$1
  implements a.a
{
  b$1(b paramb, cn.domob.wall.core.b paramb1) {}
  
  public void a(a parama, String paramString)
  {
    b.b().b("EWallDetailsView onURLIntercepted URL:" + paramString);
    parama.loadUrl(paramString);
    cn.domob.wall.core.f.a.a().a(this.a, DService.EWallReportType.E_PAGE_CLICK, paramString);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */