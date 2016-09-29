package cn.dbox.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cn.dbox.core.b.b;
import cn.dbox.core.bean.d;
import cn.dbox.core.bean.d.a;
import java.util.ArrayList;

class a$4$2
  implements DialogInterface.OnDismissListener
{
  a$4$2(a.4 param4) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    int j = a.d(this.a.b).a();
    paramDialogInterface = new ArrayList();
    for (int i = 0; (i < j) && (i < this.a.a.l().size()); i++)
    {
      ((cn.dbox.core.bean.a)this.a.a.l().get(i)).a(i);
      paramDialogInterface.add(this.a.a.l().get(i));
    }
    j = a.d(this.a.b).b();
    for (i = 0; (i < j) && (i < this.a.a.k().c().size()); i++)
    {
      ((cn.dbox.core.bean.a)this.a.a.k().c().get(i)).a(0);
      paramDialogInterface.add(this.a.a.k().c().get(i));
    }
    this.a.b.a(paramDialogInterface, this.a.a.c());
    if (this.a.a.j().equals("web")) {
      this.a.b.d.a(this.a.a, b.b.e);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a$4$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */