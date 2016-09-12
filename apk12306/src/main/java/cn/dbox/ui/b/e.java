package cn.dbox.ui.b;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.dbox.core.b.d;
import cn.dbox.core.bean.d;
import cn.dbox.ui.common.f.b;
import java.util.ArrayList;

public class e
  extends b
{
  private cn.dbox.ui.a.f a;
  
  public e(Context paramContext, d paramd, cn.dbox.core.b paramb, boolean paramBoolean)
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
  
  public cn.dbox.ui.common.f a(Context paramContext, final d paramd, cn.dbox.core.b paramb)
  {
    this.b = new cn.dbox.ui.common.f(paramContext);
    this.b.setFadingEdgeLength(0);
    this.b.setCacheColorHint(0);
    this.b.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if ((e.this.e != null) && (paramAnonymousInt < e.this.s.size()))
        {
          paramAnonymousAdapterView = (cn.dbox.core.bean.a)paramd.l().get(paramAnonymousInt);
          paramAnonymousAdapterView.a(paramAnonymousInt);
          e.this.e.a(paramAnonymousAdapterView, b.d.c, paramd.a(), paramd.c());
        }
      }
    });
    this.b.a(new f.b()
    {
      public void a()
      {
        if (!e.this.l)
        {
          e.this.o.setVisibility(0);
          if (!e.this.t)
          {
            e.this.t = true;
            e.this.a(e.a(e.this));
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
    this.a = new cn.dbox.ui.a.f(paramContext, this.s, paramb);
    this.b.setAdapter(this.a);
    return this.b;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */