package cn.dbox.ui.common;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RelativeLayout;
import cn.dbox.core.b.d;
import cn.dbox.core.bean.d.a;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class b
  extends RelativeLayout
{
  private static cn.dbox.core.h.d c = new cn.dbox.core.h.d(b.class.getSimpleName());
  ArrayList<cn.dbox.core.bean.a> a = new ArrayList();
  public cn.dbox.ui.d.a b;
  private Context d;
  private cn.dbox.core.b e;
  private int f;
  private int g;
  private View h;
  private DBoxGallery i;
  private cn.dbox.ui.a.c j;
  private String k;
  private String l;
  private int m = 0;
  private int n = 0;
  private int o = 0;
  private Timer p;
  private a q;
  
  public b(Context paramContext, d.a parama, cn.dbox.core.b paramb, String paramString1, String paramString2)
  {
    super(paramContext);
    this.d = paramContext;
    this.e = paramb;
    this.k = paramString1;
    this.l = paramString2;
    this.a = parama.c();
    this.g = parama.a();
    this.f = this.a.size();
    a(paramContext);
    if (this.f > 1)
    {
      if (this.g < 5) {
        this.g = 5;
      }
      a(this.g);
    }
  }
  
  private void a(int paramInt)
  {
    c.b("autoscroll:" + paramInt);
    this.o = paramInt;
    if ((this.o <= 5) && (this.o > 0)) {
      this.o = 5;
    }
    if (this.o > 0)
    {
      if (this.p != null) {
        this.p.cancel();
      }
      this.p = new Timer();
      this.q = new a(null);
      this.p.scheduleAtFixedRate(this.q, 0L, this.o * 1000);
    }
  }
  
  public int a()
  {
    return this.n;
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    setBackgroundColor(-1);
    this.h = ((RelativeLayout)LayoutInflater.from(paramContext).inflate(cn.dbox.ui.e.d.a(paramContext, "dbox_banner"), null));
    this.i = ((DBoxGallery)this.h.findViewById(cn.dbox.ui.e.c.a(paramContext, "gallery")));
    this.j = new cn.dbox.ui.a.c(paramContext, this.a, this.e);
    this.i.setAdapter(this.j);
    this.i.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (b.this.b != null) {
          b.this.b.a((cn.dbox.core.bean.a)b.this.a.get(paramAnonymousInt % b.this.a.size()), b.d.c, b.a(b.this), b.b(b.this));
        }
      }
    });
    this.i.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
    {
      public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        b.b().b("onItemSelected:" + paramAnonymousInt);
        paramAnonymousAdapterView = b.this;
        if (b.c(b.this) > paramAnonymousInt % b.d(b.this) + 1) {}
        for (paramAnonymousInt = b.c(b.this);; paramAnonymousInt = paramAnonymousInt % b.d(b.this) + 1)
        {
          b.a(paramAnonymousAdapterView, paramAnonymousInt);
          return;
        }
      }
      
      public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
      {
        b.b().b("onNothingSelected");
      }
    });
    addView(this.h);
  }
  
  public void a(cn.dbox.ui.d.a parama)
  {
    this.b = parama;
  }
  
  private class a
    extends TimerTask
  {
    private a() {}
    
    public void run()
    {
      if ((b.e(b.this) != null) && (b.e(b.this).hasWindowFocus()) && (!b.e(b.this).isOnGalleryTouch()))
      {
        b.b().b("start auto scroll: " + toString());
        ((Activity)b.f(b.this)).runOnUiThread(new Runnable()
        {
          public void run()
          {
            b.e(b.this).onKeyDown(22, null);
          }
        });
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\common\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */