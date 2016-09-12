package a.a.a.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import cn.domob.android.i.f;

class d$b
  extends BroadcastReceiver
{
  d$b(d paramd) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.wifi.STATE_CHANGE".equals(paramIntent.getAction()))
    {
      paramIntent = paramIntent.getParcelableExtra("networkInfo");
      if (paramIntent != null)
      {
        paramIntent = (NetworkInfo)paramIntent;
        switch (d.1.a[paramIntent.getState().ordinal()])
        {
        }
      }
    }
    for (;;)
    {
      return;
      d.a(this.a).b("detected wifi is connected");
      this.a.d(paramContext);
      continue;
      d.a(this.a).b("detected wifi is disconnected");
      d.d();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\a\a\a\a\a\d$b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */