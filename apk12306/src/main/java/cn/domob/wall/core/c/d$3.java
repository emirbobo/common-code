package cn.domob.wall.core.c;

import android.util.Log;
import cn.domob.wall.core.DService.ErrorCode;
import cn.domob.wall.core.bean.a;

class d$3
  implements c.a
{
  d$3(d paramd) {}
  
  public void a(c paramc)
  {
    String str = paramc.e();
    paramc = null;
    d.a().b("request ad response:" + str);
    if ((str != null) && (str.length() != 0))
    {
      paramc = new g().a(d.a(this.a), str);
      if (paramc == null) {
        break label191;
      }
      if (paramc.b() == null) {
        break label165;
      }
      str = paramc.b().b();
      int i = paramc.b().a();
      Log.e("error", String.format("Response contains error info. Error code is [%d-%s] and error content is [%s]", new Object[] { Integer.valueOf(i), paramc.a(), str }));
      if (d.d(this.a) != null) {
        d.d(this.a).a(this.a.a(i), str);
      }
    }
    for (;;)
    {
      return;
      d.a().e("Ad respStr is null.");
      break;
      label165:
      if (d.d(this.a) != null)
      {
        d.d(this.a).a(paramc);
        continue;
        label191:
        if (d.d(this.a) != null) {
          d.d(this.a).a(DService.ErrorCode.INTERNAL_ERROR, "");
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\c\d$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */