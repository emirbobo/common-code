package cn.domob.android.offerwall;

import android.app.Activity;

class a$d
  extends Thread
{
  private int b = 0;
  
  a$d(a parama) {}
  
  public void run()
  {
    while ((this.b < a.f(this.a)) && (!a.g(this.a))) {
      try
      {
        Thread.sleep(1000L);
        this.b += 1;
      }
      catch (InterruptedException localInterruptedException)
      {
        a.a().a(localInterruptedException);
      }
    }
    if ((this.b == a.f(this.a)) && (!a.g(this.a)) && (!a.a(this.a)))
    {
      a.a().e("WebView 加载超时");
      a.b(this.a, true);
      a.h(this.a);
      if (a.i(this.a)) {
        ((Activity)this.a.getContext()).runOnUiThread(new Runnable()
        {
          public void run()
          {
            a.d.this.a.stopLoading();
          }
        });
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\a$d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */