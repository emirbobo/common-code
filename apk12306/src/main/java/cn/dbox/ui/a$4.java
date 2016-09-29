package cn.dbox.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import cn.dbox.core.b.b;
import cn.dbox.core.bean.d;
import cn.dbox.core.bean.d.a;
import cn.dbox.ui.b.c;
import cn.dbox.ui.b.e;
import cn.dbox.ui.b.g;
import cn.dbox.ui.b.g.a;
import java.util.ArrayList;

class a$4
  implements Runnable
{
  a$4(a parama, d paramd) {}
  
  public void run()
  {
    if (this.a.j().equals("card")) {
      a.a(this.b, new cn.dbox.ui.b.a(this.b.k, this.a, this.b.d, true));
    }
    for (;;)
    {
      a.d(this.b).a(a.e(this.b));
      a.d(this.b).a(a.f(this.b));
      a.c(this.b).setContentView(a.d(this.b));
      a.c(this.b).setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          int j = a.d(a.4.this.b).a();
          paramAnonymousDialogInterface = new ArrayList();
          for (int i = 0; (i < j) && (i < a.4.this.a.l().size()); i++)
          {
            ((cn.dbox.core.bean.a)a.4.this.a.l().get(i)).a(i);
            paramAnonymousDialogInterface.add(a.4.this.a.l().get(i));
          }
          j = a.d(a.4.this.b).b();
          for (i = 0; (i < j) && (i < a.4.this.a.k().c().size()); i++)
          {
            ((cn.dbox.core.bean.a)a.4.this.a.k().c().get(i)).a(0);
            paramAnonymousDialogInterface.add(a.4.this.a.k().c().get(i));
          }
          a.4.this.b.a(paramAnonymousDialogInterface, a.4.this.a.c());
          if (a.4.this.a.j().equals("web")) {
            a.4.this.b.d.a(a.4.this.a, b.b.e);
          }
        }
      });
      a.c(this.b).show();
      return;
      if (this.a.j().equals("feeds"))
      {
        a.a(this.b, new c(this.b.k, this.a, this.b.d, true));
      }
      else if (this.a.j().equals("list"))
      {
        a.a(this.b, new e(this.b.k, this.a, this.b.d, true));
      }
      else if (this.a.j().equals("web"))
      {
        a.a(this.b, new g(this.b.k, this.a, this.b.d, true));
        ((g)a.d(this.b)).a(new g.a()
        {
          public void a()
          {
            if ((a.c(a.4.this.b) != null) && (a.c(a.4.this.b).isShowing())) {
              a.c(a.4.this.b).dismiss();
            }
          }
        });
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */