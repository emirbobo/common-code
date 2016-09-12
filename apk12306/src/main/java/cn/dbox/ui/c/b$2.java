package cn.dbox.ui.c;

import cn.dbox.core.b.e;
import cn.dbox.core.bean.d;
import cn.dbox.ui.common.k;
import cn.dbox.ui.d.d.a;
import java.util.ArrayList;

class b$2
  implements d.a
{
  b$2(b paramb, ArrayList paramArrayList) {}
  
  public void a(int paramInt)
  {
    if (b.b(this.b) != null)
    {
      int j = b.b(this.b).a();
      String str = ((d)b.c(this.b).get(j)).d();
      int i = ((cn.dbox.ui.b.b)b.d(this.b).get(j)).a();
      j = ((cn.dbox.ui.b.b)b.d(this.b).get(j)).b();
      this.b.a(str, i);
      this.b.b(str, j);
      this.b.n = paramInt;
      b.b(this.b).b(paramInt);
      if (paramInt % 2 == 0) {
        b.b(this.b).scrollTo((paramInt - 2) * k.a(this.b.k, 90), 0);
      }
      if ((!this.b.o) && (this.b.g != null)) {
        this.b.g.a((d)this.a.get(paramInt), b.e.b);
      }
      this.b.o = false;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\c\b$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */