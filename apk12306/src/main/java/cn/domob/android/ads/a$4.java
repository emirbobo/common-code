package cn.domob.android.ads;

import android.app.Activity;
import cn.domob.android.f.g;
import cn.domob.android.f.h;
import cn.domob.android.i.f;

class a$4
  extends g
{
  a$4(a parama) {}
  
  public void a(final String paramString1, String paramString2)
  {
    int i = a.h(this.a).a().d();
    a.b().a("WebView data downloading status code = " + i);
    if ((i >= 200) && (i < 400))
    {
      a.b().a("Download HTML data:" + paramString1);
      ((Activity)this.a.getContext()).runOnUiThread(new Runnable()
      {
        public void run()
        {
          a.4.this.a.loadDataWithBaseURL(a.i(a.4.this.a), paramString1, "text/html", "UTF-8", null);
        }
      });
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\a$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */