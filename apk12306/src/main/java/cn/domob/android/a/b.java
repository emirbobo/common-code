package cn.domob.android.a;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import cn.domob.android.offerwall.l;
import cn.domob.android.offerwall.m;
import java.io.File;
import java.util.Hashtable;

class b
  extends Handler
{
  b(a parama) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((paramMessage.what - a.a(this.a) < 5) && (paramMessage.what != 100)) {}
    for (;;)
    {
      return;
      a.a(this.a, paramMessage.what);
      a.b(this.a, paramMessage.what);
      if (a.c())
      {
        a.d(this.a).setLatestEventInfo(a.d(), a.b(this.a) + "正在下载", "已下载" + paramMessage.what + "%", a.c(this.a));
        a.f(this.a).notify(a.e(this.a), a.d(this.a));
      }
      if (a.g(this.a) == 100)
      {
        a.e().a(a.class, a.b(this.a) + " download success");
        paramMessage = new File(a.h(this.a));
        if (a.h(this.a).endsWith(".temp"))
        {
          a.a(this.a, a.h(this.a).substring(0, a.h(this.a).length() - ".temp".length()));
          File localFile = new File(a.h(this.a));
          a.e().a(a.class, a.b(this.a) + "FileName change to " + localFile);
          paramMessage.renameTo(localFile);
        }
        a.a.remove(a.i(this.a));
        if (a.j(this.a) != null) {
          a.j(this.a).a(a.h(this.a));
        }
        a.b(this.a, 0);
        if (a.c())
        {
          a.d(this.a).icon = 17301634;
          a.d(this.a).tickerText = (a.b(this.a) + "下载完毕");
          a.d(this.a).flags = 16;
          paramMessage = a.a(a.h(this.a));
          a.a(this.a, PendingIntent.getActivity(a.d(), a.e(this.a), paramMessage, 134217728));
          a.d(this.a).setLatestEventInfo(a.d(), a.b(this.a) + "下载完毕", "", a.c(this.a));
          a.f(this.a).notify(a.e(this.a), a.d(this.a));
          if ((a.k(this.a) != null) && (!a.k(this.a).equalsIgnoreCase(l.c(a.h(this.a)))))
          {
            a.j(this.a).b(a.i(this.a));
            a.e().b(a.d(), "md5 authorized failed");
            a.f(this.a).cancel(a.e(this.a));
          }
          else
          {
            paramMessage = a.a(a.h(this.a));
            paramMessage.addFlags(268435456);
            a.d().startActivity(paramMessage);
          }
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */