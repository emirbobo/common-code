package cn.domob.android.j;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.domob.android.i.f;
import cn.domob.android.i.h;

public class c
  extends BroadcastReceiver
{
  private static f a = new f(c.class.getSimpleName());
  private Context b;
  private IntentFilter c;
  private a d;
  
  public c(Context paramContext, a parama)
  {
    this.b = paramContext.getApplicationContext();
    this.c = new IntentFilter();
    this.c.addAction("android.intent.action.SCREEN_ON");
    this.c.addAction("android.intent.action.SCREEN_OFF");
    this.d = parama;
  }
  
  public void a()
  {
    if (this.b != null) {
      this.b.registerReceiver(this, this.c);
    }
  }
  
  public void a(a parama)
  {
    this.d = parama;
  }
  
  public void b()
  {
    if (this.b != null) {
      this.b.unregisterReceiver(this);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((this.d != null) && (!h.e(paramContext)))
    {
      if (!paramContext.equals("android.intent.action.SCREEN_OFF")) {
        break label46;
      }
      a.b("screen off");
      this.d.b();
    }
    for (;;)
    {
      return;
      label46:
      if (paramContext.equals("android.intent.action.SCREEN_ON"))
      {
        a.b("screen on");
        this.d.a();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\j\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */