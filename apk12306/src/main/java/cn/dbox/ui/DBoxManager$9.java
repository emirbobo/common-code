package cn.dbox.ui;

import android.app.Dialog;
import cn.dbox.ui.b.d;
import cn.dbox.ui.b.d.a;

class DBoxManager$9
  implements Runnable
{
  DBoxManager$9(DBoxManager paramDBoxManager, String paramString) {}
  
  public void run()
  {
    DBoxManager.a(this.b, new Dialog(DBoxManager.g(this.b), 16973840));
    d locald = new d(DBoxManager.g(this.b), this.a, DBoxManager.k(this.b));
    locald.a(new d.a()
    {
      public void a()
      {
        if ((DBoxManager.m(DBoxManager.9.this.b) != null) && (DBoxManager.m(DBoxManager.9.this.b).isShowing())) {
          DBoxManager.m(DBoxManager.9.this.b).dismiss();
        }
      }
    });
    DBoxManager.m(this.b).setCancelable(false);
    DBoxManager.m(this.b).setContentView(locald);
    DBoxManager.m(this.b).show();
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\dbox\ui\DBoxManager$9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */