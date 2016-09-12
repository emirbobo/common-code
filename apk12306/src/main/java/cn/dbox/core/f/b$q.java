package cn.dbox.core.f;

import android.text.TextUtils;
import cn.dbox.core.b.n;
import cn.dbox.core.c;
import cn.dbox.core.h.f;
import java.util.HashMap;

class b$q
  extends b.c
{
  b$q(b paramb, c paramc)
  {
    super(paramb, paramc, b.n.j);
    a(this.b, "-1");
  }
  
  void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.b.put("d_info", f.a("d!j@d#g$r%s^j&h*", paramString));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\f\b$q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */