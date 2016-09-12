package cn.domob.android.offerwall;

public abstract interface DomobOfferWallListener
{
  public abstract void onOfferWallLoadFailed(DomobOfferWallView paramDomobOfferWallView);
  
  public abstract void onOfferWallLoadFinished(DomobOfferWallView paramDomobOfferWallView);
  
  public abstract void onOfferWallLoadStart(DomobOfferWallView paramDomobOfferWallView);
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\cn\domob\android\offerwall\DomobOfferWallListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */