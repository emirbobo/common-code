package cn.dbox.ui.b;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.dbox.core.b.d;
import cn.dbox.core.bean.d;
import cn.dbox.ui.a.e;
import cn.dbox.ui.common.f;
import cn.dbox.ui.common.f.b;
import java.util.ArrayList;

public class c
  extends b
{
  private e a;
  
  public c(Context paramContext, d paramd, cn.dbox.core.b paramb, boolean paramBoolean)
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
    this.b.setFadingEdgeLength(0);
    this.b.setCacheColorHint(0);
    this.b.a(new f.b()
    {
      public void a()
      {
        if (!c.this.l)
        {
          c.this.o.setVisibility(0);
          if (!c.this.t)
          {
            c.this.t = true;
            c.this.a(c.a(c.this));
          }
        }
      }
    });
    this.s = paramd.l();
    this.a = new e(paramContext, this.s, paramb);
    if (this.o != null)
    {
      this.b.addFooterView(this.o);
      this.o.setVisibility(8);
    }
    this.b.setAdapter(this.a);
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if ((c.this.e != null) && (paramAnonymousInt < c.this.s.size()))
        {
          paramAnonymousAdapterView = (cn.dbox.core.bean.a)paramd.l().get(paramAnonymousInt);
          paramAnonymousAdapterView.a(paramAnonymousInt);
          c.this.e.a(paramAnonymousAdapterView, b.d.c, paramd.a(), paramd.c());
        }
      }
    });
    return this.b;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */