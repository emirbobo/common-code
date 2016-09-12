package cn.domob.wall.core.d;

import android.app.Dialog;

class d$2$1
  implements Runnable
{
  d$2$1(d.2 param2, String paramString) {}
  
  public void run()
  {
    d.b(this.b.b).a(this.a);
    if (d.a(this.b.b).isShowing()) {
      d.a().b("mDialog.isShowing");
    }
    for (;;)
    {
      return;
      d.a().b("mDialog.isNotShowing");
      d.a(this.b.b).show();
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\wall\core\d\d$2$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */