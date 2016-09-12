package cn.domob.android.a.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import cn.domob.android.i.f;
import java.util.Timer;
import java.util.TimerTask;

public class a
  extends RelativeLayout
{
  private static final int b = 100;
  private static final int j = Color.rgb(0, 0, 0);
  private static final int k = 75;
  private static final int l = 1;
  private static final int m = 2;
  private static final int n = -1;
  private static final String o = "秒";
  private f a = new f(a.class.getSimpleName());
  private Context c;
  private a d;
  private Timer e;
  private TextView f;
  private int g;
  private int h;
  private int i;
  
  public a(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.c = paramContext;
    this.g = paramInt;
    this.h = e();
    this.i = 1;
    f();
  }
  
  private int e()
  {
    int i2 = this.g / 1000;
    if (this.g % 1000 > 0) {}
    for (int i1 = 1;; i1 = 0) {
      return i1 + i2;
    }
  }
  
  private void f()
  {
    g();
    h();
  }
  
  private void g()
  {
    setBackgroundColor(j);
    getBackground().setAlpha(75);
  }
  
  private void h()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.f = new TextView(this.c);
    this.f.setTextColor(-1);
    this.f.setText(i());
    addView(this.f, localLayoutParams);
  }
  
  private String i()
  {
    return this.h + "秒";
  }
  
  private void j()
  {
    if (this.e == null)
    {
      this.a.b("create countdown Timer");
      TimerTask local1 = new TimerTask()
      {
        public void run()
        {
          a.a(a.this);
        }
      };
      this.e = new Timer();
      this.e.scheduleAtFixedRate(local1, 100L, 100L);
    }
  }
  
  private void k()
  {
    if (this.i == 2)
    {
      this.g -= 100;
      if (this.g <= 0) {
        break label49;
      }
      int i1 = e();
      if (i1 < this.h)
      {
        this.h = i1;
        l();
      }
    }
    for (;;)
    {
      return;
      label49:
      this.a.b("countdown finished");
      this.i = 1;
      if (this.d != null) {
        this.d.a();
      }
    }
  }
  
  private void l()
  {
    ((Activity)this.c).runOnUiThread(new Runnable()
    {
      public void run()
      {
        a.c(a.this).setText(a.b(a.this));
      }
    });
  }
  
  private void m()
  {
    this.a.b("countdown destroy");
    this.i = 1;
    if (this.e != null) {
      this.e.cancel();
    }
    a(null);
  }
  
  public int a()
  {
    return this.g;
  }
  
  public void a(a parama)
  {
    this.d = parama;
  }
  
  public void b()
  {
    this.a.b("countdown start");
    this.i = 2;
    j();
  }
  
  public void c()
  {
    this.a.b("countdown paused");
    this.i = 1;
  }
  
  public void d()
  {
    this.a.b("countdown resume");
    this.i = 2;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.a.b("countdown detached from window");
    m();
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */