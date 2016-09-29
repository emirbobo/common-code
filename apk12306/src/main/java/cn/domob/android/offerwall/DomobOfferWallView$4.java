package cn.domob.android.offerwall;

class DomobOfferWallView$4
  implements Runnable
{
  DomobOfferWallView$4(DomobOfferWallView paramDomobOfferWallView, String paramString) {}
  
  public void run()
  {
    DomobOfferWallView.b(this.b).a(String.format("domob.failed(%s)", new Object[] { this.a }));
    DomobOfferWallView.b(this.b).invalidate();
    if ("404".equals(this.a)) {
      if (DomobOfferWallView.c(this.b) != null) {
        DomobOfferWallView.c(this.b).onOfferWallLoadFinished(this.b);
      }
    }
    for (;;)
    {
      return;
      if (DomobOfferWallView.c(this.b) != null) {
        DomobOfferWallView.c(this.b).onOfferWallLoadFailed(this.b);
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\DomobOfferWallView$4.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */