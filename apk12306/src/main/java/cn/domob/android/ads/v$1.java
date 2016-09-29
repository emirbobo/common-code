package cn.domob.android.ads;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageButton;
import cn.domob.android.i.f;

class v$1
  extends Handler
{
  v$1(v paramv, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      ((ImageButton)paramMessage.obj).setVisibility(0);
      continue;
      v.b().a("Arrival auto-off time");
      if (v.a(this.a).isShowing())
      {
        v.a(this.a).dismiss();
        continue;
        v.b().a("the time of ad to reach the minimum");
        v.a(this.a).setCancelable(true);
        if (v.e.a(v.b(this.a)) != null) {
          v.e.a(v.b(this.a)).b();
        }
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\v$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */