package cn.dbox.ui.b;

import android.content.Context;
import android.view.View;
import cn.dbox.core.b.d;
import cn.dbox.core.bean.d;
import cn.dbox.ui.a.g.a;
import cn.dbox.ui.common.f;
import cn.dbox.ui.common.f.b;
import java.util.ArrayList;

public class a
  extends b
{
  cn.dbox.ui.a.a a;
  
  public a(Context paramContext, d paramd, cn.dbox.core.b paramb, boolean paramBoolean)
  {
    super(paramContext, paramd, paramb, paramBoolean);
    setLayoutParams(this.k);
    setBackgroundColor(-789000);
    if (this.d != null) {
      addView(this.d);
    }
    if (this.h != null) {
      addView(this.h);
    }
    if ((this.h == null) && (paramd.l().size() == 0)) {
      if (this.i != null) {
        addView(this.i);
      }
    }
    for (;;)
    {
      return;
      a(paramContext, paramd, paramb);
      addView(this.b);
    }
  }
  
  public f a(Context paramContext, final d paramd, cn.dbox.core.b paramb)
  {
    this.b = new f(paramContext);
    this.b.setBackgroundColor(-789000);
    this.b.setCacheColorHint(0);
    this.b.setSelector(cn.dbox.ui.e.b.a(paramContext, "dbox_item_selector"));
    this.b.a(new f.b()
    {
      public void a()
      {
        if (!a.this.l)
        {
          a.this.o.setVisibility(0);
          if (!a.this.t)
          {
            a.this.t = true;
            a.this.a(a.this.a);
          }
        }
      }
    });
    if (this.o != null)
    {
      this.b.addFooterView(this.o);
      this.o.setVisibility(8);
    }
    this.s = paramd.l();
    this.a = new cn.dbox.ui.a.a(paramContext, this.s, paramb);
    this.a.a(new g.a()
    {
      public void a(View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (a.this.e != null)
        {
          if (paramAnonymousInt >= a.this.s.size()) {
            break label75;
          }
          paramAnonymousView = (cn.dbox.core.bean.a)paramd.l().get(paramAnonymousInt);
          paramAnonymousView.a(paramAnonymousInt);
          a.this.e.a(paramAnonymousView, b.d.c, paramd.a(), paramd.c());
        }
        for (;;)
        {
          return;
          label75:
          paramAnonymousView.setBackgroundColor(-789000);
        }
      }
    });
    if (this.s != null) {
      a(this.s.size());
    }
    this.b.setAdapter(this.a);
    return this.b;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */