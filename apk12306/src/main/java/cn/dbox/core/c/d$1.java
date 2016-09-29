package cn.dbox.core.c;

import android.util.Log;
import cn.dbox.core.b.h;
import cn.dbox.core.bean.h;

class d$1
  implements c.a
{
  d$1(d paramd) {}
  
  public void a(c paramc)
  {
    String str = paramc.e();
    paramc = null;
    d.a().b("request ad response:" + str);
    if ((str != null) && (str.length() != 0))
    {
      paramc = new e().a(d.a(this.a), str);
      if (paramc == null) {
        break label191;
      }
      if (paramc.d() == null) {
        break label165;
      }
      str = paramc.d().b();
      int i = paramc.d().a();
      Log.e("error", String.format("Response contains error info. Error code is [%d-%s] and error content is [%s]", new Object[] { Integer.valueOf(i), paramc.a(), str }));
      if (d.b(this.a) != null) {
        d.b(this.a).a(this.a.a(i), str);
      }
    }
    for (;;)
    {
      return;
      d.a().e("Ad respStr is null.");
      break;
      label165:
      if (d.b(this.a) != null)
      {
        d.b(this.a).a(paramc);
        continue;
        label191:
        if (d.b(this.a) != null) {
          d.b(this.a).a(b.h.b, "");
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\c\d$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */