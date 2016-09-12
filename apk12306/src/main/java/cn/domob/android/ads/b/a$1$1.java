package cn.domob.android.ads.b;

import cn.domob.android.ads.DomobAdManager.ErrorCode;
import cn.domob.android.ads.a.b;
import cn.domob.android.i.f;

class a$1$1
  implements a.b
{
  a$1$1(a.1 param1) {}
  
  public void a(cn.domob.android.ads.a parama)
  {
    a.n().a("Finished to load MRAID banner view.");
    a.d(this.a.b);
  }
  
  public void b(cn.domob.android.ads.a parama)
  {
    a.n().e("FAILED to load domob banner view.");
    a.b(this.a.b, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load failed.");
  }
  
  public void c(cn.domob.android.ads.a parama)
  {
    a.a(this.a.b, DomobAdManager.ErrorCode.INTERNAL_ERROR, "Creative load timeout.");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\b\a$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */