package cn.dbox.ui.b;

import android.os.Handler;
import cn.dbox.core.b.h;
import cn.dbox.core.b.m;
import cn.dbox.core.bean.a;
import cn.dbox.core.bean.c;
import cn.dbox.core.bean.g;
import cn.dbox.ui.common.f;
import java.util.ArrayList;
import java.util.Iterator;

class b$3
  implements b.m
{
  b$3(b paramb) {}
  
  public void a(b.h paramh, String paramString1, String paramString2, int paramInt)
  {
    this.a.l = true;
    if (this.a.b != null)
    {
      if (this.a.b.getFirstVisiblePosition() <= 1) {
        break label60;
      }
      this.a.d();
    }
    for (;;)
    {
      this.a.w.sendEmptyMessage(0);
      this.a.t = false;
      return;
      label60:
      this.a.e();
    }
  }
  
  public void a(g paramg, ArrayList<c> paramArrayList, ArrayList<a> paramArrayList1, String paramString, int paramInt)
  {
    paramArrayList = paramArrayList1.iterator();
    while (paramArrayList.hasNext())
    {
      paramg = (a)paramArrayList.next();
      this.a.s.add(paramg);
    }
    this.a.w.sendEmptyMessage(0);
    this.a.t = false;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\b$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */