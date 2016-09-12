package cn.domob.android.ads.b;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import cn.domob.android.ads.a;
import cn.domob.android.ads.a.d.b;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

public class m
  extends a
{
  public static final int e = 100;
  public static final int f = 101;
  public static final int g = 102;
  private static cn.domob.android.i.f h = new cn.domob.android.i.f(m.class.getSimpleName());
  a d;
  private h i;
  private final k j;
  private c k;
  private d.b l;
  
  public m(Context paramContext)
  {
    this(paramContext, b.a, d.c, k.a);
  }
  
  m(Context paramContext, b paramb, d paramd, k paramk)
  {
    super(paramContext, 0);
    this.j = paramk;
    a(paramb, paramd);
  }
  
  private void a(b paramb, d paramd)
  {
    setScrollContainer(false);
    setBackgroundColor(0);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          return false;
          if (!paramAnonymousView.hasFocus()) {
            paramAnonymousView.requestFocus();
          }
        }
      }
    });
    getSettings().setJavaScriptEnabled(true);
    this.i = new h(this, paramb, paramd);
    this.k = new c();
  }
  
  public String a(String paramString, String[] paramArrayOfString)
  {
    return super.a(paramString, new String[] { "domob.js", "mraid.js" });
  }
  
  public void a(d.b paramb)
  {
    this.l = paramb;
  }
  
  protected void a(j paramj)
  {
    paramj = "{" + paramj.toString() + "}";
    a("window.mraidbridge.fireChangeEvent(" + paramj + ");");
    h.b("Fire change: " + paramj);
  }
  
  public void a(a parama)
  {
    this.d = parama;
  }
  
  protected void a(e parame)
  {
    c.a(this.k, parame);
  }
  
  protected void a(f paramf)
  {
    c.a(this.k, paramf);
  }
  
  protected void a(g paramg)
  {
    c.a(this.k, paramg);
  }
  
  protected void a(h paramh)
  {
    c.a(this.k, paramh);
  }
  
  protected void a(i parami)
  {
    c.a(this.k, parami);
  }
  
  protected void a(j paramj)
  {
    c.a(this.k, paramj);
  }
  
  protected void a(ArrayList<j> paramArrayList)
  {
    paramArrayList = paramArrayList.toString();
    if (paramArrayList.length() < 2) {}
    for (;;)
    {
      return;
      paramArrayList = "{" + paramArrayList.substring(1, paramArrayList.length() - 1) + "}";
      a("window.mraidbridge.fireChangeEvent(" + paramArrayList + ");");
      h.b("Fire changes: " + paramArrayList);
    }
  }
  
  public boolean a(URI paramURI)
  {
    String str = paramURI.getHost();
    h.a("Command type is:" + str);
    Object localObject = URLEncodedUtils.parse(paramURI, "UTF-8");
    paramURI = new HashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      NameValuePair localNameValuePair = (NameValuePair)((Iterator)localObject).next();
      paramURI.put(localNameValuePair.getName(), localNameValuePair.getValue());
    }
    paramURI = f.a(str, paramURI, this);
    if (paramURI == null) {
      b(str);
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      paramURI.a();
      b(str);
    }
  }
  
  protected void b(String paramString)
  {
    a("window.mraidbridge.nativeCallComplete('" + paramString + "');");
  }
  
  protected void b(String paramString1, String paramString2)
  {
    a("window.mraidbridge.fireErrorEvent('" + paramString1 + "', '" + paramString2 + "');");
  }
  
  protected h c()
  {
    return this.i;
  }
  
  protected g d()
  {
    return c.a(this.k);
  }
  
  public void destroy()
  {
    this.i.a();
    super.destroy();
  }
  
  protected f e()
  {
    return c.b(this.k);
  }
  
  protected j f()
  {
    return c.c(this.k);
  }
  
  protected h g()
  {
    return c.d(this.k);
  }
  
  protected e h()
  {
    return c.e(this.k);
  }
  
  protected i i()
  {
    return c.f(this.k);
  }
  
  protected a j()
  {
    return this.d;
  }
  
  protected d.b k()
  {
    return this.l;
  }
  
  protected void l()
  {
    this.i.b();
    a(i.a(this.j));
    m();
    if (f() != null) {
      f().a(this);
    }
  }
  
  protected void m()
  {
    a("window.mraidbridge.fireReadyEvent();");
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  static enum b
  {
    private b() {}
  }
  
  static class c
  {
    private m.g a;
    private m.f b;
    private m.j c;
    private m.h d;
    private m.e e;
    private m.i f;
  }
  
  static enum d
  {
    private d() {}
  }
  
  public static abstract interface e
  {
    public abstract void a(m paramm, boolean paramBoolean);
  }
  
  public static abstract interface f
  {
    public abstract void a(m paramm, m.l paraml);
  }
  
  public static abstract interface g
  {
    public abstract void a(m paramm);
  }
  
  public static abstract interface h
  {
    public abstract void a(m paramm);
  }
  
  public static abstract interface i
  {
    public abstract void a(m paramm);
  }
  
  public static abstract interface j
  {
    public abstract void a(m paramm);
  }
  
  static enum k
  {
    private k() {}
  }
  
  public static enum l
  {
    private l() {}
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\b\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */