package cn.domob.android.ads;

import android.app.Activity;
import cn.domob.android.i.f;

class a$c
  extends Thread
{
  private int b = 0;
  
  a$c(a parama) {}
  
  public void run()
  {
    while ((this.b < a.d(this.a)) && (!a.e(this.a))) {
      try
      {
        Thread.sleep(1000L);
        this.b += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        a.b().a(localInterruptedException);
      }
    }
    if ((this.b == a.d(this.a)) && (!a.e(this.a)) && (!a.a(this.a)))
    {
      a.b().e("WebView 加载超时");
      a.b(this.a, true);
      a.f(this.a);
      if (a.g(this.a)) {
        ((Activity)this.a.getContext()).runOnUiThread(new Runnable()
        {
          public void run()
          {
            try
            {
              a.c.this.a.stopLoading();
              return;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                a.b().a(localException);
              }
            }
          }
        });
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */