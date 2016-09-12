package cn.domob.android.offerwall;

class DomobOfferWallView$3
  implements Runnable
{
  DomobOfferWallView$3(DomobOfferWallView paramDomobOfferWallView, String paramString) {}
  
  public void run()
  {
    DomobOfferWallView.b(this.b).a(String.format("domob.setData(%s)", new Object[] { this.a }));
    DomobOfferWallView.b(this.b).invalidate();
    if (DomobOfferWallView.c(this.b) != null) {
      DomobOfferWallView.c(this.b).onOfferWallLoadFinished(this.b);
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\DomobOfferWallView$3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */