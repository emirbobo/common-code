package cn.domob.android.offerwall;

import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class h
  implements d.a, g.a
{
  private static m a = new m(h.class.getSimpleName());
  private DomobOfferWallView b;
  private k c;
  
  h(DomobOfferWallView paramDomobOfferWallView)
  {
    this.b = paramDomobOfferWallView;
    d.a(this.b.getContext(), this);
  }
  
  protected void a()
  {
    new j(this.b.getContext()).a(new j.a()
    {
      public void a(k paramAnonymousk)
      {
        h.d().b("Offer Info Request Finished.");
        if (paramAnonymousk != null)
        {
          h.d().b("DomobOfferResponse to String: " + paramAnonymousk.toString());
          h.a(h.this, paramAnonymousk);
          h.a(h.this).a(paramAnonymousk.d());
        }
        for (;;)
        {
          return;
          h.d().e("Response is null.");
          h.a(h.this).a();
        }
      }
    });
  }
  
  protected void a(int paramInt)
  {
    if ((this.c != null) && (this.c.e() != null) && (this.c.e().get(Integer.valueOf(paramInt)) != null))
    {
      Object localObject = ((k.a)this.c.e().get(Integer.valueOf(paramInt))).e();
      localObject = new g(this.b.getContext(), (String)localObject, this);
      if (paramInt != -1)
      {
        k.a locala = (k.a)this.c.e().get(Integer.valueOf(paramInt));
        ((g)localObject).a(paramInt);
        ((g)localObject).a(locala.c());
        ((g)localObject).b(locala.d());
      }
      ((g)localObject).e();
    }
  }
  
  public void a(g paramg)
  {
    i.a locala = new i.a();
    locala.a = "installed";
    locala.b.add(paramg.c());
    locala.c = "http://duomeng.cn/api/12306/rp";
    i.a(this.b.getContext(), locala);
  }
  
  protected void b()
  {
    i.a locala = new i.a();
    locala.a = "show_list";
    Iterator localIterator = this.c.e().keySet().iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      locala.b.add(String.valueOf(i));
    }
    locala.c = "http://duomeng.cn/api/12306/rp";
    i.a(this.b.getContext(), locala);
  }
  
  protected void b(int paramInt)
  {
    i.a locala = new i.a();
    locala.a = "show_detail";
    locala.b.add(String.valueOf(paramInt));
    locala.c = "http://duomeng.cn/api/12306/rp";
    i.a(this.b.getContext(), locala);
  }
  
  public void b(g paramg) {}
  
  protected void c()
  {
    i.a locala = new i.a();
    locala.a = "close_list";
    locala.c = "http://duomeng.cn/api/12306/rp";
    i.a(this.b.getContext(), locala);
  }
  
  public void c(g paramg)
  {
    i.a locala = new i.a();
    locala.a = "download_finish";
    locala.b.add(String.valueOf(paramg.a()));
    locala.c = "http://duomeng.cn/api/12306/rp";
    i.a(this.b.getContext(), locala);
  }
  
  public void d(g paramg) {}
  
  public void e(g paramg)
  {
    int i = paramg.a();
    paramg = (k.a)this.c.e().get(Integer.valueOf(i));
    i.a locala = new i.a();
    locala.a = "download";
    locala.b = new ArrayList();
    locala.b.add(String.valueOf(i));
    if (paramg.b() == null) {}
    for (paramg = "http://duomeng.cn/api/12306/rp";; paramg = paramg.b())
    {
      locala.c = paramg;
      i.a(this.b.getContext(), locala);
      return;
    }
  }
  
  public void f(g paramg) {}
  
  public void g(g paramg)
  {
    try
    {
      Toast.makeText(this.b.getContext(), "App下载中", 0).show();
      return;
    }
    catch (Exception paramg)
    {
      for (;;)
      {
        a.a(paramg);
      }
    }
  }
  
  public void h(g paramg) {}
  
  public void i(g paramg)
  {
    d.a().a(paramg);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */