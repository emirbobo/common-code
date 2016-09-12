package cn.dbox.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import cn.dbox.core.b.o;
import cn.dbox.core.h.d;
import cn.dbox.ui.d.g;

class a$7
  implements g
{
  a$7(a parama) {}
  
  public void a()
  {
    a.e().b("onClickBack");
    if (a.g(this.a) != null) {
      a.g(this.a).dismiss();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    a.e().b("onClickSendMessage:message:" + paramString1 + "tel:" + paramString2);
    if ((paramString1 == null) || (paramString1.equals("")) || (paramString1.length() > 500) || (paramString2.length() > 100)) {
      Toast.makeText(this.a.k, "留言为空或留言太多或联系方式太多", 1).show();
    }
    for (;;)
    {
      return;
      Toast.makeText(this.a.k, "发送成功", 1).show();
      a.a(this.a, b.o.d, paramString1, paramString2);
    }
  }
  
  public void b()
  {
    a.a(this.a, b.o.c, null, null);
  }
  
  public void c()
  {
    Intent localIntent = new Intent("android.intent.action.SENDTO");
    localIntent.setData(Uri.parse("mailto:duobaowu@163.com"));
    this.a.k.startActivity(localIntent);
    a.a(this.a, b.o.e, null, null);
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\a$7.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */