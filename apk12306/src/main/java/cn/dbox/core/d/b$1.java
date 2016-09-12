package cn.dbox.core.d;

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
import android.os.Message;
import android.provider.MediaStore.Images.Media;
import cn.dbox.core.h.d;
import cn.dbox.core.h.f;
import java.io.File;
import java.util.Hashtable;

class b$1
  extends Handler
{
  b$1(b paramb) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    super.handleMessage(paramMessage);
    if ((paramMessage.what - b.a(this.a) < 5) && (paramMessage.what != 100)) {}
    do
    {
      return;
      b.a(this.a, paramMessage.what);
      b.b(this.a, paramMessage.what);
      if (b.c())
      {
        b.e(this.a).setLatestEventInfo(b.b(this.a), b.c(this.a) + "正在下载", "已下载" + paramMessage.what + "%", b.d(this.a));
        b.g(this.a).notify(b.f(this.a), b.e(this.a));
      }
    } while (b.h(this.a) != 100);
    b.d().a(b.class, b.c(this.a) + " download success");
    File localFile = new File(b.i(this.a));
    if (b.i(this.a).endsWith(".temp"))
    {
      b.a(this.a, b.i(this.a).substring(0, b.i(this.a).length() - ".temp".length()));
      paramMessage = new File(b.i(this.a));
      b.d().a(b.class, b.c(this.a) + "FileName change to " + paramMessage);
      localFile.renameTo(paramMessage);
    }
    if (b.j(this.a) == 0)
    {
      localObject1 = BitmapFactory.decodeFile(localFile.getAbsolutePath());
      int i = 0;
      paramMessage = null;
      while ((i < 2) && (paramMessage == null))
      {
        paramMessage = MediaStore.Images.Media.insertImage(b.b(this.a).getContentResolver(), (Bitmap)localObject1, localFile.getName(), localFile.getName());
        i++;
      }
      b.d().b("fetch picture ablum path " + paramMessage);
      localObject1 = paramMessage;
      if (paramMessage == null)
      {
        b.d().b("insert " + localFile.getAbsolutePath() + " failed, change the resType to other");
        b.c(this.a, 1);
      }
    }
    for (Object localObject1 = paramMessage;; localObject1 = null)
    {
      b.a.remove(b.k(this.a));
      if (b.l(this.a) != null) {
        b.l(this.a).a(b.i(this.a));
      }
      b.b(this.a, 0);
      if (!b.c()) {
        break;
      }
      b.e(this.a).icon = 17301634;
      b.e(this.a).tickerText = (b.c(this.a) + "下载完毕");
      b.e(this.a).flags = 16;
      if (b.m(this.a)) {
        if (b.j(this.a) == 0) {
          paramMessage = b.b(this.a, (String)localObject1);
        }
      }
      for (;;)
      {
        b.a(this.a, PendingIntent.getActivity(b.b(this.a), b.f(this.a), paramMessage, 134217728));
        b.e(this.a).setLatestEventInfo(b.b(this.a), b.c(this.a) + "下载完毕", "", b.d(this.a));
        b.g(this.a).notify(b.f(this.a), b.e(this.a));
        if ((b.n(this.a) == null) || (b.n(this.a).equalsIgnoreCase(f.d(b.i(this.a))))) {
          break label815;
        }
        b.d().b(b.b(this.a), "md5 authorized failed");
        b.g(this.a).cancel(b.f(this.a));
        break;
        paramMessage = new Intent();
        continue;
        paramMessage = b.a(b.i(this.a));
      }
      label815:
      if (b.m(this.a)) {
        if (b.j(this.a) == 0) {
          paramMessage = b.b(this.a, (String)localObject1);
        }
      }
      for (;;)
      {
        if (paramMessage == null) {
          break label982;
        }
        paramMessage.addFlags(268435456);
        b.b(this.a).startActivity(paramMessage);
        break;
        new AlertDialog.Builder(b.o(this.a)).setTitle("确认").setMessage(b.c(this.a) + "已被下载到路径:" + b.i(this.a)).setPositiveButton("确定", new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }).show();
        b.g(this.a).cancel(b.f(this.a));
        paramMessage = (Message)localObject2;
        continue;
        paramMessage = b.a(b.i(this.a));
      }
      label982:
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\core\d\b$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */