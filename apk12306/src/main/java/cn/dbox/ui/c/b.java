package cn.dbox.ui.c;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import cn.dbox.core.b.e;
import cn.dbox.ui.b.e;
import cn.dbox.ui.common.h;
import cn.dbox.ui.common.k;
import cn.dbox.ui.d.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class b
  extends h
{
  public int n = 0;
  boolean o = false;
  public HashMap<String, cn.dbox.core.bean.d> p = new HashMap();
  public cn.dbox.ui.d.a q;
  private a r;
  private cn.dbox.ui.common.g s;
  private ArrayList<cn.dbox.core.bean.d> t;
  private ArrayList<cn.dbox.ui.b.b> u = new ArrayList();
  private HashMap<String, Integer> v = new HashMap();
  private HashMap<String, Integer> w = new HashMap();
  
  public b(Context paramContext, ArrayList<cn.dbox.core.bean.c> paramArrayList, ArrayList<cn.dbox.core.bean.a> paramArrayList1, cn.dbox.core.b paramb)
  {
    super(paramContext, paramArrayList, paramArrayList1, paramb);
    setLayoutParams(this.m);
    setBackgroundColor(-789000);
    this.t = k.a(paramArrayList);
    a(paramContext, this.t, paramArrayList1);
  }
  
  public ArrayList<cn.dbox.core.bean.d> a()
  {
    return this.t;
  }
  
  public ArrayList<cn.dbox.ui.b.b> a(Context paramContext, ArrayList<cn.dbox.core.bean.d> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = null;
    int i = 0;
    if (i < paramArrayList.size()) {
      if (((cn.dbox.core.bean.d)paramArrayList.get(i)).j().equals("web")) {
        localObject = new cn.dbox.ui.b.g(paramContext, (cn.dbox.core.bean.d)paramArrayList.get(i), this.d, false);
      }
    }
    for (;;)
    {
      localArrayList.add(localObject);
      i++;
      break;
      if (((cn.dbox.core.bean.d)paramArrayList.get(i)).j().equals("list"))
      {
        localObject = new e(paramContext, (cn.dbox.core.bean.d)paramArrayList.get(i), this.d, false);
      }
      else if (((cn.dbox.core.bean.d)paramArrayList.get(i)).j().equals("feeds"))
      {
        localObject = new cn.dbox.ui.b.c(paramContext, (cn.dbox.core.bean.d)paramArrayList.get(i), this.d, false);
      }
      else if (((cn.dbox.core.bean.d)paramArrayList.get(i)).j().equals("card"))
      {
        localObject = new cn.dbox.ui.b.a(paramContext, (cn.dbox.core.bean.d)paramArrayList.get(i), this.d, false);
        continue;
        return localArrayList;
      }
    }
  }
  
  public void a(Context paramContext, final ArrayList<cn.dbox.core.bean.d> paramArrayList, ArrayList<cn.dbox.core.bean.a> paramArrayList1)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 1))
    {
      this.r = new a(paramContext, paramArrayList);
      this.r.a(new a.a()
      {
        public void a(int paramAnonymousInt, View paramAnonymousView, Object paramAnonymousObject)
        {
          if (b.a(b.this) != null)
          {
            b.this.o = true;
            if ((b.this.o) && (b.this.g != null)) {
              b.this.g.a((cn.dbox.core.bean.d)paramArrayList.get(paramAnonymousInt), b.e.c);
            }
            b.a(b.this).setCurrentItem(paramAnonymousInt, false);
          }
        }
      });
      addView(this.r);
    }
    this.s = b(paramContext, paramArrayList, paramArrayList1);
    addView(this.s);
  }
  
  public void a(cn.dbox.ui.d.a parama)
  {
    this.q = parama;
    if (this.u != null)
    {
      Iterator localIterator = this.u.iterator();
      while (localIterator.hasNext()) {
        ((cn.dbox.ui.b.b)localIterator.next()).a(parama);
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.v.containsKey(paramString))
    {
      int j = ((Integer)this.v.get(paramString)).intValue();
      int i = paramInt;
      if (j > paramInt) {
        i = j;
      }
      this.v.put(paramString, Integer.valueOf(i));
    }
    for (;;)
    {
      return;
      this.v.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public cn.dbox.ui.common.g b(Context paramContext, final ArrayList<cn.dbox.core.bean.d> paramArrayList, ArrayList<cn.dbox.core.bean.a> paramArrayList1)
  {
    paramArrayList1 = new cn.dbox.ui.common.g(paramContext);
    paramArrayList1.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    this.u = a(paramContext, paramArrayList);
    paramArrayList1.setAdapter(new cn.dbox.ui.a.d(this.u));
    paramArrayList1.setOnPageChangeListener(new cn.dbox.ui.d.d(new d.a()
    {
      public void a(int paramAnonymousInt)
      {
        if (b.b(b.this) != null)
        {
          int j = b.b(b.this).a();
          String str = ((cn.dbox.core.bean.d)b.c(b.this).get(j)).d();
          int i = ((cn.dbox.ui.b.b)b.d(b.this).get(j)).a();
          j = ((cn.dbox.ui.b.b)b.d(b.this).get(j)).b();
          b.this.a(str, i);
          b.this.b(str, j);
          b.this.n = paramAnonymousInt;
          b.b(b.this).b(paramAnonymousInt);
          if (paramAnonymousInt % 2 == 0) {
            b.b(b.this).scrollTo((paramAnonymousInt - 2) * k.a(b.this.k, 90), 0);
          }
          if ((!b.this.o) && (b.this.g != null)) {
            b.this.g.a((cn.dbox.core.bean.d)paramArrayList.get(paramAnonymousInt), b.e.b);
          }
          b.this.o = false;
        }
      }
    }));
    return paramArrayList1;
  }
  
  public HashMap<String, cn.dbox.core.bean.d> b()
  {
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext())
    {
      cn.dbox.core.bean.d locald = (cn.dbox.core.bean.d)localIterator.next();
      this.p.put(locald.d(), locald);
    }
    return this.p;
  }
  
  public void b(String paramString, int paramInt)
  {
    if (this.w.containsKey(paramString))
    {
      int j = ((Integer)this.w.get(paramString)).intValue();
      int i = paramInt;
      if (j > paramInt) {
        i = j;
      }
      this.w.put(paramString, Integer.valueOf(i));
    }
    for (;;)
    {
      return;
      this.w.put(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public HashMap<String, Integer> c()
  {
    if (this.v != null) {
      a(((cn.dbox.core.bean.d)this.t.get(this.n)).d(), ((cn.dbox.ui.b.b)this.u.get(this.n)).a());
    }
    return this.v;
  }
  
  public HashMap<String, Integer> d()
  {
    if (this.w != null) {
      b(((cn.dbox.core.bean.d)this.t.get(this.n)).d(), ((cn.dbox.ui.b.b)this.u.get(this.n)).b());
    }
    return this.w;
  }
  
  public int e()
  {
    return this.n;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */