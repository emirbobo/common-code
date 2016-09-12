package cn.domob.android.ads.a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import cn.domob.android.i.f;

class b$c
  extends Handler
{
  private String b = "";
  
  b$c(b paramb, Context paramContext, String paramString)
  {
    this.b = paramString;
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    paramString = "javascript:" + paramString + "('" + paramBoolean + "')";
    b.b().a("excute js " + paramString);
    if (b.d(this.a) != null) {
      b.d(this.a).loadUrl(paramString);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return;
      a(this.b, false);
      b.b().b("upload picture failed");
      continue;
      a(this.b, true);
      b.b().b("upload picture successful");
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a\b$c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */