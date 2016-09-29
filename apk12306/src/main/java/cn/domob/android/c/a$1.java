package cn.domob.android.c;

import android.app.AlertDialog.Builder;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import cn.domob.android.i.d;
import cn.domob.android.i.f;
import java.io.File;
import java.util.Hashtable;

class a$1
  extends Handler
{
  a$1(a parama, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    super.handleMessage(paramMessage);
    if ((paramMessage.what - a.a(this.a) < 5) && (paramMessage.what != 100)) {}
    do
    {
      return;
      a.a(this.a, paramMessage.what);
      a.b(this.a, paramMessage.what);
      if (a.b(this.a))
      {
        a.e(this.a).setLatestEventInfo(a.b(), a.c(this.a) + "正在下载", "已下载" + paramMessage.what + "%", a.d(this.a));
        a.g(this.a).notify(a.f(this.a), a.e(this.a));
      }
    } while (a.h(this.a) != 100);
    a.c().a(a.class, a.c(this.a) + " download success");
    File localFile = new File(a.i(this.a));
    if (a.i(this.a).endsWith(".temp"))
    {
      a.a(this.a, a.i(this.a).substring(0, a.i(this.a).length() - ".temp".length()));
      paramMessage = new File(a.i(this.a));
      a.c().a(a.class, a.c(this.a) + "FileName change to " + paramMessage);
      localFile.renameTo(paramMessage);
    }
    if (a.j(this.a) == 0)
    {
      localObject1 = BitmapFactory.decodeFile(localFile.getAbsolutePath());
      int i = 0;
      paramMessage = null;
      while ((i < 2) && (paramMessage == null))
      {
        paramMessage = MediaStore.Images.Media.insertImage(a.b().getContentResolver(), (Bitmap)localObject1, localFile.getName(), localFile.getName());
        i++;
      }
      a.c().b("fetch picture ablum path " + paramMessage);
      localObject1 = paramMessage;
      if (paramMessage == null)
      {
        a.c().b("insert " + localFile.getAbsolutePath() + " failed, change the resType to other");
        a.c(this.a, 1);
      }
    }
    for (Object localObject1 = paramMessage;; localObject1 = null)
    {
      a.a.remove(a.k(this.a));
      if (a.l(this.a) != null) {
        a.l(this.a).a(a.i(this.a), a.m(this.a));
      }
      a.b(this.a, 0);
      if (!a.b(this.a)) {
        break;
      }
      a.e(this.a).icon = 17301634;
      a.e(this.a).tickerText = (a.c(this.a) + "下载完毕");
      a.e(this.a).flags = 16;
      if (a.n(this.a)) {
        if (a.j(this.a) == 0) {
          paramMessage = a.c((String)localObject1);
        }
      }
      for (;;)
      {
        a.a(this.a, PendingIntent.getActivity(a.b(), a.f(this.a), paramMessage, 134217728));
        a.e(this.a).setLatestEventInfo(a.b(), a.c(this.a) + "下载完毕", "", a.d(this.a));
        a.g(this.a).notify(a.f(this.a), a.e(this.a));
        if ((a.o(this.a) == null) || (a.o(this.a).equalsIgnoreCase(d.a(a.i(this.a))))) {
          break label825;
        }
        a.l(this.a).a(a.k(this.a));
        a.c().b(a.b(), "md5 authorized failed");
        a.g(this.a).cancel(a.f(this.a));
        break;
        paramMessage = new Intent();
        continue;
        paramMessage = a.a(a.i(this.a));
      }
      label825:
      if (a.n(this.a)) {
        if (a.j(this.a) == 0) {
          paramMessage = a.c((String)localObject1);
        }
      }
      for (;;)
      {
        if (paramMessage == null) {
          break label980;
        }
        paramMessage.addFlags(268435456);
        a.b().startActivity(paramMessage);
        break;
        new AlertDialog.Builder(a.d()).setTitle("确认").setMessage(a.c(this.a) + "已被下载到路径:" + a.i(this.a)).setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }).show();
        a.g(this.a).cancel(a.f(this.a));
        paramMessage = (Message)localObject2;
        continue;
        paramMessage = a.a(a.i(this.a));
      }
      label980:
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\c\a$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */