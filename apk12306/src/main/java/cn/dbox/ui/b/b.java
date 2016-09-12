package cn.dbox.ui.b;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.dbox.core.b.h;
import cn.dbox.core.b.m;
import cn.dbox.core.bean.d.a;
import cn.dbox.core.bean.g;
import cn.dbox.ui.common.f;
import java.util.ArrayList;
import java.util.Iterator;

public class b
  extends LinearLayout
{
  public static final int m = -789000;
  private final int a = 0;
  public f b;
  public cn.dbox.ui.card.c c;
  public cn.dbox.ui.common.c d;
  public cn.dbox.ui.d.a e;
  public Context f;
  public cn.dbox.core.bean.d g;
  public cn.dbox.ui.common.b h;
  public cn.dbox.ui.common.d i;
  public cn.dbox.core.b j;
  public LinearLayout.LayoutParams k;
  public boolean l = false;
  int n = 0;
  public View o;
  public TextView p;
  public final String q = "点击返回顶部";
  public final String r = "正在加载更多";
  public ArrayList<cn.dbox.core.bean.a> s;
  public boolean t = false;
  public int u = 0;
  public BaseAdapter v;
  Handler w = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      b.this.v.notifyDataSetChanged();
    }
  };
  
  public b(Context paramContext, cn.dbox.core.bean.d paramd, cn.dbox.core.b paramb, boolean paramBoolean)
  {
    super(paramContext);
    this.j = paramb;
    this.f = paramContext;
    this.g = paramd;
    this.k = new LinearLayout.LayoutParams(-1, -1);
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    setOrientation(1);
    setBackgroundColor(-789000);
    if (paramBoolean) {
      this.d = new cn.dbox.ui.common.c(paramContext, paramd.d());
    }
    this.i = new cn.dbox.ui.common.d(paramContext);
    d.a locala = paramd.k();
    if ((locala != null) && (locala.c().size() > 0))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      this.h = new cn.dbox.ui.common.b(paramContext, locala, paramb, paramd.a(), paramd.c());
      this.h.setLayoutParams(localLayoutParams);
    }
    c();
  }
  
  public int a()
  {
    int i1;
    if (this.b != null) {
      if (this.n != 0) {
        i1 = this.n;
      }
    }
    for (;;)
    {
      return i1;
      i1 = this.b.b();
      continue;
      if (this.c != null) {
        i1 = this.c.getGridViewLastVisiblePosition();
      } else {
        i1 = 0;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
  }
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    this.v = paramBaseAdapter;
    this.j.a(new b.m()
    {
      public void a(b.h paramAnonymoush, String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt)
      {
        b.this.l = true;
        if (b.this.b != null)
        {
          if (b.this.b.getFirstVisiblePosition() <= 1) {
            break label60;
          }
          b.this.d();
        }
        for (;;)
        {
          b.this.w.sendEmptyMessage(0);
          b.this.t = false;
          return;
          label60:
          b.this.e();
        }
      }
      
      public void a(g paramAnonymousg, ArrayList<cn.dbox.core.bean.c> paramAnonymousArrayList, ArrayList<cn.dbox.core.bean.a> paramAnonymousArrayList1, String paramAnonymousString, int paramAnonymousInt)
      {
        paramAnonymousArrayList = paramAnonymousArrayList1.iterator();
        while (paramAnonymousArrayList.hasNext())
        {
          paramAnonymousg = (cn.dbox.core.bean.a)paramAnonymousArrayList.next();
          b.this.s.add(paramAnonymousg);
        }
        b.this.w.sendEmptyMessage(0);
        b.this.t = false;
      }
    });
    cn.dbox.core.b localb = this.j;
    paramBaseAdapter = this.g.c();
    int i1 = this.u + 1;
    this.u = i1;
    localb.a(paramBaseAdapter, i1);
  }
  
  public void a(cn.dbox.ui.d.a parama)
  {
    this.e = parama;
    if (this.h != null) {
      this.h.a(this.e);
    }
  }
  
  public void a(cn.dbox.ui.d.c paramc)
  {
    if (this.d != null) {
      this.d.a(paramc);
    }
  }
  
  public int b()
  {
    if (this.h != null) {}
    for (int i1 = this.h.a();; i1 = 0) {
      return i1;
    }
  }
  
  public void c()
  {
    this.o = LayoutInflater.from(this.f).inflate(cn.dbox.ui.e.d.a(this.f, "dbox_list_footer"), null);
    this.p = ((TextView)this.o.findViewById(cn.dbox.ui.e.c.a(this.f, "more_textview")));
    this.p.setText("正在加载更多");
  }
  
  public void d()
  {
    ((Activity)this.f).runOnUiThread(new Runnable()
    {
      public void run()
      {
        b.this.p.setText("点击返回顶部");
        b.this.o.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            b.this.b.setSelection(0);
          }
        });
      }
    });
  }
  
  public void e()
  {
    ((Activity)this.f).runOnUiThread(new Runnable()
    {
      public void run()
      {
        b.this.o.setVisibility(8);
      }
    });
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */