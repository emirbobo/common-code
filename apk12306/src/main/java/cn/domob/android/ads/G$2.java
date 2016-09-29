package cn.domob.android.ads;

class g$2
  implements Runnable
{
  g$2(g paramg, DomobAdManager.ErrorCode paramErrorCode) {}
  
  public void run()
  {
    if (this.b.d.f() != null) {
      this.b.d.f().onFailedToReceiveFreshAd(this.b.d);
    }
    if (this.b.d.g() != null) {
      this.b.d.g().onDomobAdFailed(this.b.d, this.a);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\ads\G$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */