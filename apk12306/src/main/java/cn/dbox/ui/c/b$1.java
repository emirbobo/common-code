package cn.dbox.ui.c;

import android.view.View;
import cn.dbox.core.b.e;
import cn.dbox.core.bean.d;
import cn.dbox.ui.common.g;
import java.util.ArrayList;

class b$1
  implements a.a
{
  b$1(b paramb, ArrayList paramArrayList) {}
  
  public void a(int paramInt, View paramView, Object paramObject)
  {
    if (b.a(this.b) != null)
    {
      this.b.o = true;
      if ((this.b.o) && (this.b.g != null)) {
        this.b.g.a((d)this.a.get(paramInt), b.e.c);
      }
      b.a(this.b).setCurrentItem(paramInt, false);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\c\b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */