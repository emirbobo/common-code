package cn.dbox.ui;

import cn.dbox.core.b.h;
import cn.dbox.core.b.l;
import cn.dbox.core.bean.a;
import cn.dbox.core.bean.c;
import cn.dbox.core.bean.g;
import cn.dbox.core.bean.g.a;
import java.util.ArrayList;
import java.util.Iterator;

class DBoxManager$4
  implements b.l
{
  DBoxManager$4(DBoxManager paramDBoxManager) {}
  
  public void a(b.h paramh, String paramString1, String paramString2, int paramInt)
  {
    if (DBoxManager.c(this.a) != null) {
      DBoxManager.f(this.a);
    }
    if (DBoxManager.a(this.a) != null) {
      DBoxManager.a(this.a).onFailReceiveData("errorCode:" + paramh + ",errorContent" + paramString1);
    }
  }
  
  public void a(g paramg, ArrayList<c> paramArrayList, ArrayList<a> paramArrayList1, String paramString, int paramInt)
  {
    DBoxManager.a(this.a, paramArrayList);
    DBoxManager.b(this.a, paramArrayList1);
    if (paramg != null)
    {
      DBoxManager.a(this.a, paramg.a());
      paramg = paramg.b();
      if (paramg != null) {
        DBoxManager.b(this.a, paramg.a());
      }
    }
    paramg = paramArrayList.iterator();
    if (paramg.hasNext())
    {
      paramArrayList = (c)paramg.next();
      DBoxManager.a().b("Channel:id:" + paramArrayList.a() + "name:" + paramArrayList.b());
      paramArrayList = paramArrayList.d().iterator();
      while (paramArrayList.hasNext())
      {
        paramArrayList1 = (cn.dbox.core.bean.d)paramArrayList.next();
        DBoxManager.a().b("ContainerInfo:" + paramArrayList1.toString());
        paramArrayList1 = paramArrayList1.l().iterator();
        while (paramArrayList1.hasNext())
        {
          paramString = (a)paramArrayList1.next();
          DBoxManager.a().b("AdInfo:" + paramString.toString());
        }
      }
    }
    if (DBoxManager.c(this.a) != null) {
      DBoxManager.d(this.a);
    }
    if (DBoxManager.a(this.a) != null) {
      DBoxManager.a(this.a).onSuccessReceiveData(DBoxManager.e(this.a));
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\DBoxManager$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */