package cn.dbox.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import cn.dbox.core.bean.Entrance.EntryReportType;
import cn.dbox.core.bean.d;
import cn.dbox.core.bean.g;
import cn.dbox.core.d.l;
import java.util.ArrayList;

public class b
{
  private static String e = "online";
  private c a;
  private a b;
  private l c;
  private j d;
  
  public b(Context paramContext, String paramString1, String paramString2)
  {
    this.a = new c(paramContext, paramString1, paramString2);
    this.b = new a(paramContext, this.a);
    this.c = l.a(paramContext);
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    this.a.a(paramString1, paramInt, paramString2);
  }
  
  public static String c()
  {
    return e;
  }
  
  public static void c(String paramString)
  {
    e = paramString;
  }
  
  public void a()
  {
    this.a.a(null, 0, null);
  }
  
  public void a(f paramf, d paramd, e parame)
  {
    this.b.a(paramf, paramd, parame);
  }
  
  public void a(j paramj)
  {
    this.d = paramj;
    if (this.b != null) {
      this.b.a(paramj);
    }
  }
  
  public void a(l paraml)
  {
    this.a.a(paraml);
  }
  
  public void a(m paramm)
  {
    this.a.a(paramm);
  }
  
  public void a(o paramo, String paramString1, String paramString2)
  {
    this.b.a(paramo, paramString1, paramString2);
  }
  
  public void a(Entrance.EntryReportType paramEntryReportType)
  {
    this.b.a(paramEntryReportType);
  }
  
  public void a(cn.dbox.core.bean.a parama)
  {
    this.b.a(parama);
  }
  
  public void a(cn.dbox.core.bean.a parama, a parama1, d paramd)
  {
    this.b.a(parama, parama1, paramd);
  }
  
  public void a(cn.dbox.core.bean.a parama, b paramb)
  {
    this.b.a(parama, paramb);
  }
  
  public void a(d paramd, b paramb)
  {
    this.b.a(paramd, paramb);
  }
  
  public void a(String paramString)
  {
    a(null, 0, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    this.a.a(paramString, paramInt, null);
  }
  
  public void a(String paramString, ImageView paramImageView, k paramk)
  {
    this.c.a(paramString, paramImageView, paramk);
  }
  
  public void a(String paramString1, b paramb, String paramString2)
  {
    this.b.a(paramString1, paramb, paramString2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.a != null) {
      this.a.a(paramString1, paramString2);
    }
  }
  
  public void a(ArrayList<cn.dbox.core.bean.a> paramArrayList, String paramString)
  {
    this.b.a(paramArrayList, paramString);
  }
  
  public void b()
  {
    a(null, 0, null);
  }
  
  public void b(Entrance.EntryReportType paramEntryReportType)
  {
    this.b.b(paramEntryReportType);
  }
  
  public void b(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void d()
  {
    this.c.b();
  }
  
  public void d(String paramString)
    throws Exception
  {
    this.b.a(null, paramString);
  }
  
  public void e()
  {
    this.c.c();
  }
  
  public void e(String paramString)
  {
    this.a.a(paramString);
  }
  
  public String f()
  {
    return this.a.q();
  }
  
  public void g()
  {
    this.a.s();
  }
  
  public static enum a
  {
    private a() {}
  }
  
  public static enum b
  {
    private b() {}
  }
  
  public static enum c
  {
    private c() {}
  }
  
  public static enum d
  {
    private d() {}
  }
  
  public static enum e
  {
    private e() {}
  }
  
  public static enum f
  {
    private f() {}
  }
  
  public static enum g
  {
    private g() {}
  }
  
  public static enum h
  {
    private h() {}
  }
  
  public static enum i
  {
    private i() {}
  }
  
  public static abstract interface j
  {
    public abstract void a();
  }
  
  public static abstract interface k
  {
    public abstract void a(Bitmap paramBitmap, String paramString, ImageView paramImageView);
    
    public abstract void a(String paramString, ImageView paramImageView);
  }
  
  public static abstract interface l
  {
    public abstract void a(b.h paramh, String paramString1, String paramString2, int paramInt);
    
    public abstract void a(g paramg, ArrayList<cn.dbox.core.bean.c> paramArrayList, ArrayList<cn.dbox.core.bean.a> paramArrayList1, String paramString, int paramInt);
  }
  
  public static abstract interface m
  {
    public abstract void a(b.h paramh, String paramString1, String paramString2, int paramInt);
    
    public abstract void a(g paramg, ArrayList<cn.dbox.core.bean.c> paramArrayList, ArrayList<cn.dbox.core.bean.a> paramArrayList1, String paramString, int paramInt);
  }
  
  public static enum n
  {
    private n() {}
  }
  
  public static enum o
  {
    private o() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */