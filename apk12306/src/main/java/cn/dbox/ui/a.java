package cn.dbox.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import cn.dbox.core.b.a;
import cn.dbox.core.b.b;
import cn.dbox.core.b.d;
import cn.dbox.core.b.e;
import cn.dbox.core.b.f;
import cn.dbox.core.b.o;
import cn.dbox.core.bean.d.a;
import cn.dbox.ui.b.e;
import cn.dbox.ui.b.g.a;
import cn.dbox.ui.common.h;
import cn.dbox.ui.common.i;
import cn.dbox.ui.common.j;
import cn.dbox.ui.d.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class a
  extends h
{
  private static cn.dbox.core.h.d n = new cn.dbox.core.h.d(a.class.getSimpleName());
  private LinearLayout.LayoutParams o = new LinearLayout.LayoutParams(-1, -1);
  private cn.dbox.ui.card.b p;
  private cn.dbox.ui.c.b q;
  private j r;
  private cn.dbox.ui.b.b s = null;
  private Dialog t;
  private Dialog u;
  private cn.dbox.ui.d.c v = new cn.dbox.ui.d.c()
  {
    public void a()
    {
      a.this.b();
    }
    
    public void b()
    {
      if (a.c(a.this) != null) {
        a.c(a.this).dismiss();
      }
    }
  };
  private cn.dbox.ui.d.a w = new cn.dbox.ui.d.a()
  {
    public void a(cn.dbox.core.bean.a paramAnonymousa, b.d paramAnonymousd, String paramAnonymousString1, String paramAnonymousString2)
    {
      a.this.d.a(paramAnonymousa);
      paramAnonymousa.b(paramAnonymousString1);
      paramAnonymousa.c(paramAnonymousString2);
      a.a(a.this, paramAnonymousa, b.a.c, paramAnonymousd);
    }
  };
  private cn.dbox.ui.d.g x = new cn.dbox.ui.d.g()
  {
    public void a()
    {
      a.e().b("onClickBack");
      if (a.g(a.this) != null) {
        a.g(a.this).dismiss();
      }
    }
    
    public void a(String paramAnonymousString1, String paramAnonymousString2)
    {
      a.e().b("onClickSendMessage:message:" + paramAnonymousString1 + "tel:" + paramAnonymousString2);
      if ((paramAnonymousString1 == null) || (paramAnonymousString1.equals("")) || (paramAnonymousString1.length() > 500) || (paramAnonymousString2.length() > 100)) {
        Toast.makeText(a.this.k, "留言为空或留言太多或联系方式太多", 1).show();
      }
      for (;;)
      {
        return;
        Toast.makeText(a.this.k, "发送成功", 1).show();
        a.a(a.this, b.o.d, paramAnonymousString1, paramAnonymousString2);
      }
    }
    
    public void b()
    {
      a.a(a.this, b.o.c, null, null);
    }
    
    public void c()
    {
      Intent localIntent = new Intent("android.intent.action.SENDTO");
      localIntent.setData(Uri.parse("mailto:duobaowu@163.com"));
      a.this.k.startActivity(localIntent);
      a.a(a.this, b.o.e, null, null);
    }
  };
  private f y;
  
  public a(Context paramContext)
  {
    super(paramContext);
    addView(this.e);
    addView(this.i, this.o);
    this.t = new Dialog(this.k, 16973840);
  }
  
  private void a(b.f paramf, cn.dbox.core.bean.d paramd, b.e parame)
  {
    this.d.a(paramf, paramd, parame);
  }
  
  private void a(b.o paramo, String paramString1, String paramString2)
  {
    if (this.d != null) {
      this.d.a(paramo, paramString1, paramString2);
    }
  }
  
  private void a(cn.dbox.core.bean.a parama, b.a parama1, b.d paramd)
  {
    this.d.a(parama, parama1, paramd);
  }
  
  private void a(final cn.dbox.core.bean.d paramd)
  {
    this.u = new Dialog(this.k, 16973840);
    ((Activity)this.k).runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (paramd.j().equals("card")) {
          a.a(a.this, new cn.dbox.ui.b.a(a.this.k, paramd, a.this.d, true));
        }
        for (;;)
        {
          a.d(a.this).a(a.e(a.this));
          a.d(a.this).a(a.f(a.this));
          a.c(a.this).setContentView(a.d(a.this));
          a.c(a.this).setOnDismissListener(new DialogInterface.OnDismissListener()
          {
            public void onDismiss(DialogInterface paramAnonymous2DialogInterface)
            {
              int j = a.d(a.this).a();
              paramAnonymous2DialogInterface = new ArrayList();
              for (int i = 0; (i < j) && (i < a.4.this.a.l().size()); i++)
              {
                ((cn.dbox.core.bean.a)a.4.this.a.l().get(i)).a(i);
                paramAnonymous2DialogInterface.add(a.4.this.a.l().get(i));
              }
              j = a.d(a.this).b();
              for (i = 0; (i < j) && (i < a.4.this.a.k().c().size()); i++)
              {
                ((cn.dbox.core.bean.a)a.4.this.a.k().c().get(i)).a(0);
                paramAnonymous2DialogInterface.add(a.4.this.a.k().c().get(i));
              }
              a.this.a(paramAnonymous2DialogInterface, a.4.this.a.c());
              if (a.4.this.a.j().equals("web")) {
                a.this.d.a(a.4.this.a, b.b.e);
              }
            }
          });
          a.c(a.this).show();
          return;
          if (paramd.j().equals("feeds"))
          {
            a.a(a.this, new cn.dbox.ui.b.c(a.this.k, paramd, a.this.d, true));
          }
          else if (paramd.j().equals("list"))
          {
            a.a(a.this, new e(a.this.k, paramd, a.this.d, true));
          }
          else if (paramd.j().equals("web"))
          {
            a.a(a.this, new cn.dbox.ui.b.g(a.this.k, paramd, a.this.d, true));
            ((cn.dbox.ui.b.g)a.d(a.this)).a(new g.a()
            {
              public void a()
              {
                if ((a.c(a.this) != null) && (a.c(a.this).isShowing())) {
                  a.c(a.this).dismiss();
                }
              }
            });
          }
        }
      }
    });
  }
  
  public void a()
  {
    if (this.i != null) {
      removeView(this.i);
    }
    this.j.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        a.e().b("refresh view");
        if (a.this.j != null) {
          a.this.removeView(a.this.j);
        }
        a.this.addView(a.this.i, a.a(a.this));
        if (a.b(a.this) != null) {
          a.b(a.this).a();
        }
      }
    });
    addView(this.j, this.o);
  }
  
  public void a(Context paramContext, String paramString, ArrayList<cn.dbox.core.bean.c> paramArrayList, ArrayList<cn.dbox.core.bean.a> paramArrayList1, cn.dbox.core.b paramb)
  {
    a(paramContext, paramArrayList, paramArrayList1, paramb);
    if (this.i != null) {
      removeView(this.i);
    }
    if (this.b.size() == 0) {
      if (this.l != null) {
        addView(this.l);
      }
    }
    for (;;)
    {
      return;
      if (paramString.equals("card"))
      {
        this.p = new cn.dbox.ui.card.b(this.k, this.b, this.c, this.d);
        addView(this.p, this.o);
        this.p.a(new cn.dbox.ui.d.b()
        {
          public void a(cn.dbox.core.bean.d paramAnonymousd, b.e paramAnonymouse)
          {
            a.a(a.this, paramAnonymousd);
            a.a(a.this, b.f.b, paramAnonymousd, b.e.c);
          }
        });
      }
      else if (paramString.equals("flat"))
      {
        this.q = new cn.dbox.ui.c.b(this.k, this.b, this.c, this.d);
        addView(this.q, this.o);
        this.q.a(new cn.dbox.ui.d.b()
        {
          public void a(cn.dbox.core.bean.d paramAnonymousd, b.e paramAnonymouse)
          {
            a.a(a.this, b.f.b, paramAnonymousd, paramAnonymouse);
          }
        });
        this.q.a(this.w);
      }
    }
  }
  
  public void a(f paramf)
  {
    this.y = paramf;
  }
  
  public void a(ArrayList<cn.dbox.core.bean.a> paramArrayList, String paramString)
  {
    this.d.a(paramArrayList, paramString);
  }
  
  public void a(HashMap<String, Integer> paramHashMap)
  {
    HashMap localHashMap = this.q.b();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = (Map.Entry)paramHashMap.next();
      Object localObject2 = ((Map.Entry)localObject1).getKey();
      int j = ((Integer)((Map.Entry)localObject1).getValue()).intValue();
      n.b(localObject2 + ":container:show:" + j + "ad");
      if (j != 0)
      {
        localObject1 = (cn.dbox.core.bean.d)localHashMap.get(localObject2);
        localObject2 = ((cn.dbox.core.bean.d)localObject1).l();
        for (int i = 0; (i <= j) && (i < ((ArrayList)localObject2).size()); i++)
        {
          ((cn.dbox.core.bean.a)((ArrayList)localObject2).get(i)).a(i);
          localArrayList.add(((ArrayList)localObject2).get(i));
        }
        this.d.a(localArrayList, ((cn.dbox.core.bean.d)localObject1).c());
      }
    }
  }
  
  public void b()
  {
    a(b.o.b, null, null);
    this.r = new j(this.k);
    this.r.a(this.x);
    this.t.setContentView(this.r);
    this.t.show();
  }
  
  public void b(HashMap<String, Integer> paramHashMap)
  {
    HashMap localHashMap = this.q.b();
    paramHashMap = paramHashMap.entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = (Map.Entry)paramHashMap.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      int j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
      n.b(localObject1 + ":container:show:" + j + "ad");
      if (j != 0)
      {
        localObject2 = (cn.dbox.core.bean.d)localHashMap.get(localObject1);
        localObject1 = ((cn.dbox.core.bean.d)localObject2).k().c();
        for (int i = 0; (i < j) && (i < ((ArrayList)localObject1).size()); i++) {
          localArrayList.add(((ArrayList)localObject1).get(i));
        }
        this.d.a(localArrayList, ((cn.dbox.core.bean.d)localObject2).c());
      }
    }
  }
  
  public void c()
  {
    if (this.q != null)
    {
      HashMap localHashMap1 = this.q.c();
      HashMap localHashMap2 = this.q.d();
      a(localHashMap1);
      b(localHashMap2);
    }
  }
  
  public void d()
  {
    if (this.e != null) {
      this.e.setVisibility(8);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */